package interviewTop100;

public class leetcode44
{
	/**
	 * 通配符匹配
	 * 给定一个字符串s和一个字符模式p，实现一个支持？和*的通配符匹配
	 * ?可以匹配任何单个字符
	 * *可以匹配任意字符串（包括空字符串）
	 * 两个字符串完全匹配算匹配成功
	 * 说明:

s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
示例 1:

输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
示例 2:

输入:
s = "aa"
p = "*"
输出: true
解释: '*' 可以匹配任意字符串。
示例 3:

输入:
s = "cb"
p = "?a"
输出: false
解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
示例 4:

输入:
s = "adceb"
p = "*a*b"
输出: true
解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
示例 5:

输入:
s = "acdcb"
p = "a*c?b"
输入: false
	 */
	/**
	 * dp[i][j]表示s的前I个字符和p的前j个字符是否匹配
	 * 
	 * 初始化
	 * 初始化:
	 * dp[0][0]:什么都没有,所以为true
	 * 第一行dp[0][j],换句话说,s为空,与p匹配,所以只要p开始为*才为true
	 * 第一列dp[i][0],当然全部为False
	 * 
	 * 转移方程
	 * 1、如果s的第 i个字符和p的第 j个字符相同，或者p的第 j个字符为 “.” dp[i][j] = dp[i - 1][j - 1]
	 * 2、如果p的第 j 个字符为 *
2.1 若p的第 j个字符匹配空串, dp[i][j] = dp[i][j-1]
2.2 若p的第 j个字符匹配s的第 i个字符, dp[i][j] = dp[i-1][j]
这里注意不是 dp[i-1][j-1]， 举个例子就明白了 (abc, a*) f[3][2] = f[2][2]

	 */
	public boolean isMatch(String s, String p) {
       int sLen = s.length();
       int pLen = p.length();
       boolean[][] dp = new boolean[sLen+1][pLen+1];
       dp[0][0] = true;
       for(int j=1;j<=pLen;j++) {
    	   dp[0][j] = dp[0][j-1] && p.charAt(j-1)=='*';//s为空,与p匹配,所以只要p开始为*才为true
       }
       for(int i=1;i<sLen+1;i++) {
    	   for(int j =1;j<pLen+1;j++) {   		   
    		   if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?') {
    			   dp[i][j] = dp[i-1][j-1];
    		   }
    		   if(p.charAt(j-1)=='*') {
    			   dp[i][j] = dp[i][j-1] || dp[i-1][j];
    		   }
    	   }
       }
       return dp[sLen][pLen];
	}
}
