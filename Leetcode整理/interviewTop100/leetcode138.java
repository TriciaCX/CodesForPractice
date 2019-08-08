package interviewTop100;

import struct.Node;

public class leetcode138
{
/**
 * 复制带随机指针的链表
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
要求返回这个链表的深拷贝。
  
 */
	 public Node copyRandomList(Node head) {
		 if(head==null) return head;
		 Node curNode = head;
		 Node nextNode = null;
		 //复制A-A'-B-B'-C-C'
		 while(curNode!=null) {
			 nextNode = curNode.next;
			 curNode.next = new Node(curNode.val);
			 curNode.next.next = nextNode;
			 curNode = nextNode;
		 }
		 
		 //复制随机指针
		 curNode  = head;
		 Node copyNode = null;
		 while(curNode!=null) {
			 nextNode = curNode.next.next;
			 copyNode = curNode.next;
			 copyNode.random = curNode.random==null?null:curNode.random.next;
			 curNode = nextNode;
		 }
		 //拆链子
		 curNode = head;
		 Node copyHead = head.next;
		 while(curNode!=null) {
			 nextNode = curNode.next.next;
			 copyNode = curNode.next;
			 curNode.next = nextNode;
			 copyNode.next = nextNode==null?null:nextNode.next;
			 curNode = nextNode;
		 }
		 return copyHead;
	 }
}
