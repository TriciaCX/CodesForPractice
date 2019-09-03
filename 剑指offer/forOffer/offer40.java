package forOffer;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class offer40 {
    /**
     * 最小的K个数
     * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
     */

    //堆
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
       ArrayList<Integer> res = new ArrayList<>();
        if(k>input.length||k<=0) return res;
       PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->o2-o1); //用大顶堆来维护最小堆
       for(int i=0;i<input.length;i++){
           pq.add(input[i]);
           if(pq.size()>k){
               pq.poll();
           }
       }
       for(int i:pq){
           res.add(i);
       }
       return res;
    }

    //快排
    public ArrayList<Integer> GetLeastNumbers_SolutionII(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (k > input.length || k <= 0) return res;
        findKthSmallest(input,k-1);  /*findKthSmallest会改变数组，使得前K个数都是最小的K个数*/
        for(int i=0;i<k;i++){
            res.add(input[i]);
        }
        return res;
    }

    private void findKthSmallest(int[] num, int k) {
        int low=0,high=num.length-1;
        while(low<high){
            int j = partition(num,low,high);
            if(j==k)
                break;
            if(j>k)
                high = j-1;
            else
                low = j+1;
        }
    }

    private int partition(int[] num, int low, int high) {
        int p = num[low];  //切分元素
        int i = low,j=high+1;
        while(true){
            while (i!=high && num[++i]<p);
            while (j!=low && num[--j]>p);
            if(i>=j) break;
            swap(num,i,j);
        }
        swap(num,low,j);
        return j;
    }

    private void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}
