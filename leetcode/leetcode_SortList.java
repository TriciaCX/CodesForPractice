package LeetCode;

public class leetcode_SortList
{
	/*
	 * Sort a linked list in O(n log n) time using constant space complexity.
	 */

	/*
	 * 归并排序的一般步骤为：
	 * 1）将待排序数组（链表）取中点并一分为二；
	 * 2）递归地对左半部分进行归并排序；
	 * 3）递归地对右半部分进行归并排序；
	 * 4）将两个半部分进行合并（merge）,得到结果。
	 * 1）找到链表中点 （快慢指针思路，快指针一次走两步，慢指针一次走一步，快指针在链表末尾时，慢指针恰好在链表中点）；
	 * 2）写出merge函数，即如何合并链表。 （见merge-two-sorted-lists 一题解析）
	 * 3）写出mergesort函数，实现上述步骤。
	 */

	public ListNode sortList(ListNode head) {
		if(head==null||head.next==null) return head;

		//1 找到链表中点:快慢指针思路，快指针一次走两步，慢指针一次走一步，快指针在链表末尾时，慢指针恰好在链表中点
		ListNode slowNode = head;
		ListNode fastNode = head;
		while(fastNode.next!=null && fastNode.next.next!=null) {
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
		}
		ListNode midNode = slowNode;

		//2 将待排序数组分为两部分，分别进行归并排序
		ListNode listNode2 = midNode.next;
		midNode.next = null;

		return mergeSortList(sortList(head),sortList(listNode2));

	}

	private ListNode mergeSortList(ListNode list1, ListNode list2)
	{
		ListNode preHead = new ListNode(0),cur1 = list1,cur2 = list2,cur=preHead;
		while(cur1!=null && cur2!=null) {
			if(cur1.val<cur2.val) {
				cur.next=cur1;
				cur1=cur1.next;
			}else {
				cur.next=cur2;
				cur2=cur2.next;
			}
			cur=cur.next;
		}
		cur.next = cur1==null?cur2:cur1;
		return preHead.next;
	}
}
