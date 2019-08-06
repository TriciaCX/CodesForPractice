package interviewTop100;

public class leetcode395
{
	/**
	 * 至少有K个重复字符的最长子串
	 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
示例 1:
输入:
s = "aaabb", k = 3
输出:
3
最长子串为 "aaa" ，其中 'a' 重复了 3 次。

示例 2:
输入:
s = "ababbc", k = 2
输出:
5
最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
	 */
	public int longestSubstring(String s, int k) {
         if(s==null || s==""||k>s.length())
        	 return 0;
         if(k<2) return s.length();
         return count(s.toCharArray(),k,0,s.length()-1);        
	}

	private int count(char[] chars, int k, int p1, int p2){
		if(p2-p1+1<k) return 0;
		int[] times = new int[26]; //记录可能出现的26个字母各自的出现次数
		for(int i=p1;i<=p2;++i) {
			++times[chars[i]-'a'];
		}
		//如果该字符出现频次小于K,不能出现在结果子串中，分别排除，然后挪动两个指针
		while(p2-p1+1>=k && times[chars[p1]-'a']<k) {
			++p1;
		}
		while(p2-p1+1>=k && times[chars[p2]-'a']<k) {
			--p2;
		}
		if(p2-p1+1<k) return 0;
		for(int i=p1;i<=p2;++i) {
			//如果第I个不符合要求，切分成左右两端分别递归求得
			if(times[chars[i]-'a']<k) {
				return Math.max(count(chars, k, p1, i-1), count(chars, k, i+1, p2));
			}
		}
		return p2-p1+1;
	}
}
