package interviewTop100;import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetcode207
{
/**
 * ！！！！！课程表！！！！！
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]

给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？

示例 1:

输入: 2, [[1,0]] 
输出: true
解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
示例 2:

输入: 2, [[1,0],[0,1]]
输出: false
解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
说明:

输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
你可以假定输入的先决条件中没有重复的边。
提示:

这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
拓扑排序也可以通过 BFS 完成。
 */
	/**
	 * 拓扑排序实际上应用的是贪心算法。贪心算法简而言之：每一步最优，全局就最优。

具体到拓扑排序，每一次都从图中删除没有前驱的顶点，这里并不需要真正的做删除操作，我们可以设置一个入度数组，每一轮都输出入度为 00 的结点，并移除它、修改它指向的结点的入度（-1−1即可），依次得到的结点序列就是拓扑排序的结点序列。如果图中还有结点没有被移除，则说明“不能完成所有课程的学习”。

拓扑排序保证了每个活动（在这题中是“课程”）的所有前驱活动都排在该活动的前面，并且可以完成所有活动。拓扑排序的结果不唯一。拓扑排序还可以用于检测一个有向图是否有环。相关的概念还有 AOV 网，这里就不展开了。

算法流程：

1、在开始排序前，扫描对应的存储空间（使用邻接表），将入度为 00 的结点放入队列。

2、只要队列非空，就从队首取出入度为 00 的结点，将这个结点输出到结果集中，并且将这个结点的所有邻接结点（它指向的结点）的入度减 11，在减 11 以后，如果这个被减 11 的结点的入度为 00 ，就继续入队。

3、当队列为空的时候，检查结果集中的顶点个数是否和课程数相等即可。

思考这里为什么要使用队列？（马上就会给出答案。）

在代码具体实现的时候，除了保存入度为 0 的队列，我们还需要两个辅助的数据结构：
1、邻接表：通过结点的索引，我们能够得到这个结点的后继结点；
2、入度数组：通过结点的索引，我们能够得到指向这个结点的结点个数。
这个两个数据结构在遍历题目给出的邻边以后就可以很方便地得到。
	 */
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if(numCourses<=0) return false;
		int pLen = prerequisites.length;
		if(pLen==0) return true;
		int[] inDegree = new int[numCourses];
		for(int[] p :prerequisites) {
			inDegree[p[0]]++;
		}
		LinkedList<Integer> queue = new LinkedList<>();
		//加入入度为0的点
		for(int i=0;i<numCourses;i++) {
			if(inDegree[i]==0)
				queue.addLast(i);
		}
		//拓扑排序
		List<Integer> res = new ArrayList<>();
		while(!queue.isEmpty()) {
			Integer num = queue.removeFirst();
			res.add(num);
			//把邻边全部遍历一遍
			for(int[] p:prerequisites) {
				if(p[1]==num) {
					inDegree[p[0]]--;
					if(inDegree[p[0]]==0)
						queue.addLast(p[0]);
				}
			}
		}
		return res.size()==numCourses;
	}
}
