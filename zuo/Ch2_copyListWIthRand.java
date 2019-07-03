import struct.RandomListNode;

public class Ch2_copyListWIthRand
{
	public  RandomListNode copyRandomList(RandomListNode head) {
		if(head == null) {
			return head;
		}
		
		RandomListNode cur = head;
		RandomListNode next = null;
		
		while(cur!=null) {
			next = cur.next;
			cur.next = new RandomListNode(cur.label);
			cur.next.next = next;
			cur = next;
		}
		
		cur = head;
		RandomListNode copyNode = null;
		while(cur!=null) {
			next = cur.next.next;
			copyNode = cur.next;
			copyNode.random = cur.random==null?null:cur.random.next;
			cur = next;
		}
		
		//拆链子
		//注意，不能只把复制的链表取出来，还要恢复原链表！
		RandomListNode resNode = head.next;
		cur = head;
		while(cur!=null) {
			next = cur.next.next;
			copyNode = cur.next;
			cur.next = next;
			copyNode.next = next ==null?null:next.next;
			cur=next;
		}
		
		return resNode;
	}
}
