package LeetCode;

public class leetcode_reverseKGroup
{

	/*
	 * 给定链表，一次反转链表k的节点并返回其修改后的列表。如果节点数不是k的倍数，那么最后的剩余节点应该保持不变。
	 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
	 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
	 * You may not alter the values in the nodes, only nodes itself may be changed.
	 * Only constant memory is allowed.
	 * For example,Given this linked list:1->2->3->4->5 For k = 2, you should return:2->1->4->3->5
	 * For k = 3, you should return:3->2->1->4->5
	 */
	
public ListNode reverseKGroup(ListNode head, int k) {

	if(head == null || head.next == null || k < 2) return head;
	ListNode dummy = new ListNode(0);
	dummy.next = head;
	ListNode pre = dummy, cur = head, temp;
	
	//计算链表的长度
	int len = 0;
	while (head != null) {
		len ++ ;
		head = head.next;
	}
	
	for (int i = 0; i < len / k; i ++ ) { //翻转len/k组
		for (int j = 1; j < k; j ++ ) { //在k组里面逆转链表
			temp = cur.next;
			cur.next = temp.next;
			temp.next = pre.next;
			pre.next = temp;
		}
		pre = cur;
		cur = cur.next;
	}
	return dummy.next;
}
}
