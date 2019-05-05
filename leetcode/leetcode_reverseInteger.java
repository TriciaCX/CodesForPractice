package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_reverseInteger
{
	/*
	 * reverse-integer
	 * Reverse digits of an integer.
	 * Example1: x = 123, return 321
	 * Example2: x = -123, return -321
	 */
	  public int reverse(int x) {
		
	     if(x==0) return x;
	     int t = 0;
	     Queue<Integer> queue = new LinkedList<Integer>();
	     while(x!=0) {
	    	t = x % 10;
	    	x = x / 10;
	    	queue.offer(t);
	     }
	     
	     int res = 0;
	     int size = queue.size();
	     for(int i=0;i<size;i++) {
	    	 res += queue.poll()*Math.pow(10, size-1-i);

	     }
         return res;
	  }
	  
	 
	//本题关键点是如何判断溢出
	//每次计算新的结果时，用逆运算判断与上一次循环的结果是否相同，不同就溢出
	public int reverseII(int x) {
	        int res=0;
	        while(x!=0){
	            //最后一位
	            int tail = x%10;
	            int newRes = res*10 + tail;
	            //如果newRes-tail)/10!=res说明产生了溢出
	            if((newRes-tail)/10!=res)
	                return 0;
	            res=newRes;
	            x=x/10;
	        }
	        return res;
	    }

}
