package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class leetcode_CopyRandomList
{
	/*
	 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
	 * Return a deep copy of the list.
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null) return null;
		RandomListNode pNode = head, copyHead = null, copyNode = null;
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		while(pNode != null){ //pNode是原始节点
			//新建一个节点
			RandomListNode node = new RandomListNode(pNode.label);
			node.next = null;
			node.random = null;

			if(pNode == head){ //如果是头节点
				copyHead = copyNode = node;
			}
			else{
				copyNode.next = node;
				copyNode = copyNode.next;
			}
			map.put(pNode, copyNode); //把节点的配对信息放到一个哈希表中，key是原始节点，value是复制节点
			pNode = pNode.next;
		}
		for(Map.Entry<RandomListNode, RandomListNode> m: map.entrySet()){
			m.getValue().random = map.get(m.getKey().random);
		}
		return copyHead;
	}
}
