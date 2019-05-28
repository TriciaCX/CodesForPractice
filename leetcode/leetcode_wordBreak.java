package LeetCode;

import java.util.Set;

public class leetcode_wordBreak
{
	/*
	 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
	 * For example, given s ="leetcode",dict =["leet", "code"].
	 * Return true because"leetcode"can be segmented as"leet code".
	 */
	public boolean wordBreak(String s, Set<String> dict) {
       if(dict==null||dict.isEmpty()||s==null||s.length()==0)
    	   return false;
       boolean[] dp=new boolean[s.length()+1];  //dp[len] 表示0~len-1可以被分词 
       dp[0]=true; 
       for(int i=1;i<dp.length;i++) {
          for(int j=0;j<i;j++) {
             if(dp[j] && dict.contains(s.substring(j, i))) {
            	 dp[i]=true;
            	 break;
             }
          }
       }
       return dp[dp.length-1];
	}
}
