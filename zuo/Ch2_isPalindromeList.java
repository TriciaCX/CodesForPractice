import java.util.Stack;

import struct.ListNode;

public class Ch2_isPalindromeList
{
	/**
	 * 判断链表是否为回文结构
	 */
	//解法一：遍历链表压栈一次，再弹出和原链表比较
	public boolean isPalindromeI(ListNode head) {
       if(head == null || head.next == null) 
    	   return true;
       Stack<ListNode> stack = new Stack<>();
       ListNode pNode = head;
       while(pNode!=null) {
    	   stack.push(pNode);
    	   pNode = pNode.next;
       }
       
       while(!stack.isEmpty()) {
    	  if(stack.pop().val!=head.val) {
    		  return false;
    	  }
    	  head = head.next;
       }
       return true;
	}
	
	//解法二：将链表的右半边分压栈
	public boolean isPalindromeII(ListNode head) {
		if(head == null || head.next==null) {
			return true;
		}
		ListNode right = head.next;
		ListNode cur = head;
		while(cur.next!=null && cur.next.next!=null) {
			right = right.next;
			cur = cur.next.next;
		}
		Stack<ListNode> stack = new Stack<>();
		while(right!=null) {
			stack.push(right);
			right = right.next;
		}
		while(!stack.isEmpty()) {
			if(head.val!=stack.pop().val) {
				return false;
			}
			head = head.next;
		}
		return true;
	}
	
	//解法三：反转链表  用 O(n) 时间复杂度和 O(1) 空间复杂度
	public boolean isPalindromeIII(ListNode head) {
		if(head == null || head.next==null) {
			return true;
		}
		ListNode n1 = head;
		ListNode n2 = head;
		while(n2.next!=null && n2.next.next!=null) {
			n1 = n1.next;
			n2 = n2.next.next;
		}
		
		n2 = n1.next;   //右边部分的第一个节点
		n1.next = null; //左边部分的链表先断开
	
		ListNode n3 = null;
		//step2 反转右半部分的链表
	    while(n2!=null) {
	    	n3 = n2.next;
	    	n2.next = n1;
	    	n1 = n2;
	    	n2 = n3;
	    }
	    
	    n3 = n1;   //保存最后一个节点
	    n2 = head; //左边部分的头节点
	    
	    boolean res = true;
	    while(n1!=null && n2!=null) {
	    	if(n1.val!=n2.val) {
	    		res = false;
	    		break;
	    	}
	    	n1 = n1.next;
	    	n2 = n2.next;
	    }
	    n1 = n3.next;
	    n3.next = null;
	    while(n1!=null) {
	    	n2 = n1.next;
	    	n1.next = n3;
	    	n3 = n1;
	    	n1 = n2;
	    }
	    return res;
	}

}
