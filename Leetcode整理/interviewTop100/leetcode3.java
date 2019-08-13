package interviewTop100;

import java.util.HashMap;
import java.util.Map;

public class leetcode3
{
/**
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
	
	/*
	 * 标签：滑动窗口
暴力解法时间复杂度较高，会达到 O(n^2)，故而采取滑动窗口的方法降低时间复杂度
定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
我们定义不重复子串的开始位置为 start，结束位置为 end
随着 end 不断遍历向后，会遇到与 [start, end] 区间内字符相同的情况，此时将字符作为 key 值，获取其 value 值，并更新 start，此时 [start, end] 区间内不存在重复字符
无论是否更新 start，都会更新其 map 数据结构和结果 ans。
时间复杂度：O(n)O(n)
	 */
	public int lengthOfLongestSubstring(String s) {
		if(s==null || s.length()==0)
			return 0;
		//建立一个map用于存储每个字符最后出现的位置
		Map<Character, Integer> map = new HashMap<Character, Integer>();
	    
		int len =0;
		int start = 0;
		int end =0;
		
		while(end<s.length()) {
			Character c = s.charAt(end);
			if(map.containsKey(c)) {
				start = Math.max(map.get(s.charAt(end)), start);				
			}
			map.put(s.charAt(end), end+1);
			len = Math.max(len, end-start+1);
			end++;
		}
		return len;
		
	}
}
