package interviewTop100;

public class leetcode29{
	/**
	 * 两数相除
	 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

返回被除数 dividend 除以除数 divisor 得到的商。

示例 1:

输入: dividend = 10, divisor = 3
输出: 3
示例 2:

输入: dividend = 7, divisor = -3
输出: -2
说明:

被除数和除数均为 32 位有符号整数。
除数不为 0。
假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
	 */
	
	//除数倍增,商的计数器count也倍增,直到除数刚好比被除数小,就用被除数减去除数,更新数值,再进行下一次循环,直到被除数绝对值小于除数绝对值,其间需要考虑除数溢出,count溢出的情况。
	public int divide(int dividend, int divisor) {
		 if(dividend==Integer.MIN_VALUE && divisor==-1)
			 return Integer.MAX_VALUE;
		 int flag = 1;
		 if(dividend<0 ^ divisor<0) {
			 flag = -1;
		 }
		 int cnt = 0;
		 int tmpd = 0;
		 int k =0;
		 //全都转换为负数
		 dividend = -Math.abs(dividend);
		 divisor = -Math.abs(divisor);
		 while(dividend<=divisor) {
			 tmpd = divisor; 
			 k = 1;
			 while(dividend<=tmpd+tmpd && tmpd+tmpd<0) { //除数倍增，
				 tmpd+=tmpd; 
				 k+=k;
			 }
			 dividend-=tmpd; 
			 cnt+=k;
		 }
		 return cnt*flag;	 
	}	
}
