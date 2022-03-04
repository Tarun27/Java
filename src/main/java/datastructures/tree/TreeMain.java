package datastructures.tree;

import java.util.LinkedList;
import java.util.List;

public class TreeMain {

/*
 *        Binary Tree 
 * 
 *             A
 *            / \
 *          B     C 
 *         / \   / \
 *        D   E  F  G  
 *         
 *          
 * 
 */
	
public static void main(String[] args) {
	TreeNode A = new TreeNode(1);
	TreeNode B = new TreeNode(2);
	TreeNode C = new TreeNode(3);
	TreeNode D = new TreeNode(4);
	TreeNode E = new TreeNode(5);
	TreeNode F = new TreeNode(6);
	TreeNode G = new TreeNode(7);

	/*
	 * Preorder traversal 1 2 4 5 3 6 7 Postorder traversal 4 5 2 6 7 3 1 Inorder
	 * traversal 4 2 5 1 6 3 7
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
	IterativeTreeTraversals iterativeTreeTraversals = new IterativeTreeTraversals();

	System.out.println("Preorder traversal");
	traversals.preorder(root);
	System.out.println("\nInorder traversal");
	traversals.inorder(root);
	System.out.println("\nPostorder traversal");
	traversals.postorder(root);

	System.out.println("\n-------------------------------");

	System.out.println("\nIterative preorder traversal");

	List<Integer> list = new LinkedList<Integer>();

	list = iterativeTreeTraversals.iterativePreorder(root);

	list.forEach(x -> System.out.print(x + " "));

	System.out.println("\nIterative inorder traversal");
	list = iterativeTreeTraversals.iterativeInorder(root);
	list.forEach(x -> System.out.print(x + " "));

	System.out.println("\niterative post order traversal with 2 stacks");
	list = iterativeTreeTraversals.IterativePostorderTwoStack(root); // learn this one, it can be easily remembered
	list.forEach(x -> System.out.print(x + " "));

	System.out.println("\niterative post order traversal");
	list = iterativeTreeTraversals.IterativePostorderOneStack(root); // you will have to remember steps in this one, so
																		// this can be avoided
	list.forEach(x -> System.out.print(x + " "));
	
	System.out.println("\n-------------------------------");
	System.out.println("\nlevel order traversal");
	

	
	LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
	List<List<Integer>> lvlList = levelOrderTraversal.levelOrder(root);

	lvlList.forEach((lvl) -> {
		lvl.forEach(x -> System.out.print(x + " "));
		System.out.println();
	});


}

}
