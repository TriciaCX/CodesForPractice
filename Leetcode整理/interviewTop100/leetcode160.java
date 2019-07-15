package interviewTop100;

import struct.ListNode;

public class leetcode160
{
/**
 * 相交链表
 * 找到两个单链表相交的起始节点。
 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) {
	    	  return null;
	      }
	      //计算链表长度
	      int lenA = 0;
	      int lenB = 0;
	      ListNode curA = headA;
	      ListNode curB = headB;
	      
	      while(curA!=null) {
	    	  lenA++;
	    	  curA = curA.next;
	      }
	      while(curB!=null) {
	    	  lenB++;
	    	  curB = curB.next;
	      }
	      
	      //找节点
	      curA = headA;
	      curB = headB;
	      int step = 0;
	      if(lenA>lenB) {
	    	step = lenA-lenB;
	        for(int i = 0;i<step;i++) {
	        	curA = curA.next;
	        }
	        while(curA!=null && curB!=null) {
	        	if(curA == curB) {
	        		return curA;
	        	}
	        	curA = curA.next;
	        	curB = curB.next;
	        }
	      }else {
	        	step = lenB-lenA;
		        for(int i = 0;i<step;i++) {
		        	curB = curB.next;
		        }
		        while(curA!=null && curB!=null) {
		        	if(curA == curB) {
		        		return curA;
		        	}
		        	curA = curA.next;
		        	curB = curB.next;
		        }
	        }	 
	     return null;
    }
}
