package LeetCode;

public class leetcode_Partition
{
	/*
	 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
	 * You should preserve the original relative order of the nodes in each of the two partitions.
	 * For example,Given1->4->3->2->5->2and x = 3,return1->2->2->4->3->5.
	 */

	public ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null) return head;
        ListNode smallFakeNode = new ListNode(0);
        ListNode largeFakeNode = new ListNode(0);
        ListNode smallNode = smallFakeNode;
        ListNode largeNode = largeFakeNode;
        ListNode temp = head;
        while(temp!=null) {
        	if(temp.val<x) {
        		smallNode.next = temp;
        		smallNode = smallNode.next;
        	}else {
        		largeNode.next = temp;
        		largeNode = largeNode.next;
        	}
        	temp = temp.next;
        }
        //拼接两个链表
        
        smallNode.next= largeFakeNode.next;
        largeNode.next = null;
        return smallFakeNode.next;
	}

}
