import struct.ListNode;

public class Ch2_josephusKill
{
    /**
     * p50 输入一个环形单向链表的头节点head和报数的值m
     * return：最后生存下来的节点，且这个节点自己组成环形单向链表，其他节点都删掉
     * 1、常规解法O(N*M)
     * 2、进阶解法O(N)
     */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	
	// 1、常规解法O(N*M)
	public ListNode josePhusKill(ListNode head,int m) {
		if(head==null||head.next==null||m<1) {
			return head;
		}
		ListNode last = head;
		while(last.next!=head) {
			last = last.next.next;
		}
		int count = 0;
		while(head!=last) {
			if(++count == m) {
				last.next = head.next;
				count = 0;
			}else {
				last = last.next;
			}
			head = last.next;
		}
		return head;
	}
	
	//2、进阶解法O(N)
	public ListNode josePhusKil2(ListNode head,int m) {
		if(head==null||head.next==null||m<1) {
			return head;
		}
		ListNode cur = head.next;
		int tmp = 1; //tmp->list.size
		while(cur!=head) {
			tmp++;
			cur =cur.next;
		}
		tmp = getLive(tmp,m); //tmp->service node position
		while(--tmp!=0) {
			head = head.next;
		}
		head.next =head;
		return head;
	}

	private int getLive(int i, int m)
	{
		if(i==1) {
			return 1;
		}
		return (getLive(i-1, m)+m-1)%i+1;
	}
}
