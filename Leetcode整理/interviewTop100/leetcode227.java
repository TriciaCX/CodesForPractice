package interviewTop100;

import java.util.ArrayList;
import java.util.Stack;

public class leetcode227
{
/**
 * 基本计算器
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。

字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。

示例 1:

输入: "3+2*2"
输出: 7
示例 2:

输入: " 3/2 "
输出: 1
示例 3:

输入: " 3+5 / 2 "
输出: 5
 */
	public static void main(String[] args) {
		String string = "3+2*2";
	    System.out.println(calculate(string));	
	}
	
	public static int calculate(String s) {
		s = s.replace(" ", "");
		System.out.println(s);
		int res = 0, d = 0;
		char sign = '+';
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)>='0') { //+ - * /的ASCII值都小于'0'
				d = d*10-'0'+s.charAt(i);
			}
			if((s.charAt(i)<'0' || i==s.length()-1)) {
				if(sign=='+') {
					stack.push(d); 
				}else if (sign=='-') {
					stack.push(-d);
				}else if (sign=='*') {
					stack.push(stack.pop()*d);
				}else if (sign=='/') {
					stack.push(stack.pop()/d);
				}
				sign = s.charAt(i);
		      	d = 0;
			}
			
		}
	 
		while(!stack.isEmpty()) {
			res+=stack.pop();
		}
		return res;
	}
}
