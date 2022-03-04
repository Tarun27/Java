package datastructures.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class IterativeTreeTraversals {

	public LinkedList<Integer> iterativePreorder(TreeNode node) {
		Stack<TreeNode> stk = new Stack<TreeNode>();
		LinkedList<Integer> list = new LinkedList<Integer>();

		if (node == null) {
			return list;
		}
		stk.push(node);

		while (!stk.isEmpty()) {
			TreeNode curr = stk.pop();
			list.add(curr.val);

			if (curr.right != null) {
				stk.add(curr.right);
			}
			if (curr.left != null) {
				stk.add(curr.left);
			}

		}

		return list;
	}

	
	public  List<Integer> iterativeInorder(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		pushAllLeft(root, stack);

		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			list.add(cur.val);
			pushAllLeft(cur.right, stack);
		}
		return list;
	}

	public void pushAllLeft(TreeNode node, Stack<TreeNode> stack) {
		while (node != null) {
			stack.add(node);
			node = node.left;
		}
	}
	
	
	public  List<Integer> IterativePostorderOneStack(TreeNode node) {
		
		List<Integer> list = new ArrayList<Integer>();

		TreeNode current = node;
		Stack<TreeNode> stk = new Stack<TreeNode>();

		while (current != null || !stk.isEmpty()) {

			if (current != null) {
				stk.add(current);
				current = current.left;
			} else {
				TreeNode tmp = stk.peek().right;
				if (tmp == null) {
					tmp = stk.pop();
					list.add(tmp.val);
					while (!stk.isEmpty() && tmp == stk.peek().right) {
						tmp = stk.pop();
						list.add(tmp.val);
					}
				} else {
					current = tmp;
				}

			}

		}
		
		return list;

	}
	
	public  List<Integer> IterativePostorderTwoStack(TreeNode node) {
		List<Integer> list = new LinkedList<Integer>();

		if (node == null)
			return list;
		
		Stack<TreeNode> stk1 = new Stack<TreeNode>();
		Stack<TreeNode> stk2 = new Stack<TreeNode>();
		stk1.push(node);
		while (!stk1.isEmpty()) {
			node = stk1.pop();
			stk2.push(node);
			if (node.left != null)
				stk1.push(node.left);
			if (node.right != null)
				stk1.push(node.right);
		}
		while (!stk2.isEmpty()) {
			node = stk2.pop();
			list.add(node.val);
		}
			return list;
	}
	

}
