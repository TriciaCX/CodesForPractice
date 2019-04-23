package LeetCode;

public class leetcode_uniquePathsWithObstacles
{
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid==null||obstacleGrid.length<1||obstacleGrid[0].length<1) return 0;
		int row = obstacleGrid.length; //��
		int col = obstacleGrid[0].length;  //��
		int[][] dp = new int[row][col];

		int value = 1;
		int value2= 1;

		if(obstacleGrid[0][0]==1) {
			dp[0][0]=0;
		}else
		{
			dp[0][0]=1;
		}

		//��1��
		for(int i=1;i<row;i++) {
			if(obstacleGrid[i-1][0]==1||obstacleGrid[i][0]==1) {
				value = 0; 
			}
			dp[i][0]=value;
		}

		//��һ��

		for(int j=1;j<col;j++) {
			if(obstacleGrid[0][j-1]==1||obstacleGrid[0][j]==1) {
				value2 = 0; 
			}
			dp[0][j]=value2;
		}


		for(int i=1;i<row;i++) {
			for(int j =1;j<col;j++) {
				if(obstacleGrid[i][j]!=1) { //Ŀ�ĵ�û���ϰ�
					if(obstacleGrid[i-1][j-1]==1) {
						dp[i][j] = dp[i][j-1]+dp[i-1][j]-dp[i-1][j-1];
					}else{
						dp[i][j] = dp[i-1][j]+dp[i][j-1];
					}
				}else {//Ŀ�ĵ����ϰ�
					dp[i][j] = 0;
				}

			}
		}

		return dp[row-1][col-1];

	}
}
