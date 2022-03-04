package datastructures.tree;

public class RecursiveTreeTraversals {

	// tree traversals - recursive

	public  void preorder(TreeNode node) {

		if (node == null)
			return;
		System.out.print(node.val + " ");
		preorder(node.left);
		preorder(node.right);

	}

	public  void inorder(TreeNode node) {

		if (node == null)
			return;
		inorder(node.left);
		System.out.print(node.val + " ");
		inorder(node.right);

	}

	public  void postorder(TreeNode node) {

		if (node == null)
			return;
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.val + " ");

	}

	public  void main(String[] args) {

	
	}

}
