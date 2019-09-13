package enterprise.xiaomi;

import java.util.Arrays;
import java.util.Scanner;

public class Main01 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/

    //寻找最长上升或下降子序列，不严格单调增或不严格单调减
    static int getFre(int[] arr){
       int lenIn = 0;
       int lenDe = 0;
       int n = arr.length;
       //最长上升
       int[] dp = new int[n];//dp[i]表示以第i个元素结尾的最长序列长度
       Arrays.fill(dp,1);
       for(int i=1;i<n;i++){
           for(int j=0;j<i;j++){
               if(arr[j]<=arr[i]){
                   dp[i] = Math.max(dp[j]+1,dp[i]);
               }
           }
       }
       for(int i=0;i<n;i++){
           lenIn = Math.max(lenIn,dp[i]);
       }

       //最长下降
        int[] dp2 = new int[n];
       Arrays.fill(dp2,1);
       for(int i=0;i<n;i++){
           for(int j=0;j<i;j++){
               if(arr[j]>=arr[i]){
                   dp2[i] = Math.max(dp2[j]+1,dp2[i]);
               }
           }
       }
        for(int i=0;i<n;i++){
            lenDe = Math.max(lenDe,dp2[i]);
        }

        return n-Math.max(lenDe,lenIn);
    }

    //67%版本 题目理解有误（题目的意思是，只要插入就行不一定是两两交换）
    static int solution(int[] arr) {
        int n = arr.length;
        int[] copy1 = new int[n];
        int[] copy2 = new int[n];
        for(int i=0;i<n;i++){
            copy1[i] = arr[i];
            copy2[i] = arr[i];
        }

        int cnt1 = 0;
        for(int i=0;i<n;i++){
            int min = copy1[i];
            int IOC = i;
            for(int j=i+1;j<n;j++){
                if(copy1[j]<min){
                    min = copy1[j];
                    IOC =j;
                }
            }
            if(IOC==i)
                continue;
            else{
                swap(copy1,i,IOC);
                cnt1++;
            }
        }
        int cnt2 = 0;
        for(int i=0;i<n;i++){
            int min = copy1[i];
            int IOC = i;
            for(int j=i+1;j<n;j++){
                if(copy1[j]>min){
                    min = copy1[j];
                    IOC =j;
                }
            }
            if(IOC==i)
                continue;
            else{
                swap(copy2,i,IOC);
                cnt2++;
            }
        }

        return  Math.min(cnt1,cnt2);

    }

    private static void swap(int[] copy1, int i, int ioc) {
        int tmp = copy1[i];
        copy1[i] = copy1[ioc];
        copy1[ioc] = tmp;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [] _arr = new int[n];
        for(int i=0;i<n;i++){
            _arr[i] = in.nextInt();
        }

      //  res = solution(_arr);
        int res = getFre(_arr);
        System.out.println(String.valueOf(res));

    }
}

