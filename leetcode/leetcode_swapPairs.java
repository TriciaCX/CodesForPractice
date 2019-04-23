package LeetCode;

public class leetcode_swapPairs
{
	/**
	 * Given a linked list, swap every two adjacent nodes and return its head.
	 * For example,Given 1->2->3->4, you should return the list as 2->1->4->3.
	 * Your algorithm should use only constant space. 
	 * You may not modify the values ​​in the list, only nodes itself can be changed.
	 */
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode pheadNode = new ListNode(0);
        pheadNode.next = head;
        for(ListNode preNode = pheadNode,curNode =head,tempNode;
        		curNode!=null && curNode.next!=null;
        		preNode = curNode,curNode=curNode.next) {
        	tempNode = curNode.next;
        	curNode.next = tempNode.next;
        	tempNode.next = preNode.next;
        	preNode.next = tempNode;
        	
        }
        return pheadNode.next;
    }
}
