package interviewTop100;

import struct.ListNode;

public class leetcode141
{
/*
 * 环形链表
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos来表示链表尾连接到链表中的位置（索引从 0 开始）。 
 * 如果 pos 是 -1，则在该链表中没有环。
 */
	
public boolean hasCycle(ListNode head) {
       if(head==null || head.next==null) {
    	   return false;
       }
       ListNode fastNode = head;
       ListNode slowNode = head;
       while(fastNode!=null && fastNode.next!=null) {
    	   fastNode = fastNode.next.next;
    	   slowNode = slowNode.next;
    	   if(fastNode == slowNode)
    		   return true;
       }
       return false;      
    }
}
