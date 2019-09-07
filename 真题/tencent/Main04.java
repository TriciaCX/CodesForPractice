package enterprise.tencent;

import java.util.Scanner;
import java.util.Stack;

/**
 * Create by Tricia on 2019/9/1
 * 小Q在每一个期末的时候，都会对本学期的情况做一次全面的总结，
 * 如果这个学期有n天，那么小Q回对每一天的学习状态打一个分，
 * 他对一段时间学习状态的评分为这段时间学习状态最低的分数与这段时间学习状态分数之和的乘积，
 * 小Q想知道他在这个学期中学习状态评分最高的时间段评分为多少?
 */

//单调栈（栈顶放最小的）
public class Main04 {
    static class Range{
        int left;
        int right;
        public Range(int left,int right){
            this.left  =left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n = scanner.nextInt();  //总天数
        int [] scores = new int[n]; //分数
        for(int i=0;i<n;i++){
            scores[i] = scanner.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        int [] sum = new int[n];
        Range[] tmp = new Range[n];
        for(int i=0;i<n;i++){
            if(i==0){
                sum[i] = scores[i];
            }else{
                sum[i] = sum[i-1]+scores[i];
            }
            tmp[i]=new Range(i,i);
            while(!stack.isEmpty() && scores[stack.peek()]>scores[i]){
                tmp[stack.peek()].right = i-1;
                tmp[i].left = tmp[stack.peek()].left;
                stack.pop();
            }
            stack.push(i);
        }

        int t = 0;
        if(!stack.isEmpty())
            t = stack.peek();
        while(!stack.isEmpty()){
            tmp[stack.peek()].right = t;
            stack.pop();
        }
        long res = 0;
        for(int i=0;i<n;i++){
            if(tmp[i].left<1){
                res = Math.max(res,scores[i]*(sum[tmp[i].right]));
            }else{
                res = Math.max(res,scores[i]*(sum[tmp[i].right]-sum[tmp[i].left-1]));
            }
        }
        System.out.println(res);
    }
}
