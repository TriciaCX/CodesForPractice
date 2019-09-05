package forOffer;

import struct.ListNode;

public class offer52 {
    /**
     * 两个链表的第一个公共结点
     */

    //参考了别人的.
    // 设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，可知 a + c + b = b + c + a。
    //当访问链表 A 的指针访问到链表尾部时，令它从链表 B 的头部重新开始访问链表 B；
    // 同样地，当访问链表 B 的指针访问到链表尾部时，令它从链表 A 的头部重新开始访问链表 A。这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。
    public ListNode FindFirstCommonNodeII(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;
        while (l1 != l2) {
            l1 = (l1 == null) ? pHead2 : l1.next;
            l2 = (l2 == null) ? pHead1 : l2.next;
        }
        return l1;
    }


    //自己的解答，比较繁琐的样子
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null || pHead2==null) return null;
        int len1 = getLen(pHead1);
        int len2 = getLen(pHead2);
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        if(len1>len2){
            for(int i=0;i<len1-len2;i++){
                p1 = p1.next;
            }
        }else {
            for(int i=0;i<len2-len1;i++){
                p2 = p2.next;
            }
        }
        while(p1!=null && p2!=null){
            if(p1==p2) return p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        return  null;
    }

    private int getLen(ListNode pHead) {
        ListNode cur = pHead;
        int len = 0;
        while(cur!=null){
            cur =cur.next;
            len++;
        }
        return len;
    }
}
