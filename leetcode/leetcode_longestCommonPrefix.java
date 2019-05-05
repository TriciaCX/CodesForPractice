package LeetCode;

public class leetcode_longestCommonPrefix
{
	/*
	 * longest-common-prefix
	 * Write a function to find the longest common prefix string amongst an array of strings.
	 */
	public String longestCommonPrefix(String[] strs) {
		if(strs==null||strs.length<1) return "";
		String res = strs[0];
		for(int i=0;i<strs.length;i++) {
			if(!strs[i].startsWith(res)) {
				res = res.substring(0,res.length()-1);
				i--;
			}
		}
		return res; 
	}
}
