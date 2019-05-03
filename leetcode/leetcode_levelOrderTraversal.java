package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode_levelOrderTraversal
{
	/*
	 * binary-tree-level-order-traversal
	 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
	 */
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
       ArrayList<ArrayList<Integer>> res = new ArrayList<>();
       if(root==null) return res;
       Queue<TreeNode> level = new LinkedList<>();
       level.offer(root);
       
       while(!level.isEmpty()) {
    	   ArrayList<Integer> tempList = new ArrayList<>();
    	   int size = level.size();
    	   for(int i=0;i<size;i++) {
    	    TreeNode curNode = level.poll();
    	    tempList.add(curNode.val);
    	    if(curNode.left!=null) level.offer(curNode.left);
    	    if(curNode.right!=null) level.offer(curNode.right);
    	   }
    	   res.add(tempList); 
       }
       return res;
	}

}
