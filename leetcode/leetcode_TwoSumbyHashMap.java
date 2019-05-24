package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class leetcode_TwoSumbyHashMap
{
	/**
	 * two-sum
	 * Given an array of integers, find two numbers such that they add up to a specific target number.
	 * The function twoSum should return indices of the two numbers such that they add up to the target,where index1 must be less than index2.
	 * Please note that your returned answers (both index1 and index2) are not zero-based.
	 * You may assume that each input would have exactly one solution.
	 * Input: numbers={2, 7, 11, 15}, target=9
	 * Output: index1=1, index2=2
	 */
	//暴力解
	public int[] twoSum(int[] numbers, int target) {
		int[] res=new int[2];
        if(numbers==null||numbers.length<2) return res;
        for(int i=0;i<numbers.length;i++) {
        	for(int j=i+1;j<numbers.length;j++) {
        		if(numbers[i]+numbers[j]==target) {
        			res[0]=i+1;
        			res[1]=j+1;
        			return res;
        		}
        	}
        }
        return res;
	}
	
	//hashMap求解
	public int[] twoSumII(int[] numbers, int target) {
		int[] res=new int[2];
        if(numbers==null||numbers.length<2) return res;
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<numbers.length;i++) {
        	if(map.containsKey(numbers[i])) {
        		res[0] = map.get(numbers[i])+1;
        		res[1] = i+1;
        		break;
        	}else {
        		map.put(target-numbers[i],i);
        	}
        }
        return res;
	}
}
