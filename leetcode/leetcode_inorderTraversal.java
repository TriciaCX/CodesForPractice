package LeetCode;

import java.util.ArrayList;
import java.util.Stack;

public class leetcode_inorderTraversal
{
	/*
	 * binary-tree-inorder-traversal
	 * Given a binary tree, return the inorder traversal of its nodes' values.
	 * For example:Given binary tree{1,#,2,3}, return[1,3,2].
	 */
	 ArrayList<Integer> resArrayList = new ArrayList<>();
	 public ArrayList<Integer> inorderTraversal(TreeNode root) {
	     if(root==null) return resArrayList;
	     inorderTraversalCore(root);
	     return resArrayList;
	 }
	private void inorderTraversalCore(TreeNode root)
	{
		if(root==null) return;
		inorderTraversalCore(root.left);
		resArrayList.add(root.val);
		inorderTraversal(root.right);
		
	}
	/*
     * 非递归实现二叉树的中序遍历
     */
    public ArrayList<Integer> inorderTraversal_2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
 
            node = stack.pop();
            res.add(node.val);
            node = node.right;
 
        }
        return res;
    }

}
