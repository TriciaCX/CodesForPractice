package enterprise.bilibili;

import java.util.Scanner;

public class Main01 {
    /**
     * str1变到str2最少有多少种方式
     * 1 增
     * 2 删
     * 3 不变
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 =  scanner.next();
        String str2 = scanner.next();
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i=0;i<len1+1;i++){
            for (int j=0;j<len2+1;j++){
                if(i==0)
                    dp[i][j] = j;
                else  if(j==0)
                    dp[i][j] = i;
                else if(str1.charAt(i-1)==str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
            }
        }
        System.out.println(dp[len1][len2]);
    }
}
