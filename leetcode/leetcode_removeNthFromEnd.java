package LeetCode;

public class leetcode_removeNthFromEnd
{

	/*
	 * Given a linked list, remove the nth node from the end of list and return its head.
	 * For example, Given linked list: 1->2->3->4->5, and n = 2.
	 * After removing the second node from the end, the linked list becomes 1->2->3->5.
	 * Note: Given n will always be valid. Try to do this in one pass.
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null||n<1) return null;
        if(head.next ==null && n==1) return null;
        ListNode fast = head;
        ListNode slow = head;
        
        for(int i=0;i<n;i++) {
        	fast = fast.next;
        	if(fast == null) {
        		return head.next;
        	}
        }

        fast = fast.next;
        if(fast==null) {
        	head.next = head.next.next;
        	return head;
        }
        
        while(fast!=null) {
        	fast = fast.next;
        	slow = slow.next;
        }
        if(slow!=head) {
          slow.next = slow.next.next;
          return head;
        }
        return slow;
        
	}
}
