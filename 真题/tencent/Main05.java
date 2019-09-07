package enterprise.tencent;

import java.util.Scanner;

/**
 * Create by Tricia on 2019/9/1
 * 花匠小Q养了两种花，一种红花一种百花，现在小Q用这些花进行摆放。
 * 摆放的时候，连续的白花数量只能是K的整数倍（倍数可以为0），不然就会枯萎
 * 现在给出a和b，小Q想知道长度为[a,b]的摆花方案中合法的摆花方案有多少种呢？
 * 输入描述：第一行两个整数t,k. t表示数据组数，k见题意
 * 接下来t行每行两个整数，表示ai,bi (1<=ai<=bi<=100000)
 * 输出描述：共t行，每行一个数表示该[ai,bi]下的摆花方案数
 */

//动态规划
public class Main05 {
    static final long MOD= (long)Math.pow(10,9)+7;
    static final int N = (int)Math.pow(10,5);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();  //组数
        int k = scanner.nextInt();  //连续白花的数量是k的倍数

        long[][] dp = new long[N][2];  //dp[i][0]表示长度为i最后一盆为红色的盆栽的方案数，dp[i][1]表示长度为i最后一盆为白色的盆栽的方案数
        long[] sum = new long[N];
        dp[0][0] =1;
        for(int i=1;i<N;i++){
            dp[i][0] = (dp[i-1][0]+dp[i-1][1])%MOD;  //红色直接加
            for(int j = k;j<=i;j+=k){
                dp[i][1] = (dp[i-j][0] + dp[i][1])%MOD;  //连续的白花数量只能是K的整数倍（倍数可以为0）
            }
            sum[i] = (sum[i-1]+dp[i][0]+dp[i][1])%MOD;  //i个的方案的总数=i-1
        }

        for(int T=0;T<t;T++){
            int a = scanner.nextInt();  //[a,b]表示长度范围为[a,b]
            int b = scanner.nextInt();
            System.out.println((sum[b]-sum[a-1])%MOD);
        }

    }
}
