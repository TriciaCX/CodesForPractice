package leetcode.leetcode100;

//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//
//机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
//
//现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

public class leetcode0063 {
    public static void main(String[] args) {
        int[][] ob = {{0,0},{0,1}};
        int res = uniquePathsWithObstacles(ob);
        System.out.println(res);
    }


    public static  int uniquePathsWithObstacles(int[][] obstacleGrid){
        if(obstacleGrid==null || obstacleGrid.length==0 || obstacleGrid[0].length==0|| obstacleGrid[0][0]==1 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1){
            return 0;
        }
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        int[][] dp = new int[row][col];
        dp[0][0] = 1;
        for(int i=1;i<row;i++){
           if(obstacleGrid[i][0]!=1){
               dp[i][0] = dp[i - 1][0];
           }
        }
        for(int j=1;j<col;j++){
            if(obstacleGrid[0][j]!=1){
                dp[0][j] = dp[0][j-1];
            }
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
               if(obstacleGrid[i][j]!=1){
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return  dp[row-1][col-1];
    }




}
