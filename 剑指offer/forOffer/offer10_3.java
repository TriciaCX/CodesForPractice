package forOffer;

import java.util.Arrays;

public class offer10_3 {

    /**
     * 跳台阶
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     */

    //跳 n 阶台阶，可以先跳 1 阶台阶，再跳 n-1 阶台阶；或者先跳 2 阶台阶，再跳 n-2 阶台阶。而 n-1 和 n-2 阶台阶的跳法可以看成子问题，
    public int JumpFloor(int target) {
        if(target<=2)
            return target;
        else
            return JumpFloor(target-1)+JumpFloor(target-2);
    }


    /**
     * 变态跳台阶
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     */
    //动态规划解法
    public int JumpFloorI(int target){
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for(int i=1; i<target; i++) {
            for(int j=0;j<i;j++){
                dp[i] += dp[j];
            }
        }
        return dp[target-1];
    }

    //数学归纳

    /**
     * 跳上 n-1 级台阶，可以从 n-2 级跳 1 级上去，也可以从 n-3 级跳 2 级上去...，那么
     * f(n-1) = f(n-2) + f(n-3) + ... + f(0)
     * 同样，跳上 n 级台阶，可以从 n-1 级跳 1 级上去，也可以从 n-2 级跳 2 级上去... ，那么
     * f(n) = f(n-1) + f(n-2) + ... + f(0)
     *
     * 综上可得
     * f(n) - f(n-1) = f(n-1)
     * 即
     * f(n) = 2*f(n-1)
     * 所以 f(n) 是一个等比数列
     */
    public int JumpFloorII(int target) {
        return (int)Math.pow(2,(target-1));
    }
}
