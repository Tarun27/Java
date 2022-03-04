package datastructures.tree;

public class TreeMain {

	public static void main(String[] args) {
		TreeNode A = new TreeNode(1);
		TreeNode B = new TreeNode(2);
		TreeNode C = new TreeNode(3);
		TreeNode D = new TreeNode(4);
		TreeNode E = new TreeNode(5);
		TreeNode F = new TreeNode(6);
		TreeNode G = new TreeNode(7);

		/*
		 * Preorder traversal 1 2 4 5 3 6 7 
		 * Postorder traversal 4 5 2 6 7 3 1 
		 * Inorder  traversal 4 2 5 1 6 3 7
		 * 
		 */

		TreeNode root = A; // root of the tree
		A.left = B;
		A.right = C;
		B.left = D;
		B.right = E;
		C.left = F;
		C.right = G;
		
		RecursiveTreeTraversals traversals = new RecursiveTreeTraversals(); 

		System.out.println("Preorder traversal");
		traversals.preorder(root);
		System.out.println("\nPostorder traversal");
		traversals.postorder(root);
		System.out.println("\nInorder traversal");
		traversals.inorder(root);


	}

}
