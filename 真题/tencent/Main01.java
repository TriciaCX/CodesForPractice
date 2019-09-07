package enterprise.tencent;

import java.util.Scanner;

/**
 * Create by Tricia on 2019/9/1
 */
public class Main01 {
    /**
     * 题目描述：
     * 有一天，小Q发现了n个被上锁的宝箱和m串钥匙。第i个宝箱上写着一个整数ai，第j串钥匙上写着一个整数bj。
     * 小Q已经通过一些古籍得知了这些宝箱内有很多的珍贵的宝物，所以他想尽可能多地打开这些宝箱。
     * 当且仅当第i个宝箱的数字ai和第j串钥匙上的数字bj之和为奇数的时候，这个宝箱才能被这串钥匙打开。
     * 每个宝箱只能被打开一次，且没串钥匙也只能被使用一次。
     * 现在小Q
     */
    public static void  main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  //宝箱
        int m = scanner.nextInt();  //钥匙
        int[] box = new int[n];
        int[] key = new int[m];
        for(int i=0;i<n;i++){
            box[i] =scanner.nextInt();
        }
        for(int j=0;j<m;j++){
            key[j] = scanner.nextInt();
        }

        int cnt1 = 0,cnt2 =0;
        //箱子奇数的个数
        for(int i=0;i<n;i++){
            if(box[i]%2==0) cnt1++;
        }
        //钥匙偶数的个数
        for(int j=0;j<m;j++){
            if(key[j]%2==0) cnt2++;
        }

        System.out.println(Math.min(cnt1,m-cnt2) + Math.min(n-cnt1,cnt2));
        //奇数盒子能开的最大数量+偶数盒子能开的最大数量
    }
}
