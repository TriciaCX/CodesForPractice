package enterprise.bilibili;

import java.util.Scanner;

public class Main02 {
    // leetcode829 给定一个正整数 N，试求有多少组连续正整数满足所有数字之和为 N?
    // 我们把数列长度k划为起始数start与终点数end的差，即k=end-start+1。等差数列k项和可以写成(start+end)*(end-start+1)=2*N。
    // 但是题目数据范围1e9，直接暴力匹配肯定是会超时的。
    // 所以我们可以将化为寻找2*N的因数的问题，也就是(start+end)和(end-start+1)必定是2*N的因子，直接将问题的时间复杂度化为O(logn).
    // 令i=(start+end)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(consectiveNumbersSum(n));
    }

    static  int consectiveNumbersSum(int n){
        int num = 1;
        int tmp = 2*n;
        for(int i=2;i<=Math.sqrt(tmp);i++){
            if(tmp%i==0) { //因为i=start+end是tmp的因子呀
                int end = (tmp / i - 1 + i) / 2;
                int start = i - end;
                if ((start + end) * (end - start + 1) == tmp)
                    num++;
            }
        }
        return  num;
    }
}
