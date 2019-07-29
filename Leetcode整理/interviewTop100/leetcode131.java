package interviewTop100;

import java.util.ArrayList;
import java.util.List;

public class leetcode131
{
/**
 * 分割回文子串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

返回 s 所有可能的分割方案。

示例:

输入: "aab"
输出:
[
  ["aa","b"],
  ["a","a","b"]
]

 */
 
	 List<List<String>> res = new ArrayList<>();
	 public List<List<String>> partition(String s) {
	     if(s==null)
	    	 return res;
	     findList(s,0,new ArrayList<>());
	     return res;
	 }
	private void findList(String s, int idx, ArrayList<String> list)
	{
		if(idx==s.length()) {
			res.add(new ArrayList<>(list));
			return;
		}
		//从idx开始, 因为单个字符串也是回文子串
		for(int i = idx;i<s.length();i++) {
			if(isP(s,idx,i)) {
				//把当前的回文子串s(index,i)加进去
				list.add(s.substring(idx,i+1));
				findList(s, i+1, list);
				//把加进去的回文子串去掉。和上面加进去的回文子串是同一个回文子串
				list.remove(list.size()-1);
			}
		}
		
	}
	private boolean isP(String s, int start, int end)
	{
		while(start<end) {
			if(s.charAt(start)!=s.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}
	
}
