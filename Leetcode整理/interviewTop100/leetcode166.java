package interviewTop100;

import java.util.HashMap;
import java.util.Map;

public class leetcode166{
	/**
	 * 分数到小数
	 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。

如果小数部分为循环小数，则将循环的部分括在括号内。

示例 1:

输入: numerator = 1, denominator = 2
输出: "0.5"
示例 2:

输入: numerator = 2, denominator = 1
输出: "2"
示例 3:

输入: numerator = 2, denominator = 3
输出: "0.(6)"
	 */
	public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0) return "0";
        StringBuffer sb = new StringBuffer();
        //两者只有一个为负数时，结果是负的
        if(numerator<0 ^ denominator<0) {
        	sb.append("-");
        }
        //考虑溢出的情况
        long divided = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        sb.append(String.valueOf(divided/divisor));
        long remainder = divided%divisor;
        //没有小数部分
        if(remainder==0) {
        	return sb.toString();
        }
        //有小数部分
        sb.append(".");
        Map<Long, Integer> map = new HashMap<Long, Integer>(); //字符+出现的位置
        while(remainder!=0) {
        	if(map.containsKey(remainder)) {
        		sb.insert(map.get(remainder), "(");  //出现循环部分，加括号
        		sb.append(")");
        		break;
        	}
        	map.put(remainder, sb.length());
        	remainder*=10;
        	sb.append(String.valueOf(remainder/divisor));
        	remainder%=divisor;
        }
        return sb.toString();
	}
}
