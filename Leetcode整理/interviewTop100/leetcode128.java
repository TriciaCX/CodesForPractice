package interviewTop100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leetcode128
{
	/**
	 * 最长连续序列
	 * 给定一个未排序的整数数组，找出最长连续序列的长度。

要求算法的时间复杂度为 O(n)。

示例:

输入: [100, 4, 200, 1, 3, 2]
输出: 4
解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
	 */
	
	
	//排序算法 O(nlogn)不符合题意
	public int longestConsecutive(int[] nums) {
		if(nums==null||nums.length==0)
			return  0;      
       Arrays.sort(nums);
       int len = 1;
       int tmp = 1;
       for(int i=1;i<nums.length;i++) {
           if(nums[i]==nums[i-1])
               continue;
    	   if(nums[i]==nums[i-1]+1) {
    		  tmp++; 
    	   }else {
    		   len = Math.max(tmp, len);
    		   tmp =1;
    	   }
           len = Math.max(tmp, len);
       }
       return len; 
	}
	
	//哈希表 O(n) 实际上比前一个跑得慢了
	
	public int longestConsecutiveII(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for(Integer num:nums) {
			set.add(num);
		}		
		int maxLen =0;
		for(int num:set) {
			if(!set.contains(num-1)) {
				int curNum = num;
				int len = 1;
				while(set.contains(curNum+1)) {
					len++;
					curNum++;
				}
				maxLen = Math.max(maxLen, len);
			}			
		}
		return maxLen;
	}
}
