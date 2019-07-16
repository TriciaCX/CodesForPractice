package interviewTop100;

import java.util.Stack;

public class leetcode7
{
/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:
输入: 123
输出: 321
 示例 2:
输入: -123
输出: -321
示例 3:
输入: 120
输出: 21
注意:
假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0
 */
	
	/*
	 * 本题最重要的是对溢出的处理
	 */
	  public int reverse(int x) {
		  int rev = 0;
	        while (x != 0) {
	            int pop = x % 10;
	            x /= 10;
	            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) 
	            	return 0;
	            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) 
	            	return 0;
	            rev = rev * 10 + pop;
	        }
	        return rev;
	  }
	  
	  //用long来解决溢出
	  public int reverseII(int x){
		  long temp=0;
		  while(x!=0){
			  temp*=10;
			  temp+=x%10;
			  x/=10;
		  }
		  if(temp<Integer.MIN_VALUE || temp>Integer.MAX_VALUE)
			  return 0;
		  return (int)temp;
	  }	
}
