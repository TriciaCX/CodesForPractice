package interviewTop100;

public class leetcode5
{
/**
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"
 */
	
	//暴力解法（会超时嘤嘤嘤）
	public String longestPalindrome(String s) {
		if(s==null || s.length()<1) return "";
		String res = ""; 
        int len = 0;
		for(int i=0;i<s.length();i++) {						
			for(int j=i;j<s.length();j++) {
				String tmp = s.substring(i, j+1);
				if(isPalindrome(tmp)>len) {
					len = isPalindrome(tmp);
					res = tmp;
				}
			}
		}
		return res;
	}

	private int isPalindrome(String tmp){
        if(tmp=="" || tmp.length()==0) return 0;
        int start = 0;
        int end = tmp.length()-1;
        while(start<end) {
        	if(tmp.charAt(start++)!=tmp.charAt(end--)) {
        		return 0;
        	}
        }
        return tmp.length();
	}
	
	//动态规划
	/**
	 * 根据回文子串的定义，可以将原来的字符串倒置，然后找最长的公共子串
	 * 求最长公共子串，可以用动态规划的方法，申请一个二维数组arr[i][j]，判断对应的字符是否相等后，可以记录公共子串的长度
	 * 需要注意的是，我们求出最长公共子串后，并不一定是回文串，我们还需要判断该字符串倒置前的下标和当前的字符串下标是不是匹配，也就是说相同的不能正好是本身
	 */
	
	public String longestPalindromeII(String s) {
		if(s==null || s.length()==0)
			return "";
		int len = s.length();
		int[][] dp = new int[len][len];
		String originString = s;
		String reverseString = new StringBuffer(s).reverse().toString();
		int maxLen = 0;

		int maxEnd =0;
		for(int i=0;i<len;i++) { //原始字符串
			for(int j=0;j<len;j++) { //逆序字符串
				if(originString.charAt(i)==reverseString.charAt(j)) {
					if(i==0||j==0) {
						dp[i][j]=1;
					}else {
					    dp[i][j] = dp[i-1][j-1]+1;
					}
				}
				if(dp[i][j]>maxLen) {
					int originalIdx = len-1-j; //根据j推导出原始字符在原始字符串的位置
					if(originalIdx+dp[i][j]-1==i) { //倒置j位置处的字符串的末尾字符的下标与原始字符串末尾的下标是否相等是否相等
						maxLen = dp[i][j];
						maxEnd = i;
					}
				}
			}
		}
		
		return s.substring(maxEnd-maxLen+1, maxEnd+1);
	}
	
	//中心扩展算法
	 public String longestPalindromeIII(String s) {
			if(s==null || s.length()==0 || s=="")
				return "";
			int len1 =0;
			int len2 =0;
			int start =0;
			int end =0;
			int maxLen =0;
			for(int i=0;i<s.length();i++) {
				len1 = getLen(s,i,i); //奇数回文
				len2 = getLen(s, i, i+1); //偶数回文
				if(Math.max(len1, len2)>maxLen) {
					maxLen = Math.max(len1, len2);
					start = i-(maxLen-1)/2;
					end = i+maxLen/2;
				}
			}
			return s.substring(start,end+1);
		}

		private int getLen(String s, int l,int r){
			int left =l;
			int right =r;
			while(left>=0 && right<=s.length()-1&& s.charAt(left)==s.charAt(right)) {
			    left--;
	            right++;
			}
			return right-left-1;
		}
}
