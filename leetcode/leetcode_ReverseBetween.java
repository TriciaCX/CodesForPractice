package LeetCode;

public class leetcode_ReverseBetween
{
	/*
	 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
	 * For example: Given1->2->3->4->5->NULL, m = 2 and n = 4,return1->4->3->2->5->NULL.
	 * Note: Given m, n satisfy the following condition:1 ≤ m ≤ n ≤ length of list.
	 */

	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode fakeNode = new ListNode(0);
		ListNode preNode = fakeNode;
		ListNode curNode = head;
		fakeNode.next = head;

		for(int i=1;i<m;i++) {
			preNode = curNode;
			curNode = curNode.next;
		}


		for(int j=0;j<n-m;j++) {
			ListNode temp = curNode.next;
			curNode.next = temp.next;
			temp.next = preNode.next;
			preNode.next = temp;
		}
		return fakeNode.next;
	}
}
