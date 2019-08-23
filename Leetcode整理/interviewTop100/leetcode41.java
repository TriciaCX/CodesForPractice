package interviewTop100;

import java.util.HashSet;
import java.util.Set;

public class leetcode41
{
	/**
	 * 缺失的第一个正数
	 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。

示例 1:
输入: [1,2,0]
输出: 3

示例 2:
输入: [3,4,-1,1]
输出: 2

示例 3:
输入: [7,8,9,11,12]
输出: 1
	 */
	
	
	 public int firstMissingPositive(int[] nums) {
	       if(nums==null || nums.length==0)
	            return 1;
	       Set<Integer> set = new HashSet<>();
	       for(int num:nums) {
	    	  set.add(num);
	       }
	       
	       int target = 1;
	       for(int i=0;i<set.size();i++){
	    	   if(!set.contains(target)) {
	    		   return target;
	    	   }else {
	    		   target++;
	    	   }
	       }
	       return target;  
	    }
	 
	 
}
