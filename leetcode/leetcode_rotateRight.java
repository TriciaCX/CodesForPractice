package LeetCode;

public class leetcode_rotateRight
{
	public ListNode rotateRight(ListNode head, int n) {
    	if(head==null||head.next==null||n<=0) return head;
        ListNode fakeNode = new ListNode(0);
        ListNode fastNode = head;
        ListNode slowNode = head;
        fakeNode.next = slowNode;
        
        ListNode tempNode =head;
        int len = 0;
        while(tempNode!=null) {
        	tempNode = tempNode.next;
        	len++;
        }
        
        n=n%len;
        if(n==0) return head;

        //找到翻转节点
        for(int i=0;i<n;i++) {
        	fastNode = fastNode.next;
        }
        while(fastNode.next!=null) {
        	slowNode = slowNode.next;
        	fastNode = fastNode.next;
        }
        
        fakeNode.next = slowNode.next;
        fastNode.next = head;
        slowNode.next = null;
        
        return fakeNode.next; 
        		
    }
}
