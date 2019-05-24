package LeetCode;

public class leetcode_pow
{
	/**
	 * powx-n
	 * Implement pow(x, n).
	 * 设置一个中间变量tmp记录平方值，来折半计算， 将O(n)降为O(logn)
	 */
	
	 public double pow(double x, int n) {
	        double res = 1.0;
	        double temp = x;
	        for(int i=n;i!=0;i/=2) {
	        	if(i%2!=0) 
	            	 res *=temp;
	        	temp *=temp;
	        }
	        return n>0?res:1/res;
	    }

}
