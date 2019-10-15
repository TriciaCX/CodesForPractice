package leetcode.leetcode500;

import java.util.Scanner;

public class leetcode518 {
    /**
     *
     */
    public static void main(String[] args) {
        int[] coins = {20,10,5,2,1};
        Scanner scanner =new Scanner(System.in);
        int amount = scanner.nextInt();
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] =1;
        for(int i=1;i<=coins.length;i++){
           for(int j=0;j<=amount;j++) {
             dp[i][j] = dp[i-1][j];
             if(j-coins[i-1]>=0){
                 dp[i][j]+=dp[i][j-coins[i-1]];
             }
           }
        }
        int res = dp[coins.length][amount];
        System.out.println(res);
    }
}
