package LeetCode;

import java.util.Stack;

public class leetcode_ValidateBinarySearchTree
{
	/*
	 * validate-binary-search-tree
	 * Given a binary tree, determine if it is a valid binary search tree (BST).
	 * Assume a BST is defined as follows:
	 * The left subtree of a node contains only nodes with keys less than the node's key.
	 * The right subtree of a node contains only nodes with keys greater than the node's key.
	 * Both the left and right subtrees must also be binary search trees.
	 */
	

	public boolean isValidBST(TreeNode root) {
		if(root==null) return true;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curNode = root;
		TreeNode preNode = null;
		while(!stack.isEmpty()||curNode!=null) {
			if(curNode==null) {
				curNode = stack.pop();
				if(preNode!=null && preNode.val>=curNode.val) 
					return false;
				preNode = curNode;
				curNode = curNode.right;
			}else {
				stack.push(curNode);
				curNode = curNode.left;
			}
		}

		return true;
	}
}
