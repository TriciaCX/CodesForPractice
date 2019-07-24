package interviewTop100;

import struct.ListNode;


public class leetcode148
{
	 public ListNode sortList(ListNode head) {
		 if(head==null||head.next==null) {
			 return head;
		 }
		 ListNode curNode = head;
		 int len = 0;
		 while(curNode!=null) {
			 len++;
			 curNode = curNode.next;
		 }
		 return sortListCore(head,len);
		
	 }
	 
	private ListNode sortListCore(ListNode head, int len)
	{
		//递归结束条件
		if(len<=1)
			return head;
		ListNode leftNode = head;
		for(int i=0;i<len/2-1;i++) {
			leftNode = leftNode.next;
		}
		ListNode rightNode = leftNode.next;
		leftNode.next = null;
	
		return merge(sortListCore(head, len/2),
				sortListCore(rightNode, len-len/2));
	}
	
	private ListNode merge(ListNode l1, ListNode l2){
		if(l1==null)
			return l2;
		if(l2==null)
			return l1;
		ListNode headNode;
		if(l1.val<=l2.val) {
			headNode = l1;
			l1.next = merge(l1.next, l2);
		}else {
			headNode = l2;
			l2.next = merge(l1, l2.next);
		}
		return headNode;
	}

	
	/**
	 * 一、分割 cut 环节： 找到当前链表中点，并从中点将链表断开（以便在下次递归 cut 时，链表片段拥有正确边界）；
我们使用 fast,slow 快慢双指针法，奇数个节点找到中点，偶数个节点找到中心左边的节点。
找到中点 slow 后，执行 slow.next = None 将链表切断。
递归分割时，输入当前链表左端点 head 和中心节点 slow 的下一个节点 tmp(因为链表是从 slow 切断的)。
cut 递归终止条件： 当head.next == None时，说明只有一个节点了，直接返回此节点。

二、合并 merge 环节： 将两个排序链表合并，转化为一个排序链表。
双指针法合并，建立辅助ListNode h 作为头部。
设置两指针 left, right 分别指向两链表头部，比较两指针处节点值大小，由小到大加入合并链表头部，指针交替前进，直至添加完两个链表。
返回辅助ListNode h 作为头部的下个节点 h.next。
时间复杂度 O(l + r)，l, r 分别代表两个链表长度。

	 */
	public ListNode sortListII(ListNode head) {
		if(head==null || head.next==null)
			return head;
		//分割 cut 环节： 找到当前链表中点，并从中点将链表断开（以便在下次递归 cut 时，链表片段拥有正确边界）
		ListNode fast = head.next;
		ListNode slow = head;
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode tmp = slow.next;  //找到中点后分割
		slow.next = null;  //切断链表
		
		ListNode left = sortListII(head);  
		ListNode right = sortListII(tmp);
		
		ListNode h = new ListNode(0);
		ListNode res = h;
		while(left!=null && right!=null) {
			if(left.val<right.val) {
				h.next = left;
				left = left.next;
			}else {
				h.next = right;
				right = right.next;
			}
			h = h.next;
		}
		h.next = left!=null? left:right;
		return res.next;
	}
	
	
}
