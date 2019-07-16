package interviewTop100;

import java.util.Arrays;
import java.util.HashMap;

public class leetcode387
{
/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

案例:
s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.
 
注意事项：您可以假定该字符串只包含小写字母。
 */
	 public int firstUniqChar(String s) {
	   HashMap<Character, Integer> map = new HashMap<>();
	   for(int i=0;i<s.length();i++) {
		   if(!map.containsKey(s.charAt(i))) {
      		   map.put(s.charAt(i), 1);
		   }else {
			   map.put(s.charAt(i), map.get(s.charAt(i))+1);
		   }
	   }
	   
	   for(int i=0;i<s.length();i++) {
		   if(map.get(s.charAt(i))==1)
			   return i;
	   }
	   return -1;
	 }
	 
	 //官方优化版解fa
	 public int firstUniqCharII(String s) {
		 HashMap<Character, Integer> count = new HashMap<Character, Integer>();
		 int n = s.length();
		 // build hash map : character and how often it appears
		 for (int i = 0; i < n; i++) {
			 char c = s.charAt(i);
			 count.put(c, count.getOrDefault(c, 0) + 1);
		 }

		 // find the index
		 for (int i = 0; i < n; i++) {
			 if (count.get(s.charAt(i)) == 1) 
				 return i;
		 }
		 return -1;
	 }

}
