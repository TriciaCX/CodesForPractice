package forOffer;

import struct.ListNode;

import java.util.List;

public class offer24 {
    /**
     * 反转链表
     * 输入一个链表，反转链表后，输出新链表的表头。
     */

    public static  void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        ListNode head = ReverseList(l1);
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    //迭代，使用头插法
    public static  ListNode ReverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = head;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = next;
        }
        return dummy.next;
    }

    //递归
    public static  ListNode ReverseListII(ListNode head){
        if(head ==null ||head.next==null)
            return head;
        ListNode next = head.next;
        head.next = null;
        ListNode newHead = ReverseListII(next);
        next.next = head;
        return newHead;
    }
}
