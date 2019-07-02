import struct.ListNode;

public class Ch2_printCommonPart
{

	/**
	 * 打印两个有序列表的公共部分
	 */
	public static void main(String[] args)
	{
		ListNode head1 = new ListNode(2);
		ListNode L1 = new ListNode(3);
		ListNode L2 = new ListNode(8);
		head1.next = L1;
		L1.next =L2;
		ListNode head2 = new ListNode(3);
	    Ch2_printCommonPart.printCommonPart(head1, head2);
	}

	public static void printCommonPart(ListNode head1,ListNode head2) {
		while(head1!=null && head2!=null) {
			if(head1.val>head2.val) {
				head2 = head2.next;
			}else if(head1.val<head2.val) {
				head1 = head1.next;
			}else {
				System.out.println(head1.val+",");
				head1 = head1.next;
				head2 = head2.next;
			}
		}
	}
}
