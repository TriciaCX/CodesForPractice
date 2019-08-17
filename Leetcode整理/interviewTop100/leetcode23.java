package interviewTop100;

import struct.ListNode;

public class leetcode23
{
	/**
	 * 合并K个有序链表
	 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
示例:
输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6
	 */
	public ListNode mergeKLists(ListNode[] lists) { 
		if(lists==null || lists.length==0)
	            return null;
        if(lists.length<2)
        	return lists[0];
        ListNode tmpHead = lists[0];
        for(int i=1;i<lists.length;i++) {
        	tmpHead = findTwo(lists[i],tmpHead);
        }
        return tmpHead;
        
	}

	//合并两个排序链表，返回链表头
	private ListNode findTwo(ListNode pHead, ListNode qHead){
		if(pHead==null)
			return qHead;
		if(qHead==null)
			return pHead;
		ListNode dummyHead = new ListNode(0);
		ListNode curNode = dummyHead;
		while(pHead!=null && qHead!=null) {
			if(pHead.val<qHead.val) {
				curNode.next = pHead;
				pHead = pHead.next;
			}else {
				curNode.next = qHead;
				qHead = qHead.next;
			}
			curNode = curNode.next;
		}
		while(pHead!=null) {
			curNode.next = pHead;
			pHead = pHead.next;
			curNode =curNode.next;
		}
	
		while(qHead!=null) {
			curNode.next = qHead;
			qHead = qHead.next;
			curNode =curNode.next;
		}
		return dummyHead.next;
	}
}
