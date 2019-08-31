package forOffer;

import struct.ListNode;

public class offer18_1 {
    /**
     * 在 O(1) 时间内删除链表节点
     * 给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间内删除该节点。
     */
    public ListNode deleteNode(ListNode head, ListNode tobeDelete){
      if(head==null || tobeDelete==null)
          return  head;
      if(tobeDelete.next!=null){
          //要删除的不是尾结点
          ListNode next = tobeDelete.next;
          tobeDelete.val = next.val;
          tobeDelete.next = next.next;
      }else {
          if(head.next==null){
              head =null;
          }else{
              ListNode cur = head;
              while(cur!=tobeDelete){
                  cur =cur.next;
              }
              cur.next =null;
          }
      }
      return head;
    }
}
