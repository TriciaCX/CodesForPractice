package interviewTop100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class leetcode242
{
/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。

进阶:
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
	
	//map 查找
	public boolean isAnagram(String s, String t) {
		  HashMap<Character, Integer> map = new HashMap<>();
	        for(int i=0;i<s.length();i++) {
	        	if(map.containsKey(s.charAt(i))) {
	        		int cnt = map.get(s.charAt(i));
	        		map.put(s.charAt(i), ++cnt);
	        	}else {
	        		map.put(s.charAt(i), 1);
	        	}
	        }
	        
	        for(int i=0;i<t.length();i++) {
	        	if(!map.containsKey(t.charAt(i)))
	        		return false;
	        	int cnt = map.get(t.charAt(i));
	            map.put(t.charAt(i),--cnt);
	        }
	        for(Character c:map.keySet()) {
	        	if(map.get(c)!=0) {
	        		return false;
	        	}
	        }
	        return true;
	}
	
	//排序
	public boolean isAnagramII(String s, String t) {
		char[] chs = s.toCharArray();
		char[] cht = t.toCharArray();
		if(chs.length!=cht.length)
			return false;
		Arrays.sort(chs);
		Arrays.sort(cht);
		for(int i=0;i<chs.length;i++) {
			if(chs[i]!=cht[i])
				return false;
		}
		return true;
	}
	
	//先用计数器表计算 s，然后用 t 减少计数器表中的每个字母的计数器。如果在任何时候计数器低于零，我们知道 t 包含一个不在 s 中的额外字母，并立即返回 FALSE。
	public boolean isAnagramIII(String s, String t) {
	    if (s.length() != t.length()) {
	        return false;
	    }
	    int[] table = new int[26];
	    for (int i = 0; i < s.length(); i++) {
	        table[s.charAt(i) - 'a']++;
	    }
	    for (int i = 0; i < t.length(); i++) {
	        table[t.charAt(i) - 'a']--;
	        if (table[t.charAt(i) - 'a'] < 0) {
	            return false;
	        }
	    }
	    return true;
	}

	
}
