package LeetCode;

public class leetCode_hasCycle
{
	public boolean hasCycle(ListNode head) {
	       if(head==null||head.next==null) return false;
	       ListNode ps = head;
	       ListNode pf = head;
	       while(pf!=null && pf.next!=null) {
	    	   ps = ps.next;
	    	   pf = pf.next.next;
	    	   if(pf==ps) return true;
	       }
	       return false;
		}
}
