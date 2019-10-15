package leetcode.leetcode800;

public class leetcode877 {
    /**
     * 石子游戏
     * 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
     * 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
     * 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
     * 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
     */
    public static void main(String[] args) {
        int[] piles = {5,3,4,5};
        System.out.println(stoneGame(piles));
    }

    public static boolean stoneGame(int[] piles) {
        int sum = 0;
        for(int p:piles){
            sum+=p;
        }

        int n = piles.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i] = piles[i];
        }
        for(int i=1;i<n;i++){
            dp[i-1][i] = Math.max(dp[i-1][i-1],dp[i][i]);
        }


        int start,end;
        for(int i=2;i<n;i++){
            for(int j=0;i+j<n;j++){
                start = piles[j]+Math.min(dp[j+1][i+j-1],dp[j+2][i+j]);
                end = piles[i+j]+Math.min(dp[j][i+j-2],dp[j+1][i+j-1]);
                dp[i][j] = Math.max(start,end);
            }
        }
        return (dp[0][n-1]>sum-dp[0][n-1]);
    }
}
