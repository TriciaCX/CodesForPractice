import struct.ListNode;

public class Ch2_removeLastKthNode
{

	/**
	 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
	 */
	public static void main(String[] args)
	{
		ListNode head1 = new ListNode(2);
		ListNode L1 = new ListNode(3);
		ListNode L2 = new ListNode(8);
		head1.next = L1;
		L1.next =L2;
        Ch2_removeLastKthNode sl = new Ch2_removeLastKthNode();
        sl.removeNthFromEnd(head1, 1);
        while(head1!=null) {
        	System.out.println(head1.val);
        	head1=head1.next;
        }
	}

	 public ListNode removeNthFromEnd(ListNode head, int n) {
	   if(head==null || n<0)
		   return head;
	  
	   ListNode pre = new ListNode(0);
	   pre.next = head;
	   ListNode fast = pre;
	   ListNode slow = pre;
	   
	   for(int i=1;i<=n+1;i++) {
		   fast = fast.next;
	   }
	   
	   while(fast!=null) {
		   fast = fast.next;
		   slow = slow.next;
	   }
	   
	   slow.next = slow.next.next;
	   
	   return pre.next;	   
	 }
}
