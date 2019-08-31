package forOffer;

import struct.ListNode;

import java.util.ArrayList;


public class offer18_2 {
    /**
     * 删除链表中重复的节点
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     */
    public static  ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;
       ListNode curNode = pHead;
       ListNode dummyNode = new ListNode(-1);
       ListNode preNode = dummyNode;
       dummyNode.next = curNode;

       while(curNode!=null){
           ListNode nextNode = curNode.next;
           if(nextNode==null)
               break;
           if(curNode.val==nextNode.val){
               while(nextNode!=null && curNode.val==nextNode.val){
                   nextNode = nextNode.next;
               }
               preNode.next = nextNode;
               curNode = nextNode;
           }else{
               preNode = preNode.next;
               curNode = curNode.next;
           }
       }
       return  dummyNode.next;
    }

    //递归版本
    public ListNode deleteDuplicationII(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode next = pHead.next;
        if (pHead.val == next.val) {
            while (next != null && pHead.val == next.val)
                next = next.next;
            return deleteDuplication(next);
        } else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode head = deleteDuplication(l1);
        while(head!=null){
            System.out.println(head.val+" ");
            head = head.next;
        }
    }
}
