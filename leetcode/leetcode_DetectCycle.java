package LeetCode;

public class leetcode_DetectCycle
{
	/*
	 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
	 * Follow up: Can you solve it without using extra space?
	 */
	public ListNode detectCycle(ListNode head) {
		if(head==null||head.next==null) return null;
		// 首先判断有没有环
		ListNode meetingNode = hasCycle(head);
		if(meetingNode==null) return null;
		ListNode p2=meetingNode;
		ListNode p1=head;
		while(p1!=p2) {
            p1=p1.next;
            p2=p2.next;
		}
		return p1;
	}


	private ListNode hasCycle(ListNode head)
	{
		if(head==null||head.next==null) return null;
		ListNode slow = head;
		ListNode fast = head;
		while(fast!=null&&fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			if(fast==slow) return fast;
		}
		return null;
	}
}
