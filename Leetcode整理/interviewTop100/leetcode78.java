package interviewTop100;

import java.util.ArrayList;
import java.util.List;

public class leetcode78
{
	/**
	 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
说明：解集不能包含重复的子集。
示例:
输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
	 */
	
	public static void main(String [] args) {
		int[] nums = {1,2,3};
		leetcode78 sl = new leetcode78();
		List<List<Integer >> res =sl.subsets(nums);
		for (List<Integer> list : res)
		{
			for(Integer i:list) {
				System.out.print(i+",");
			}
			System.out.println();
		}
	}
	
	//回溯解法
	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> subsets(int[] nums) {
	    getSet(0,nums,new ArrayList<Integer>());
		return res;
	}
	private void getSet(int start, int[] nums, ArrayList<Integer> tmp)
	{
		res.add(new ArrayList<>(tmp)); // 一定要new一个出来
		
		for(int i=start;i<nums.length;i++) {
			tmp.add(nums[i]);
			getSet(i+1, nums, tmp);
			tmp.remove(tmp.size()-1);
		}
		
	}
	
	
}
