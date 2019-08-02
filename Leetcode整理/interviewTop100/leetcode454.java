package interviewTop100;

import java.util.HashMap;

public class leetcode454
{
/**
 * 四数相加
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。

为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。

例如:

输入:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

输出:
2

 */
	
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
       HashMap<Integer, Integer> map = new HashMap<>();
       for(int i=0;i<C.length;i++) {
    	   for(int j =0;j<D.length;j++) {
    		   int sum = C[i]+D[j];
    		   if(map.containsKey(sum)) {
    			   map.put(sum, map.get(sum)+1);
    		   }else {
    			   map.put(sum, 1);
    		   }
    	   }
       }
        
       int cnt = 0;
       for(int i=0;i<A.length;i++) {
    	   for(int j=0;j<B.length;j++) {
    		   int res = -(A[i]+B[j]);
    		   if(map.containsKey(res)) {
    			   cnt = cnt+map.get(res);
    		   }
    	   }
       }
       
       return cnt;
	}
}
