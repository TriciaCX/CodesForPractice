package interviewTop100;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import struct.TreeNode;

public class leetcode102
{
	/**
	 * 二叉树的层次遍历
	 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
	   List<List<Integer>> res = new ArrayList<List<Integer>>();
	   if(root==null)
		   return res;
	   
	   Queue<TreeNode> queue = new LinkedList<TreeNode>();
	   int level = 0;
	   queue.add(root);
	   while(!queue.isEmpty()) {
		   res.add(new ArrayList<>());
		   int level_num= queue.size();
		   for(int i=0;i<level_num;i++) {
			   TreeNode node=queue.poll();
			   res.get(level).add(node.val);
			   if(node.left!=null) queue.add(node.left);
			   if(node.right!=null) queue.add(node.right);
		   }
		   level++;
	   }
	   
	   return res;
	}
}
