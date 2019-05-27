package LeetCode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class leetcode_ladderLength
{
	/**
	 * word-ladder
	 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
	 * Only one letter can be changed at a time
	 * Each intermediate word must exist in the dictionary
	 * For example,
	 * Given:start ="hit" end ="cog" dict =["hot","dot","dog","lot","log"]
	 * As one shortest transformation is"hit" -> "hot" -> "dot" -> "dog" -> "cog", return its length5.
	 * Note:Return 0 if there is no such transformation sequence.
	 * All words have the same length. All words contain only lowercase alphabetic characters.
	 */
	
	/**
	 * 主要思想：广度优先搜索。先构造一个字符串队列，并将start加入队列。1.对队列头字符串做单个字符替换
	 * 每次替换后，2.判断是否和end匹配，如果匹配，返回答案；3.没有匹配，则在字典里面查询是否有“邻居字符串”,
	 * 如果有，则将该字符串加入队列，同时将该字符串从字典里删除。重复1的过程，知道和end匹配。如果最后队列
	 * 为空还未匹配到，则返回0.
	 */
	public int ladderLength(String start, String end, HashSet<String> dict) { 
		int res = 1;
		LinkedList<String> queue = new LinkedList<>();
		queue.offer(start);
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size>0) {
				String s = queue.poll();
				size--;
				if(isValid(s,end))   //找到了最后一个
					return ++res;
				for(Iterator<String> iterator =dict.iterator();iterator.hasNext();) {
					String str = iterator.next();
					if(isValid(str, s)) {
						queue.offer(str);
						iterator.remove();
					}
				}
			}
			res++;
		}
		return 0;
	}

	private boolean isValid(String str1, String str2)
	{
		int num=0;
		for(int i=0;i<str1.length();i++) {
		   if(str1.charAt(i)!=str2.charAt(i)) {
			   num++;
		   }
		}
		if(num==1) //只有一个字母不同才是符合条件的，都相同也不行！
			return true;
		return false;
	}
}
