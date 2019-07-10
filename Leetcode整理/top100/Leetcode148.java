package top100;

import java.util.ArrayList;
import java.util.Collections;

import struct.ListNode;

/**
 * 排序链表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 */
public class Leetcode148
{
	
	 public static void main(String[] args){
	     Leetcode148 sl = new Leetcode148();
	     ListNode n1 = new ListNode(4);
	     ListNode n2 = new ListNode(2);
	     ListNode n3 = new ListNode(1);
	     n1.next = n2;
	     n2.next = n3;
	     ListNode head = sl.sortListII(n1);
	     while(head!=null) {
	    	 System.out.println(head.val);
	    	 head = head.next;
	     }
	 }
	//暴力解
	 public ListNode sortList(ListNode head) {
	        if(head == null || head.next == null){
	            return head;
	        }
	        ArrayList<Integer> list = new ArrayList<>();
	        while(head!=null){
	            list.add(head.val);
	            head = head.next;
	        }
	        Collections.sort(list);
	        ListNode dummyNode = new ListNode(0);
            ListNode curNode = null;
            dummyNode.next =curNode;
            ListNode preNode = dummyNode;
            for(Integer i:list) {
            	curNode = new ListNode(i);
            	preNode.next = curNode;
                preNode =curNode;
            }
            return dummyNode.next;
	 }
	 
	 
	 //归并排序
	 public ListNode sortListII(ListNode head) {
		 if(head==null||head.next==null) {
			 return head;
		 }
		 ListNode curNode = head;
		 int len = 0;
		 while(curNode!=null) {
			 len++;
			 curNode = curNode.next;
		 }
		 return sortListCore(head,len);
		
	 }
	 
	private ListNode sortListCore(ListNode head, int len)
	{
		//递归结束条件
		if(len<=1)
			return head;
		ListNode leftNode = head;
		for(int i=0;i<len/2-1;i++) {
			leftNode = leftNode.next;
		}
		ListNode rightNode = leftNode.next;
		leftNode.next = null;
	
		return merge(sortListCore(head, len/2),
				sortListCore(rightNode, len-len/2));
	}
	
	private ListNode merge(ListNode l1, ListNode l2){
		if(l1==null)
			return l2;
		if(l2==null)
			return l1;
		ListNode headNode;
		if(l1.val<=l2.val) {
			headNode = l1;
			l1.next = merge(l1.next, l2);
		}else {
			headNode = l2;
			l2.next = merge(l1, l2.next);
		}
		return headNode;
	}	 
	
}
