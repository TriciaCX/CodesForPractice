package LeetCode;

public class leetcode_RomanToInteger
{
	/*
	 * roman-to-integer
	 * Given a roman numeral, convert it to an integer.
	 * Input is guaranteed to be within the range from 1 to 3999.
	 */
		
		public int romanToInt(String s) {
			int[] nums = new int[s.length()];
			char[] chars = s.toCharArray();
			//拆字符串
			for (int i = 0; i < chars.length; i++) {
				switch (chars[i]){
				case 'M':
					nums[i] = 1000;
					break;
				case 'D':
					nums[i] = 500;
					break;
				case 'C':
					nums[i] = 100;
					break;
				case 'L':
					nums[i] = 50;
					break;
				case 'X':
					nums[i] = 10;
					break;
				case 'V':
					nums[i] = 5;
					break;
				case 'I':
					nums[i] = 1;
					break;
				}
			}
			//拼成数字
			int result = 0;
			for (int i = 0; i < nums.length-1; i++) {
				if (nums[i]<nums[i+1]) result -= nums[i];
				else result += nums[i];
			}
			result += nums[nums.length-1];
			return result;
		}

}
