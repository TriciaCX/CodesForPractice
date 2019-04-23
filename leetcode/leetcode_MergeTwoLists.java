package LeetCode;

public class leetcode_MergeTwoLists
{
	/*
	 * Merge two sorted linked lists and return it as a new list. 
	 * The new list should be made by splicing together the nodes of the first two lists.
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null && l2 == null) return null;
		ListNode pheadNode = new ListNode(0);
		ListNode pNode = pheadNode;

		while(l1!=null && l2!=null) {
			if(l1.val<l2.val) {
				pNode.next = l1;
				l1=l1.next;
			}else {
				pNode.next = l2;
				l2=l2.next;
			}
			pNode=pNode.next;
		}
		if(l1!=null) pNode.next=l1;
		if(l2!=null) pNode.next=l2;
		return pheadNode.next;	
	}
}
