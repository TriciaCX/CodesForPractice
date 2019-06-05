package vivo;

import LeetCode.ListNode;

public class vivio0604_2
{
/*
 * 翻转单向链表的第m和第n位
 */
  public ListNode reverse(ListNode head,int m,int n) {
	  //定义一个链表头节点的指针，因为有可能反转的第一个节点是head
	  ListNode fakeNode = new ListNode(0);
	  ListNode preNode = fakeNode; 
	  ListNode curNode = head;
	  fakeNode.next = head;
	  
	  //找到第m个节点
	  for(int i=0;i<m;i++) {
		  preNode = curNode;
		  curNode = curNode.next;
	  }
	  //开始翻转，每次把后面的节点插入到反转部分的最前面
	  for(int i=0;i<n-m;i++) {
		  ListNode tempNode = curNode.next;
		  curNode.next = tempNode.next;
		  tempNode.next = preNode.next;
		  preNode.next = tempNode;

	  }
	  return fakeNode.next;
  }
}
