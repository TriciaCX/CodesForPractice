package interviewTop100;

import struct.ListNode;

public class leetcode19
{
/**
 * 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
示例：
给定一个链表: 1->2->3->4->5, 和 n = 2.
当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：
给定的 n 保证是有效的。
进阶：
你能尝试使用一趟扫描实现吗？。
 */
	  public ListNode removeNthFromEnd(ListNode head, int n) {
		  if(head==null) return head;
		  int len = 0;
		  ListNode p1 = head;
		  while(p1!=null) {
			  p1 = p1.next;
			  len++;
		  }
		  //删除的是头节点的情况
		  if(n==len) return head.next;
		  p1 = head;
          for(int i=0;i<len-n-1;i++) {
        	  p1 = p1.next;
          }
          if(p1.next!=null) {
        	  p1.next = p1.next.next;
          }else {
        	  p1.next=null;
          }
          return head;
	  }
	  
	  public ListNode removeNthFromEndII(ListNode head, int n) {
		     if(head==null || n<0)
				   return head;
			  
			   ListNode pre = new ListNode(0);
			   pre.next = head;
			   ListNode fast = pre;
			   ListNode slow = pre;
			   
			   for(int i=1;i<=n+1;i++) {
				   fast = fast.next;
			   }
			   
			   while(fast!=null) {
				   fast = fast.next;
				   slow = slow.next;
			   }
			   
			   slow.next = slow.next.next;
			   
			   return pre.next;	   
		    }
}
