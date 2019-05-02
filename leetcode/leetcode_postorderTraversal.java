package LeetCode;

import java.util.ArrayList;

public class leetcode_postorderTraversal
{
	/*
	 * binary-tree-postorder-traversal
	 * Given a binary tree, return the postorder traversal of its nodes' values.
	 * For example:Given binary tree{1,#,2,3},return[3,2,1].
	 */
	ArrayList<Integer> resArrayList  = new ArrayList<>();
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
         if(root==null) return resArrayList;
	     postorderTraversalCore(root);
	     return resArrayList;
	}
	private void postorderTraversalCore(TreeNode root)
	{
		if(root==null) return;
		postorderTraversalCore(root.left);
		postorderTraversalCore(root.right);
		resArrayList.add(root.val);
	}
}
