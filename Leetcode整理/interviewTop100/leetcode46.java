package interviewTop100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leetcode46
{
	/**
	 * 全排列
	 * 给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

	 */

	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> permute(int[] nums) {
        if(nums==null || nums.length==0)
        	return res;
        ArrayList<Integer> tmp = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
        	tmp.add(nums[i]);
        }
        backtrack(nums.length,tmp,0);
        return res;
	}
	private void backtrack(int length, ArrayList<Integer> tmp, int start)
	{
		if(start==length) {
			res.add(new ArrayList<Integer>(tmp));
		}
		
		for(int i= start;i<length;i++) {
			Collections.swap(tmp, start, i); //交换
			backtrack(length, tmp, start+1); //交换下一个
			Collections.swap(tmp, start, i); //回溯
		}
		
	}	
}
