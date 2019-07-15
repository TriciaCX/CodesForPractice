package interviewTop100;

public class leetcode53
{
	/*
	 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:
输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶:
如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
	 */
	
	
	/**
	 * dp 动态规划
	 * 动态递归： 主要是利用逐步求解，以连续数组结束位置为每一步的解，sum其实就是记录了上一步骤的解，在这一步骤进行对比，如果上一步骤的解<0则舍弃。最终得到这一步骤解，与之前步骤解的最大值res进行比较，保存当前的最优解。
	 * 
	 *动态规划的是首先对数组进行遍历，当前最大连续子序列和为 sum，结果为 ans
如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
每次比较 sum 和 ans的大小，将最大值置为ans，遍历结束返回结果
	 */
	public int maxSubArray(int[] nums) {
		int ans = nums[0];
		int sum = 0; //当前最大连续子序列和为 sum
		for(int num: nums) {
			sum = sum>0?sum+num:num;
			ans = Math.max(ans,sum);
		}
		return ans;        
	}
}
