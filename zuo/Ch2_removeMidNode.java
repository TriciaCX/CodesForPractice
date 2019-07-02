import struct.ListNode;

public class Ch2_removeMidNode
{

	/**
	 * 给定一个链表，删除链表的中间节点和a/b处的节点。
	 */
	public static void main(String[] args)
	{
		ListNode head1 = new ListNode(2);
		ListNode L1 = new ListNode(3);
		ListNode L2 = new ListNode(8);
		head1.next = L1;
		L1.next =L2;
        L2.next =new ListNode(9);
        Ch2_removeMidNode test = new Ch2_removeMidNode();
        ListNode res = test.removeMidNode(head1);
        while(res!=null) {
        	System.out.println(res.val);
        	res = res.next;
        }
	}
	
	
   public ListNode removeMidNode(ListNode head) {
	   if(head == null || head.next ==null) {
		   return head;
	   }
	   
	   if(head.next.next == null) {
		   return head.next;
	   }
	   
	   ListNode fast = head.next.next;
	   ListNode slow = head;
	   
	   while(fast.next!=null && fast.next.next!=null) {
		   fast = fast.next.next;
		   slow = slow.next;
	   }
	   
	   slow.next = slow.next.next;   
	   
	   return head;
   }
   
   
}
