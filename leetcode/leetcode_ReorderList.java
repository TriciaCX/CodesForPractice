package LeetCode;

public class leetcode_ReorderList
{
	public void reorderList(ListNode head) {
		if(head==null||head.next==null)  return;

		//快慢节点找中间节点
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next!=null && fast.next.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}

		//反转后半部分链表
		ListNode preNode = slow;
		ListNode curNode = slow.next;
		ListNode tempNode;
		while(curNode.next!=null) {
			tempNode = curNode.next;			
			curNode.next = tempNode.next;
			tempNode.next = preNode.next;
			preNode.next = tempNode;	
		}

		ListNode p = head;
		ListNode q = preNode.next;

		while(p!=null&&q!=null) {
			preNode.next = q.next;
			q.next = p.next;
			p.next = q;
			p = q.next;
			q = preNode.next;
		}
	}
}
