package interviewTop100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class leetcode49
{
/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。

 */
	
	 public List<List<String>> groupAnagrams(String[] strs) {
	     HashMap<String, ArrayList<String>> map = new HashMap<>();
	     for(String s:strs) {
	    	 char[] chs = s.toCharArray();
             Arrays.sort(chs);
	    	 String key = String.valueOf(chs);
	    	 if(!map.containsKey(key)) {
	    		 map.put(key, new ArrayList<>());
	    	 }
	    	 map.get(key).add(s);
	      }
	     return new ArrayList<>(map.values());
	 }
}
