package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode_zigzagLevelOrder
{
	/*
	 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
	 * (ie, from left to right, then right to left for the next level and alternate between).
	 */
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
       ArrayList<ArrayList<Integer>> resList  = new ArrayList<>();
       if(root==null) return resList;
       Queue<TreeNode> levelNodes = new LinkedList<>();
       levelNodes.offer(root);
       boolean flag = true; //false，先放右；true，先放左
       while(!levelNodes.isEmpty()) {
    	   int size = levelNodes.size();
    	   ArrayList<Integer> tempArrayList = new ArrayList<>();
    	   for(int i=0;i<size;i++) {
    		  TreeNode curNode = levelNodes.poll();
    		  if(flag) {
    			  tempArrayList.add(curNode.val);
    		  }else {
    			  tempArrayList.add(0, curNode.val);
    		  }
    		  
    		  if(curNode.left!=null) 
    		     levelNodes.offer(curNode.left);
    		  if(curNode.right!=null)   
    		     levelNodes.offer(curNode.right); 
    	   }
    	 flag=!flag;
    	 resList.add(tempArrayList);  
       }
       return resList;
	}
}
