package datastructures.tree;

public class TreeNode {

	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int i) {
		this.val = i;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

}
