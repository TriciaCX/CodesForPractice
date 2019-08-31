package forOffer;

import struct.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class offer06 {
    /**
     * 从尾到头打印指针
     * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
     */

    //方法一：递归
    public ArrayList<Integer> printListFromTailToHeadI(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if(listNode!=null) {
            list.addAll(printListFromTailToHeadI(listNode.next));
            list.add(listNode.val);
        }
        return list;
    }


    //方法二：栈
    public ArrayList<Integer> printListFromTailToHeadII(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        ListNode p = listNode;
        while(p!=null) {
            stack.push(p.val);
            p = p.next;
        }

        while(!stack.isEmpty()) {
            list.add(stack.pop());
        }

        return list;
    }
}
