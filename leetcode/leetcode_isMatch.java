package LeetCode;

public class leetcode_isMatch
{
	/**
	 * Implement regular expression matching with support for'.'and'*'.
	 * '.' Matches any single character.  .匹配任意单字符 
	 * '*' Matches zero or more of the preceding element.   *匹配任意多个元素
	 * The matching should cover the entire input string (not partial)
	 * Some examples:
   isMatch("aa","a") → false
   isMatch("aa","aa") → true
   isMatch("aaa","aa") → false
   isMatch("aa", "a*") → true
   isMatch("aa", ".*") → true
   isMatch("ab", ".*") → true
   isMatch("aab", "c*a*b") → true
	 */
	public boolean isMatch(String s, String p) {
		if(s==null||p==null)
			return false;
		boolean[][] dp = new boolean[s.length()+1][p.length()+1];
		dp[0][0]=true;
		for(int i=0;i<p.length();i++) {
			if(p.charAt(i)=='*'&&dp[0][i-1])
				dp[0][i+1]=true;
		}
		for(int i=0;i<s.length();i++) {
			for(int j=0;j<p.length();j++) {
				if(p.charAt(j)=='.'||p.charAt(j)==s.charAt(i))
					dp[i+1][j+1]=dp[i][j];
				if(p.charAt(j)=='*') {
					if(s.charAt(i)!=p.charAt(j-1) && p.charAt(j-1)!='.')
						dp[i+1][j+1] = dp[i+1][j-1];  //前面字符匹配0次
					else {
						dp[i+1][j+1] = dp[i+1][j-1] || dp[i+1][j] || dp[i][j+1];
					}
				}
			}
		}
		return dp[s.length()][p.length()];
	}
}
