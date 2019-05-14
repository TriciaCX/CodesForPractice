package LeetCode;

public class leetcode_IntegerToRoman
{
	/*
	 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
	 */
	
	/**
	 * Integer-to-roman
	 * Given an integer, convert it to a roman numeral.Input is guaranteed to be within the range from 1 to 3999.
	 * @param num
	 * @return
	 */
	public String intToRomanI(int num) {
        String[] r1 = {"","M","MM","MMM"};
        String[] r2 = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] r3 = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] r4 = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        
        return r1[num/1000]+r2[(num%1000)/100]+r3[(num%100)/10]+r4[num%10];
	}
	
	
	public String intToRomanII(int num) {
        int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] roman = {"M","CM","D","CD","C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"}; 
        StringBuilder sbBuilder = new StringBuilder();
        for(int i=0;i<nums.length;i++) {
        	while(num>=nums[i]) {
        		num = num-nums[i];
        		sbBuilder.append(roman[i]);
        	}
        }
        return sbBuilder.toString();
	}

}
