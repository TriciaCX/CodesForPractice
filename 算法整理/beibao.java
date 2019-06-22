package 算法;

public class beibao
{
	public int maxVaule(int[] w,int[]v,int total) {
		int n = w.length;
		int[][] dp = new int[n+1][total+1];
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<total+1;j++) {
				if(w[i-1]<=j) {
					if(dp[i-1][j]<(dp[i-1][j-w[i-1]]+v[i-1]))
				           dp[i][j] = dp[i-1][j-w[i-1]]+v[i-1];
					else {
						dp[i][j]=dp[i-1][j];
					}
				}else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[n][total];
	}
}
