import java.util.HashSet;

import struct.ListNode;

public class Ch2_removeRepeatUnsortedList
{
	
	public static void main(String[] args)
	{
		ListNode head1 = new ListNode(1);
		ListNode L1 = new ListNode(1);
		ListNode L2 = new ListNode(2);
		head1.next = L1;
		L1.next =L2;
        L2.next =new ListNode(2);
        Ch2_removeRepeatUnsortedList sList = new Ch2_removeRepeatUnsortedList();
        sList.removeRep(head1);
        while(head1!=null) {
        	System.out.print(head1.val+",");
        	head1 = head1.next;
        }
	}
	/**
	 * 删除无序链表中重复的元素
	 * @param head
	 */
     public void removeRep(ListNode head) {
    	 if(head==null||head.next==null) {
    		 return;
    	 }
    	 HashSet<Integer> set = new HashSet<>();
    	 ListNode pre= new ListNode(0);
    	 pre.next = head;
    	 ListNode cur = head;
    	 while(cur!=null) {
    		 if(!set.add(cur.val)) { //如果放入失败
    			 pre.next = cur.next;
    			 
    		 }else {	
    		     pre = pre.next;
    		 }
    		cur = pre.next; 		
    	 }
     }
}
