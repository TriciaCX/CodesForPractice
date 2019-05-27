package LeetCode;

public class leetcode_InsertionSortList
{
	/**
	 * insertion-sort-list
	 * Sort a linked list using insertion sort.
	 */
	public ListNode insertionSortList(ListNode head) {
		if(head==null||head.next==null)
			return head;
		ListNode fakeHead = new ListNode(Integer.MIN_VALUE);
		ListNode curNode = head;
		ListNode preNode = fakeHead;
		while(curNode!=null) {
			//保存当前节点的下一个节点
			ListNode nextNode = curNode.next;
			preNode = fakeHead;
			//寻找当前节点正确位置的一个节点
			while(preNode.next!=null && preNode.next.val<curNode.val) {
				preNode = preNode.next;
			}
			//将当前节点加入到新链表中
			curNode.next = preNode.next;
			preNode.next = curNode;
			//处理下一个节点
			curNode=nextNode;
		}
	
		return fakeHead.next;
	}
}
