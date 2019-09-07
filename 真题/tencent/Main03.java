package enterprise.tencent;

import java.util.Scanner;

/**
 * Create by Tricia on 2019/9/1
 * 勤劳的搬运工在搬东西。
 * 腾讯大厦一共有M名搬运工，公司有n个办公室排成一行，我们可以把这些办公室看作是数轴上坐标为1到N的每个位置，
 * 第I个办公室的像字数为ai，一开始搬运工们都在0点，每秒每名搬运工可以执行以下两种操作中的一个：
 * 1、移动一个单位距离
 * 2、搬走一箱东西（搬走之后该搬运工继续停留在该坐标处，可以继续往后走）
 * 问你最少时间能搬走所有东西？
 */
public class Main03 {
    static  long sum = 0;
    static  long t = 0; //最后不为0的数
    static long k =0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  //办公室
        int m = scanner.nextInt();  //搬运工人数
        int[] arr = new int[n+1];     //箱子个数

        for(int i=1;i<=n;i++){
            arr[i] = scanner.nextInt();
            sum += arr[i];
            if(arr[i]!=0)
                t = i;
        }

        long left = t+1; //人数无穷大时的次数
        long right = sum+t;  //人数为1的次数
        while(left<=right){
            long mid = left +(right-left)/2;
            if(cal(mid,arr,m))  //时间多了，可减少
                right = mid-1;
            else
                left = mid+1;  //时间不足，要增加
        }
        System.out.println(left);

    }

    private static boolean cal(long mid,int[] arr,int m) {  //验证当前时间（mid）能否满足
        sum = 0;
        k = m;
        for(int i=1;i<=t;i++){
            sum +=arr[i];
            while(sum +i >= mid){
                sum -= mid-i;
                if(--k<0)   //用的工人
                    return false;
            }
        }
        return k==0? sum <=0 : true;
    }
}
