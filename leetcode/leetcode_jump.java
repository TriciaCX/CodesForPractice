package LeetCode;

public class leetcode_jump
{
	/*
	  *  跳到目的地需要的最少步数
	 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
	 * Each element in the array represents your maximum jump length at that position.
	 * Your goal is to reach the last index in the minimum number of jumps.
	 * For example:Given array A =[2,3,1,1,4]
	 * The minimum number of jumps to reach the last index is2.
	 *  (Jump1step from index 0 to 1, then3steps to the last index.)
	 */
	public int jump(int[] A) {
		if(A==null||A.length<=0) return -1;
		int len = A.length;
		int[] dp = new int[len];

		for(int i=0;i<len;i++) {
			int maxReach = Math.min(i+A[i], len-1); //从i点出发能走的最远距离
			for(int j=i+1;j<=maxReach;j++) {
				if(dp[j]==0) dp[j] =dp[i]+1;  //如果该位置没有走过，则达到j点的步数为dp[i]+1
			}
			if(dp[len-1]!=0) break; //第一次走到终点时，肯定是走的步数最少的情况
		}    
		return dp[len-1];
	}
}
