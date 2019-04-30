package LeetCode;

import java.util.LinkedList;

public class leetcode_connect
{
	/*
	 * populating-next-right-pointers-in-each-node
	 */
	public void connect(TreeLinkNode root) {
	  if(root==null) return;
	  LinkedList<TreeLinkNode> queue = new LinkedList<>();
	  queue.offer(root); //加到尾部
	  while(!queue.isEmpty()) {
		  int len = queue.size();
		  for(int i=0;i<len;i++) {
			  TreeLinkNode curNode = queue.poll(); //队列的头
			  if(i==len-1) {
				 curNode.next=null;
			  }else {
			     curNode.next = queue.peek();
			  }
		      if(curNode.left!=null)  queue.offer(curNode.left);
		      if(curNode.right!=null) queue.offer(curNode.right);
		  }
	  } 
	}
}
