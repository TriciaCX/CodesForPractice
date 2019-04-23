package LeetCode;

public class leetcode_minDistance
{
	/**
	 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. 
	 * (each operation is counted as 1 step.)
     * You have the following 3 operations permitted on a word:
     * a) Insert a character 插入
     * b) Delete a character 删除
     * c) Replace a character 替换
	 * @param word1
	 * @param word2
	 * @return
	 */
	 public int minDistance(String word1, String word2) {
	        if(word1 == null && word2 == null)
	            return 0;
	        if(word1 == null)
	            return word2.length();
	        if(word2 == null)
	            return word1.length();
	         
	        // dp[i][j]代表由word1的前i个子串变为word2的前j个子串的花费
	        // 其中i，j均可为0，代表空串:""
	        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
	        dp[0][0] = 0;
	        // 首先初始化两个子串中有一个为空串的情况
	        for(int i = 1; i <= word1.length(); i++){
	            dp[i][0] = i;
	        }
	        for(int j = 1; j <= word2.length(); j++){
	            dp[0][j] = j;
	        }
	         
	        for(int i = 1; i <= word1.length(); i++){
	            for(int j = 1; j <= word2.length(); j++){
	                // 如果这两个字符相等，那么交由上一种情况处理,如abc，dfc
	                // 这种情况与ab，df花费是一样的
	                // 不然就要在删除，插入，修改中取花费最小的那个
	                if(word1.charAt(i - 1) == word2.charAt(j - 1))
	                    dp[i][j] = dp[i-1][j-1];
	                else
	                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
	            }
	        }
	        return dp[word1.length()][word2.length()];
	    }
}
