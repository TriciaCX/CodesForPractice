package LeetCode;

import java.util.ArrayList;

public class leetcode_preorderTraversal
{
	
	/*
	 * binary-tree-preorder-traversal 前序遍历
	 * Given a binary tree, return the preorder traversal of its nodes' values.
	 * For example:Given binary tree{1,#,2,3},return[1,2,3].
	 */

	ArrayList<Integer> resArrayList = new ArrayList<>();
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
  
        if(root==null) return resArrayList;
        preorderTraversalCore(root);
        return resArrayList;
    }
	private void preorderTraversalCore(TreeNode root)
	{
	   if(root==null) return;
	   resArrayList.add(root.val);
	   preorderTraversalCore(root.left);
	   preorderTraversalCore(root.right);
	    
	}
	
}
