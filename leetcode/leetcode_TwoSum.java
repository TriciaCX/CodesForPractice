package LeetCode;

import java.util.HashMap;

public class leetcode_TwoSum
{

	public int[] twoSum(int[] nums, int target)
	{
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++)
		{
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++)
		{
			int other = target - nums[i];
			if (map.containsKey(other) && map.get(other) != i)
			{
				return new int[] { i, map.get(other) };
			}
		}
		return null;

	}


}
