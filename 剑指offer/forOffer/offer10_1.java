package forOffer;

public class offer10_1 {
    /**
     * 斐波那契数列
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
     */

    //递归解法
    public int Fibonacci(int n) {
        if (n<=0) return 0;
        if (n==1) return 1;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }

    //弄个数组存一下
    public int FinbonacciI(int n) {
        if (n<=0) return 0;
        if (n==1) return 1;
        int[] res = new int[n+1];
        res[0] = 0;
        res[1] = 1;
        for(int i=2;i<=n;i++) {
            res[i] = res[i-1]+res[i-2];
        }
        return  res[n];
    }
}
