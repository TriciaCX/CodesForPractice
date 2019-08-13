package interviewTop100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode86
{
	/**
	 * 三数之和
	 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
	 * 注意：答案中不可以包含重复的三元组。
	 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if(nums==null || nums.length<3) return res;
        Arrays.sort(nums);
        int mid= 0;
        int high =0;
        for(int low=0;low<nums.length-2;low++) {  //i<j<k
        	if(nums[low]>0)  break; //最小的数大于0的话，不可能有三数之和为0
        	if(low>0 && nums[low]==nums[low-1]) continue;  //这个数和之前的数相同，再找的一定是重复的组合（虽然索引不同，但数字相同）
        	mid = low+1;
        	high = nums.length-1;
        	while(mid<high) {
        		int tmp = nums[low]+nums[mid]+nums[high];
        		if(tmp==0) {
        			ArrayList<Integer> list = new ArrayList<>(Arrays.asList(nums[low],nums[mid],nums[high]));
        			res.add(list);
        			while(mid<high && nums[mid]==nums[++mid]);
        			while(mid<high && nums[high]==nums[--high]);
        		}else if (tmp<0) {
        			while(mid<high && nums[mid]==nums[++mid]);
				}else if (tmp>0) {
					while(mid<high && nums[high]==nums[--high]);
				}
        	}
        }
		return res;
	}
}
