package LeetCode;

import java.util.ArrayList;

public class leetcode_MergeKLists
{
	/*
	 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
	 */
	 public ListNode mergeKLists(ArrayList<ListNode> lists) {
		 
	     if(lists==null||lists.size()==1) return lists.get(0);
	     
	     int size = lists.size();
	     ListNode fakeNode = new ListNode(0);
	     ListNode tempNode = fakeNode;
	    
	     for(int i=1;i<size;i++) {	
	    	 tempNode.next= merge2Lists(lists.get(i-1),lists.get(i));
	    	 lists.set(i, tempNode.next);	    

	      }
	     
	     return fakeNode.next;
	 }
	 //合并两个排序链表
	 private ListNode merge2Lists(ListNode listNode1, ListNode listNode2)
	 {
		 if(listNode1==null && listNode2==null) return null;
		 if(listNode1==null) return listNode2;
		 if(listNode2==null) return listNode1;

		 ListNode phead = new ListNode(0);
		 ListNode tempNode = phead;

		 while(listNode1!=null && listNode2!=null) {

			 if(listNode1.val<listNode2.val) {
				 tempNode.next = listNode1;
				 listNode1 = listNode1.next;
			 }else {
				 tempNode.next = listNode2;
				 listNode2 = listNode2.next;
			 }

			 tempNode = tempNode.next;
		 }

		 if(listNode1 != null) {
			 tempNode.next =listNode1;
			 listNode1 = listNode1.next;
		 }
		 if(listNode2!=null) {
			 tempNode.next =listNode2;
			 listNode2 = listNode2.next;
		 }

		 return phead.next;

	 }
	
}
