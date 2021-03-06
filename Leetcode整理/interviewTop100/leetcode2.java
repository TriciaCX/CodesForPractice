package interviewTop100;

import struct.ListNode;

public class leetcode2
{
/**
 * 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 */
	
	 public ListNode addTwoNumbers(ListNode l1,ListNode l2) {
		 if(l1==null) return l2;
		 if(l2==null) return l1;
		 
		 int carry = 0;
		 int sum = 0;
		 int add1 =0;
		 int add2 =0;
		 ListNode fakeNode = new ListNode(0);
		 ListNode curNode = fakeNode ;
		 while(l1!=null || l2!=null) {
			 add1 = l1==null?0:l1.val;
			 add2 = l2==null?0:l2.val;
			 sum = add1+add2+carry;
			 carry = sum/10;
			 curNode.next = new ListNode(sum%10);
			 curNode = curNode.next;
			 
			 if(l1!=null) l1=l1.next;
			 if(l2!=null) l2=l2.next;
		 }
		 if(carry!=0) {
			 curNode.next = new ListNode(carry);
		 }
		 return fakeNode.next;
	 }
}
