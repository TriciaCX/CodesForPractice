package interviewTop100;

import java.util.Arrays;
import java.util.HashMap;

public class leetcode169
{
	/**
	 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在众数。

示例 1:
输入: [3,2,3]
输出: 3

示例 2:
输入: [2,2,1,1,1,2,2]
输出: 2
	 */
	
	/**
	 * hash表方法
	 * @param nums
	 * @return
	 */
	public int majorityElement(int[] nums) {
		int len = nums.length;
		HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<len;i++) {
            if(!map.containsKey(nums[i])) {
            	map.put(nums[i], 1);
            }else {
            	int temp = map.get(nums[i]);
            	map.put(nums[i], temp+1);
            }
            if(map.get(nums[i])>len/2) {
                return nums[i];
            }
        }
        	
        return -1;           
	}
	
	/**
	 * 排序法
	 * @param nums
	 * @return
	 */
	 public int majorityElementII(int[] nums) {
	     Arrays.sort(nums);
	     return nums[nums.length/2];
	 }
	 
	 /**
	  * 投票法
	  * 我们假设将第一个数字作为众数看待，遍历数组，若元素 == 当前众数res则count += 1，否则count -= 1;
	  * 在下次count == 0时，意味着当前众数res的数量为已遍历元素一半；这种情况下，剩余数组众数仍等于原数组众数（因为最坏的情况是已遍历数组中一半是数组众数，一半是非众数）。
	  * 因此，在每次count == 0时，记录当前数字为当前众数，当遍历完整个数组时，留下的res一定为整个数组的众数（最坏情况是在最后一个元素才找到众数，前面的count全部抵消）。
	 */
	 public int majorityElementIII(int[] nums) {
		 int count = 0;
		 int candidate = 0;
		 for(int i=0;i<nums.length;i++) {						
			 if(count==0) {
				 candidate = nums[i];
			 }
			count += candidate==nums[i]? 1:-1;
		 }
		 return candidate;
	 }
	
}
