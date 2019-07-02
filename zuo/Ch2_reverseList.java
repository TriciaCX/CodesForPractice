import struct.ListNode;

public class Ch2_reverseList
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	
	//反转单向链表
	 public ListNode reverseList(ListNode head) {
	     
		 if(head == null || head.next == null) {
			 return head;
		 }

		 ListNode preNode = null;
		 ListNode curNode = head;
		 
		 while(curNode!=null) {
			 ListNode nextNode = curNode.next;
			 curNode.next = preNode;
             preNode = curNode;
             curNode = nextNode;
		 }
		 
		 return preNode;
	 }
	 

}
