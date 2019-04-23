package LeetCode;

public class leetcode_minDistance
{
	/**
	 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. 
	 * (each operation is counted as 1 step.)
     * You have the following 3 operations permitted on a word:
     * a) Insert a character ����
     * b) Delete a character ɾ��
     * c) Replace a character �滻
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
	         
	        // dp[i][j]������word1��ǰi���Ӵ���Ϊword2��ǰj���Ӵ��Ļ���
	        // ����i��j����Ϊ0������մ�:""
	        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
	        dp[0][0] = 0;
	        // ���ȳ�ʼ�������Ӵ�����һ��Ϊ�մ������
	        for(int i = 1; i <= word1.length(); i++){
	            dp[i][0] = i;
	        }
	        for(int j = 1; j <= word2.length(); j++){
	            dp[0][j] = j;
	        }
	         
	        for(int i = 1; i <= word1.length(); i++){
	            for(int j = 1; j <= word2.length(); j++){
	                // ����������ַ���ȣ���ô������һ���������,��abc��dfc
	                // ���������ab��df������һ����
	                // ��Ȼ��Ҫ��ɾ�������룬�޸���ȡ������С���Ǹ�
	                if(word1.charAt(i - 1) == word2.charAt(j - 1))
	                    dp[i][j] = dp[i-1][j-1];
	                else
	                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
	            }
	        }
	        return dp[word1.length()][word2.length()];
	    }
}
