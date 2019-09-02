package forOffer;

import struct.RandomListNode;

public class offer35 {
    /**
     * 复杂链表的复制
     * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
     * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     */
    public RandomListNode Clone(RandomListNode pHead) {
       if(pHead==null) return null;
       //插入新节点
        RandomListNode cur = pHead;
        while(cur!=null){
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next =clone;
            cur = clone.next;
        }
        //建立random连接
        cur = pHead;
        while(cur!=null){
            RandomListNode clone = cur.next;
            if(cur.random!=null) {  //注意判空，否则会报null错误
                clone.random = cur.random.next;
            }
            cur = clone.next;
        }
        //拆分
        cur = pHead;
        RandomListNode cloneHead = pHead.next;
        while(cur.next!=null){
            RandomListNode nextNode = cur.next;
            cur.next = nextNode.next;
            cur = nextNode;
        }
        return cloneHead;
    }
}
