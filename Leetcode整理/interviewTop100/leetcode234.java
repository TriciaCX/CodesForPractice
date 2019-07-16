package interviewTop100;

import java.util.Stack;

import struct.ListNode;

public class leetcode234
{
/**
 * 回文链表
 * 请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false
示例 2:

输入: 1->2->2->1
输出: true
进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
	
	public boolean isPalindrome(ListNode head) {
        if(head==null || head.next ==null)
        	return true;
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while(p!=null) {
        	stack.push(p.val);
        	p = p.next;
        }
        while(!stack.isEmpty()) {
        	if(stack.pop()!=head.val)
        		return false;
        	head = head.next;
        }
        
        return true;
        
	}
}
