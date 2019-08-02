package interviewTop100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import struct.TreeNode;

public class leetcode103
{
/**
 * 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
例如：
给定二叉树 [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层次遍历如下：
[
  [3],
  [20,9],
  [15,7]
]
 */
	 List<List<Integer>> res = new ArrayList<>();
	 public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	    if(root==null)
	    	return res;
	    LinkedList<TreeNode> dqueue = new LinkedList<>();
	    dqueue.add(root);
	    int level = 0;
	    while(!dqueue.isEmpty()) {
	    	int size = dqueue.size();
	    	ArrayList<Integer> tmp = new ArrayList<Integer>();
	    	if(level%2==0) { //奇数层
	    		for(int i=0;i<size;i++) {
	    			TreeNode node = dqueue.pollFirst();
	    			if(node.left!=null)
	    				dqueue.addLast(node.left);
	    			if(node.right!=null)
	    				dqueue.addLast(node.right);
	    			tmp.add(node.val);
	    		}
	    	}else { //偶数层
	    		for(int i=0;i<size;i++) {
	    			TreeNode node = dqueue.pollLast();
	    			if(node.right!=null)
	    				dqueue.addFirst(node.right);
	    			if(node.left!=null)
	    				dqueue.addFirst(node.left);
	    			tmp.add(node.val);
	    		}	    		
	    	}
	    	level++;
	    	res.add(new ArrayList<>(tmp));
	    }
	    return res;
	 }
}
