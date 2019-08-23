package interviewTop100;

import java.util.ArrayList;
import java.util.List;

public class leetcode442
{
	/**
	 * 数组中重复的数据
	 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
找到所有出现两次的元素。
你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？

示例：
输入:
[4,3,2,7,8,2,3,1]

输出:
[2,3]
	 */
    public static void main(String[] args) {
    	int[] nums = {4,3,2,7,8,2,3,1};
    	List<Integer> list = findDuplicates(nums);
    	System.out.println(list);
    }
	
	//抽屉原理
	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> list = new ArrayList<>();
        if(nums==null || nums.length<2)
        	return list;
        for(int num:nums) {
        	if(nums[Math.abs(num) - 1]>0) {
        		nums[Math.abs(num)-1]*=-1;
        	}else {
        		list.add(Math.abs(num));
        	}
        }
        
        return list;
	}


}
