package forOffer;

public class offer47 {
    /**
     * 礼物的最大值
     * 在一个 m*n 的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（大于 0）。
     * 从左上角开始拿礼物，每次向右或向下移动一格，直到右下角结束。给定一个棋盘，求拿到礼物的最大价值。例如，对于如下棋盘
     */

    public static void main(String[] args) {
        int[][] board = {{426,306,641,372,477,409}, {223,172,327,586,363,553},{292,645,248,316,711,295},
                {127,192,495,208,547,175},{131,448,178,264,207,676},{655,407,309,358,246,714}};
        System.out.println(getMost(board));
    }

    public static int getMost(int[][] board) {
        if(board==null ||board.length==0 ||board[0].length==0)
            return 0;
        int rows = board.length;
        int cols = board[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = board[0][0];
        for(int i=1;i<rows;i++){
            dp[i][0] = dp[i-1][0] + board[i][0];
        }
        for(int j=1;j<cols;j++){
            dp[0][j] = dp[0][j-1] + board[0][j];
        }
        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){
               dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+board[i][j];
            }
        }
        return dp[rows-1][cols-1];
    }
}
