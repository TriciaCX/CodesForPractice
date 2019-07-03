import java.util.Stack;

import struct.ListNode;

public class Ch2_removeElements
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	/**
	 * 删除链表中等于给定值 val 的所有节点。
              示例:
              输入: 1->2->6->3->4->5->6, val = 6
              输出: 1->2->3->4->5
	 * @param head
	 * @param val
	 * @return
	 */
	public ListNode removeElements(ListNode head, int val) {
		if(head ==null) {
			return head;
		}
		Stack<ListNode> stack  =new Stack<>();

		while(head!=null) {
			if(head.val!=val) {
				stack.push(head);
			}
			head = head.next;
		}
		while(!stack.isEmpty()) {
			stack.peek().next = head;
			head = stack.pop();
		}
		return head;
	}
	
	public ListNode removeElementsII(ListNode head,int val) {
		while(head!=null) {
			if(head.val!=val) {
				break;
			}
			head =head.next;
		}
		ListNode pre = head;
		ListNode cur = head;
		while(cur!=null) {
			if(cur.val==val) {
				pre.next = cur.next;
			}else {
				pre =cur;
			}
			cur = cur.next;
		}
		return head;
	}
	
	
}
