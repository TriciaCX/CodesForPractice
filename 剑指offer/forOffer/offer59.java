package forOffer;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class offer59 {
    /**
     * 滑动窗口的最大值
     * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
     * 例如，如果输入数组 {2, 3, 4, 2, 6, 2, 5, 1} 及滑动窗口的大小 3，那么一共存在 6 个滑动窗口，他们的最大值分别为 {4, 4, 6, 6, 6, 5}。
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
      ArrayList<Integer> res = new ArrayList<>();
      if(size>num.length || size<1) return res;
      PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->o2-o1); //大顶堆
      for(int i=0;i<size;i++){
          pq.add(num[i]);
      }
      res.add(pq.peek());
      for(int i=0,j=i+size;j<num.length;i++,j++){ /*维护这个大顶堆*/
          pq.remove(num[i]);
          pq.add(num[j]);
          res.add(pq.peek());
      }
      return res;
    }
}
