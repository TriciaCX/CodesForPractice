package interviewTop100;

import struct.ListNode;

public class leetcode21
{
	/**
	 * 合并有序列表
	 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
示例：
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null)
			return l2;
		if(l2==null)
			return l1;
		
		ListNode dummyNode = new ListNode(0);
		ListNode preNode = dummyNode;
		while(l1!=null && l2!=null) {
			if(l1.val<l2.val) {
				preNode.next = new ListNode(l1.val);
				l1 = l1.next;
			}else {
				preNode.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			preNode = preNode.next;
		}
		while(l1!=null) {
			preNode.next = new ListNode(l1.val);
			l1 = l1.next;
			preNode = preNode.next;
		}
		while(l2!=null) {
			preNode.next = new ListNode(l2.val);
			l2 = l2.next;
			preNode = preNode.next;
		}
		return dummyNode.next;
	}
}
