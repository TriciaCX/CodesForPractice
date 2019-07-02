import struct.ListNode;

public class Ch2_reverseBetween
{

	public static void main(String[] args)
	{
		ListNode head1 = new ListNode(1);
		ListNode L1 = new ListNode(2);
		ListNode L2 = new ListNode(3);
		head1.next = L1;
		L1.next =L2;
		L2.next = new ListNode(4);
		Ch2_reverseBetween sl = new Ch2_reverseBetween();
		ListNode pListNode=sl.reverseBetween(head1, 1, 3);
        while(pListNode!=null) {
        	System.out.println(pListNode.val);
        	pListNode = pListNode.next;
        }
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null ||head.next==null) {
        	return head;
        }
        //先找到第m个节点的前一个节点
        
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode preNode = dummyNode;
        
        for(int i=0;i<m-1;i++) {
        	preNode = preNode.next;
        }

        ListNode curNode = preNode.next;
        
        for(int i=0;i<n-m;i++) {
        	ListNode nextNode = curNode.next;
        	curNode.next = nextNode.next;
        	nextNode.next = preNode.next;
        	preNode.next = nextNode;
        }
        return dummyNode.next;
	}
	

}
