import struct.ListNode;

public class Ch2_mergeTwoLists
{
	
	/**
	 * leetcode 21. 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
	 * @return
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
         if(l1==null)
        	 return l2;
         if(l2==null)
        	 return l1;
         ListNode fakeNode = new ListNode(0);
         ListNode curNode = fakeNode;
         fakeNode.next = curNode;
         while(l1!=null && l2 !=null) {
        	 if(l1.val<=l2.val) {
        		 curNode.next = l1;
        		 l1 = l1.next;
        	 }else {
        		 curNode.next = l2;
        		 l2 = l2.next;
        	 }
        	 curNode = curNode.next;
         }
         while(l1!=null) {
        	 curNode.next = l1;
        	 l1 = l1.next;
        	 curNode = curNode.next;
         }
         while(l2!=null) {
        	 curNode.next = l2;
        	 l2 = l2.next;
        	 curNode = curNode.next;
         }
         return fakeNode.next;
	}
}
