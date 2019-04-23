package LeetCode;

public class leetcode_singleNumber
{
	/*
	 * Given an array of integers, every element appears twice except for one. Find that single one.
	 */
	
	/*
	 * 利用异或
	 * 1、一个数和0异或得到该数本身
	 * 2、两个相同的数异或得到0，遍历异或相当于消除了相同的数对于res的影响
	 */
	 public int singleNumber(int[] A) {
	        int res =0;
	        for(int i=0;i<A.length;i++) {
	        	res^=A[i];
	        	System.out.println("i="+i+" "+"res="+res);
	        }
	        return res;
	    }
	
	
}
