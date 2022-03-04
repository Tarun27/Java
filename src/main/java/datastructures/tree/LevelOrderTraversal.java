package datastructures.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

	// tree order or breadth first search traversal

	public  List<List<Integer>> levelOrder(TreeNode node) {
		List<List<Integer>> list = new LinkedList<>();
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.add(node);
		while (!que.isEmpty()) {

			int levelNodes = que.size();
			List<Integer> subList = new LinkedList<Integer>();

			while (levelNodes > 0) {
				levelNodes--;

				if (que.peek().left != null) {
					que.offer(que.peek().left);
				}
				if (que.peek().right != null) {
					que.offer(que.peek().right);
				}

				subList.add(que.poll().val);

			}

			list.add(subList);

		}

		return list;

	}

}
