package interviewTop100;

public class leetcode371
{
/**
 * 两整数之和
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。

示例 1:

输入: a = 1, b = 2
输出: 3
示例 2:

输入: a = -2, b = 3
输出: 1

 */
	public int getSum(int a, int b) {
		if(b==0){
			return a;
		}
		int s1 = a ^ b;   //异或--按位加但不进位
		int s2 = (a & b) << 1;  //与--按位与并左移一位表示进位
		return getSum(s1,s2);        	
	}
	public static void main(String [] args) {
		System.out.println((3&2)<<1);
		System.out.println(3^2);
	}
}
