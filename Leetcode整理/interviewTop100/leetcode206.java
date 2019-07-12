package interviewTop100;

import java.util.Stack;

import struct.ListNode;


/*
 *反转一个单链表。
示例:
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
 */
public class leetcode206
{
	
	 public static void main(String[] args){
	     leetcode206 sl = new leetcode206();
	     ListNode n1 = new ListNode(4);
	     ListNode n2 = new ListNode(2);
	     ListNode n3 = new ListNode(1);
	     n1.next = n2;
	     n2.next = n3;
	     ListNode head = sl.reverseListII(n1);
	     while(head!=null) {
	    	 System.out.println(head.val);
	    	 head = head.next;
	     }
	 }
	  public ListNode reverseList(ListNode head) {
	        Stack<Integer> stack = new Stack<>();
	        ListNode cur = head;
	        while(cur!=null){
	            stack.push(cur.val);
	            cur = cur.next;
	        }
	        ListNode tmp = null;
	        ListNode dummyNode = new ListNode(0);
	        ListNode pre = dummyNode;
	        dummyNode.next = tmp;
	        while(!stack.isEmpty()){
	            tmp = new ListNode(stack.pop());
                pre.next = tmp;
                pre = tmp;
	        }
	        return dummyNode.next;
	    }
	  
	  /**
	   *假设存在链表 1 → 2 → 3 → Ø，我们想要把它改成 Ø ← 1 ← 2 ← 3。
	   *在遍历列表时，将当前节点的 next 指针改为指向前一个元素。由于节点没有引用其上一个节点，因此必须事先存储其前一个元素。
	   *在更改引用之前，还需要另一个指针来存储下一个节点。不要忘记在最后返回新的头引用！
	   */
	  public ListNode reverseListII(ListNode head) {
		  if(head==null||head.next ==null) {
			  return head;
		  }
		  ListNode curNode = head;
		  ListNode preNode = null;
		  while(curNode!=null) {
			  ListNode nextNode = curNode.next;
			  curNode.next = preNode;
			  preNode = curNode;
			  curNode = nextNode;
		  }
		  return preNode;
	  }
	  
	  /**
	   * 递归解法
	   */
	  public ListNode reverseListIII(ListNode head) {
		  if (head == null || head.next == null) 
			  return head;
		  ListNode p = reverseList(head.next);
		  head.next.next = head;
		  head.next = null;
		  return p;

	  }
}
