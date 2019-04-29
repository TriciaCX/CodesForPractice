package LeetCode;

public class leetcode_canJump
{
	/*
	 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
	 * Each element in the array represents your maximum jump length at that position.
	 * Determine if you are able to reach the last index.
	 * For example:A =[2,3,1,1,4], return true.
	 * A =[3,2,1,0,4], return false.
	 */
	public boolean canJump(int[] A) {
		if(A.length==0||A==null) return false;
		int num = A.length; // 需要跳的步数	
		int[] dp = new int[num];
		if(A[0]>=0) dp[0] = 1;
		for(int j=0;j<num-1;j++) {
		  for(int i=j+1;i<=j+A[j]&&i<num;i++) {
			 dp[i]=1; 
		  }
		}		
		for(int k=0;k<num;k++) {
		   if(dp[k]<1) {
			   return false;
		   }
		}
        return true;
	}
	
	//方法二 每次能跳到的最远的地方
	public boolean canJumpII(int[] A) {
		// 异常输入
		if (A == null || A.length < 1)
			return false;

		int maxReach = 0;
		for(int i=0;i<A.length && maxReach>=i;++i) {
			if(i+A[i]>maxReach) maxReach=i+A[i];
		}
		return maxReach>=A.length-1?true:false;
	}
}
