package interviewTop100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class leetcode127
{
/**
 * 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:
如果不存在这样的转换序列，返回 0。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。

示例 1:
输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]
输出: 5
解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     返回它的长度 5。
示例 2:
输入:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
输出: 0
解释: endWord "cog" 不在字典中，所以无法进行转换。
 */
	
	/**
	 * 广度优先搜索
	 * 对给定的 wordList 做预处理，找出所有的通用状态。将通用状态记录在字典中，键是通用状态，值是所有具有通用状态的单词。
将包含 beginWord 和 1 的元组放入队列中，1 代表节点的层次。我们需要返回 endWord 的层次也就是从 beginWord 出发的最短距离。
为了防止出现环，使用访问数组记录。
当队列中有元素的时候，取出第一个元素，记为 current_word。
找到 current_word 的所有通用状态，并检查这些通用状态是否存在其它单词的映射，这一步通过检查 all_combo_dict 来实现。
从 all_combo_dict 获得的所有单词，都和 current_word 共有一个通用状态，所以都和 current_word 相连，因此将他们加入到队列中。
对于新获得的所有单词，向队列中加入元素 (word, level + 1) 其中 level 是 current_word 的层次。
最终当你到达期望的单词，对应的层次就是最短变换序列的长度。
标准广度优先搜索的终止条件就是找到结束单词
	 */
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       if(beginWord=="" || endWord=="" ||wordList.isEmpty())
    	   return 0;
      int res = 1;
      Set<String> set = new HashSet<>(wordList);
      if(!set.contains(endWord)) return 0;
      LinkedList<String> ll = new LinkedList<>();
      ll.add(beginWord);
      set.remove(beginWord);
      while(!ll.isEmpty()) {
    	  res++;
    	  int size = ll.size();
    	  for(int i=0;i<size;i++) {
    		  String s = ll.pop();
    		  Iterator<String> it = set.iterator();
    		  while(it.hasNext()) {
    			  String next = it.next();
    			  if(adj(s,next)) {
    				  it.remove();
    				  if(next.equals(endWord)) {
    					   return res;
    				  }else {
						ll.add(next);
					}
    			  }
    		  }
    	  }
      }
      return 0;
	}

	private boolean adj(String s1, String s2){
		int diff = 0;

		for(int i=0;i<s1.length();i++) {
			if(s1.charAt(i)!=s2.charAt(i)) {
				diff++;
			}
			if(diff>1) {
				return false;
			}
		}
		return true;
	}
	
	
}