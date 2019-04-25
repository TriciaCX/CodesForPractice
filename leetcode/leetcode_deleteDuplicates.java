package LeetCode;

public class leetcode_deleteDuplicates
{
	/**
	 * Given a sorted linked list, delete all duplicates such that each element appear only once.
	 * For example, Given1->1->2, return1->2.
	 * Given1->1->2->3->3, return1->2->3.
	 */
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null||head.next==null) return head;
        ListNode pHeadNode = new ListNode(0);
        ListNode preNode = head;
        ListNode curNode = head.next;
        pHeadNode.next = preNode;
        head.next = null;
        while(curNode!=null) {
        	ListNode tempNode = curNode.next;
        	if(preNode.val==curNode.val) {
        		curNode = tempNode;
        	}else {
        		curNode.next = preNode.next;
        		preNode.next = curNode;
        		preNode = preNode.next;
        		curNode = tempNode;
        	}
        }
        return pHeadNode.next;
    }
	

	
}
