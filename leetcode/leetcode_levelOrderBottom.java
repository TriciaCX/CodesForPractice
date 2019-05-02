package LeetCode;

import java.util.ArrayList;

public class leetcode_levelOrderBottom
{
	/*
	 * binary-tree-level-order-traversal-ii
	 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
	 * (ie, from left to right, level by level from leaf to root).
	 */
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
       ArrayList<ArrayList<Integer>> resArrayList = new ArrayList<>();
       if(root==null) return resArrayList;
       ArrayList<TreeNode> nodes = new ArrayList<>();
       nodes.add(root);
       while(!nodes.isEmpty()) {
           ArrayList<Integer> tempArrayList = new ArrayList<>();
           int len = nodes.size();
           for(int i=0;i<len;i++) {
        	   TreeNode node = nodes.remove(0);
        	   tempArrayList.add(node.val);
        	   if(node.left!=null) nodes.add(node.left);
        	   if(node.right!=null) nodes.add(node.right);
           }
           resArrayList.add(0,tempArrayList);
       }
       return resArrayList;
	}

}
