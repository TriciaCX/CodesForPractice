package interviewTop100;

import java.util.Arrays;


public class leetcode300
{
/**
 * 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4 
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
说明:

可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
你算法的时间复杂度应该为 O(n2) 。
进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
	
	//动态规划 O(N^2)，其实是嵌套循环？
	public int lengthOfLIS(int[] nums) {   
		if(nums.length==0 || nums==null)
			return 0;
		int[] dp =new int[nums.length];
		dp[0] = 1;
		int res = 1;
		for(int i=1;i<nums.length;i++) {
			int max = 0;
			for(int j=0;j<i;j++) {
				if(nums[j]<nums[i])
					max = Math.max(max, dp[j]);
			}
			dp[i] = max +1;
			res = Math.max(res, dp[i]);
		}
		return res;
	}
	
	//动态规划+二分搜索
	/**
	 * 在这种方法中，我们从左到右扫描数组。我们还使用了 0 初始化的 dp数组。此 dp数组用于存储当前遇到的元素形成的上升子序列。
	 * 当遍历 nums数组时，我们继续用到目前为止遇到的元素填充 dp数组。
	 * 对应与jth（nums[j]）对应的元素，我们通过使用二分搜索（由于 dp数组存储递增的子序列，因此可以使用二分搜索）来确定其在 dp数组中的正确位置，需要注意的一个重要点是，对于二分搜索，我们只考虑 dp数组中通过在其正确位置插入一些元素（始终保持排序）进行更新的那部分.
	 * 因此，只有到 dp数组中的 ith的元素才能确定当前元素在其中的位置。
	 * 因为，元素在 dp 数组中以升序输入其正确的位置（i）。到目前为止形成的子序列肯定是一个不断增加的子序列。
	 * 只要这个位置索引 i等于到目前为止形成的 lis 的长度（len），就意味着我们需要将 len 更新为 len=len+1。
	 * 注意：dp数组不会导致子序列的最长增加，但 dp数组的长度将为您提供 lis 的长度。
	 * 
	 * 时间复杂度：O(nlogn)。二分搜索需要花费 logn 的时间且调用 n 次。
	 * 空间复杂度：O(n)，用了大小为 n的矩阵 dp。
	 */
	public int lengthOfLISII(int[] nums) {
		int[] dp = new int[nums.length];
		int len =0;
		for(int num:nums) {
			int i = Arrays.binarySearch(dp, 0,len,num); //Arrays.binarySearch() 方法返回搜索键的索引，如果它包含在数组中，则返回(（插入点）-1）。
			if(i<0) {
				i = -(i+1);
			}
			dp[i] = num;
			if(i==len)
				len++;
		}
		return len;
	}
}
