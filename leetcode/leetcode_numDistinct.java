package LeetCode;

public class leetcode_numDistinct
{
	/**
	 * 返回S中有多少个T
	 *Given a string S and a string T, count the number of distinct subsequences of T in S.
	 *A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie,"ACE"is a subsequence of"ABCDE"while"AEC"is not).
	 *Here is an example:S ="rabbbit", T ="rabbit"Return3.
	 */

	/**
	 * （改版解释中，S是母串，T是子串）
	 * 我们需要一个二维数组dp(i)(j)来记录长度为i的子串在长度为j的母串中出现的次数，
	 * 这里长度都是从头算起的，而且遍历时，保持子串长度相同，先递增母串长度，母串最长时再增加一点子串长度重头开始计算母串。
	 * 首先我们先要初始化矩阵，当子串长度为0时，所有次数都是1，当母串长度为0时，所有次数都是0.当母串子串都是0长度时，次数是1（因为都是空，相等）。
	 * 接着，如果子串的最后一个字母和母串的最后一个字母不同，说明新加的母串字母没有产生新的可能性，可以沿用该子串在较短母串的出现次数，所以dp(i)(j) = dp(i)(j-1)。
	 * 如果子串的最后一个字母和母串的最后一个字母相同，说明新加的母串字母带来了新的可能性，我们不仅算上dp(i)(j-1)，也要算上新的可能性。
	 * 那么如何计算新的可能性呢，其实就是在既没有最后这个母串字母也没有最后这个子串字母时，子串出现的次数，我们相当于为所有这些可能性都添加一个新的可能。
	 * 所以，这时dp(i)(j) = dp(i)(j-1) + dp(i-1)(j-1)。
	 * 下图是以rabbbit和rabbit为例的矩阵示意图。计算元素值时，当末尾字母一样，实际上是左方数字加左上方数字，当不一样时，就是左方的数字。
	 * @param S
	 * @param T
	 * @return
	 */

	public int numDistinct(String S, String T) {
		if(S==null || T==null || S.length()==0 ||T.length()==0 || S.length()<T.length()) return 0;

		int Slen = S.length();   //子串（删除元素变成母串）
		int Tlen = T.length();   //母串
		int[][]dp = new int[Slen+1][Tlen+1]; 

		//母串为空，子串只有全删除才和母串相同，所以只有1个
		for(int i=0;i<=Slen;i++){  
			dp[i][0]=1;
		}

		//子串为空，怎样删除都和母串不同，所以为0
		for(int i=1;i<Tlen;i++){
			dp[0][i]=0;
		}

		//先保持子串长度不变，增加母串长度
		for(int i=1;i<=Slen;i++){ //子串
			for(int j=1;j<=Tlen;j++){ //母串
				dp[i][j]=dp[i-1][j];
				if(S.charAt(i-1) == T.charAt(j-1))
					dp[i][j] = dp[i][j]+dp[i-1][j-1];
			}
		}
		return dp[Slen][Tlen];
	}

}
