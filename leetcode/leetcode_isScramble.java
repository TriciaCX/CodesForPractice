package LeetCode;

import java.util.Arrays;

public class leetcode_isScramble
{
	/**
	 * 思路：从简单情况开始，
	 * 1.两个字符串都只有一个字符时只需比较是否相等
	 * 2.字符个数大于一时，先判断长度是否相等，在判断是否由相同的字符组成，若否，则直接返回false
	 * 3.分隔字符串，有两种情况，一种是不交换，一种是左右交换
	 */



	/*
		    题意：求s2是不是s1的爬行字符串，其实就是s1任意交换字母，看能不能交换成s2
		    1、当s1，s2长度为1时，直接判断s1==s2即可获得答案
		    2、当s1为ab，那么s2只能ab或者ba
		    3、
		    例如：
		    3.1、gr|eat 和 rg|eat从第2个位置进行分割，不进行交换
		    a1=gr b1=eat a2=rg b2=eat
		    此时需要判断
		    (gr, rg) && (eat, eat)
		    3.2、对于 re|at 和 ta|er从第2个位置进行分割
		    a1=re b1=at a2=ta b2=er，这种显然这种是不符合的
		    那么s2的两部分交换，那么s'=er|ta
		    a1=re b1=at a2`=er b2`=ta，这种显然是符合条件的
		    对于任意长度的字符串，我们可以把字符串s1分为a1，b1两部，s2分为a2，b2两部分
		    满足 (a1~a2) && (b1~b2) || (a1~b2) && (a2~b1)

		    4、剪枝，判断两个字符串是否有相同的字符集，没有则直接剪去这个分支
	 */

	public boolean isScramble(String s1, String s2) {
		if(s1==null||s2==null) return false;
		int len1 = s1.length();
		int len2 = s2.length();
		if(len1!=len2)
			return false;
		if(len1==1) 
			return s1.equals(s2);
		//剪枝：若排序后不相等必定不满足条件
		char[] chars1 = s1.toCharArray();
		char[] chars2 = s2.toCharArray();
		Arrays.sort(chars1);
		Arrays.sort(chars2);
		if(!(new String(chars1).equals(new String(chars2))))
			return false;

		for(int i=1;i<len1;i++) {
			String s1left = s1.substring(0,i);
			String s1right = s1.substring(i,len1);
			String s2left = s2.substring(0,i);
			String s2right = s2.substring(i,len2);

			//在当前分割处没有交换
			if(isScramble(s1left, s2left) && isScramble(s1right, s2right)) {
				return true;
			}
			//当前分割处左右交换
			s2right = s2.substring(len1-i,len1);
			s2left = s2.substring(0, len1-i); 

			if(isScramble(s1left, s2right) && isScramble(s1right, s2left)) {
				return true;
			}
		}
		return false;
	}
}
