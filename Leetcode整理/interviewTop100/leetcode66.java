package interviewTop100;

import java.util.ArrayList;

public class leetcode66
{
/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
示例 2:

输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。
 */

	public int[] plusOne(int[] digits) {
		if(digits==null || digits.length==0)
			return new int[1];

		int carry = 0;
		int sum =0;
		for(int i=digits.length-1;i>=0;i--) {
			if(i==digits.length-1)
				sum = digits[i]+1+carry;
			else
				sum = digits[i]+carry;
			digits[i] = sum % 10;
			carry = sum/10; 
		}
		if(carry==0)
			return digits;
		else {
			int[] res = new int[digits.length+1];
			res[0] = 1;
			System.arraycopy(digits, 0, res, 1, digits.length);
			return res;
		}
	}
}
