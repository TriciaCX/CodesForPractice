package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class leetcode_CloneGraph
{
	//图的复制
		//DFS 
		//递归
		
	    Map<Integer, UndirectedGraphNode> map = new HashMap<>();
		
	    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
			if(node == null) return null;
	        UndirectedGraphNode node2 = cloneGraphCore(node);
	        return node2;
		}

		private UndirectedGraphNode cloneGraphCore(UndirectedGraphNode node)
		{
			if(node == null) return null;
			
			if(map.containsKey(node.label)) {
				return map.get(node.label);
			}
			UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
			map.put(copyNode.label, copyNode);
			for (UndirectedGraphNode iter : node.neighbors)
			{
				copyNode.neighbors.add(cloneGraphCore(iter));
			}
			return  copyNode;
		}
}
