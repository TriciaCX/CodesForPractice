package interviewTop100;

public class leetcode75
{
/**
 * 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
注意:
不能使用代码库中的排序函数来解决这道题。

示例:
输入: [2,0,2,1,1,0]
输出: [0,0,1,1,2,2]
进阶：
一个直观的解决方案是使用计数排序的两趟扫描算法。
首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
	//基于计数的两趟扫描
	public void sortColors(int[] nums) {
		int cnt0 = 0,cnt1 = 0,cnt2 = 0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==0) {
				cnt0++;
			}else if(nums[i]==1) {
				cnt1++;
			}else {
				cnt2++;
			}
		}
		
		int i = 0;
		while(cnt0>0) {
			nums[i++] = 0;
			cnt0--;
		}
		while(cnt1>0) {
			nums[i++] = 1;
			cnt1--;
		}
		while(cnt2>0) {
			nums[i++] = 2;
			cnt2--;
		}
	}
	
	//一趟扫描  荷兰国旗问题
	class Solution{
		public void sortColors(int[] nums) {
			int low = 0;
			int high = nums.length-1;
			int mid = 0;
			while(mid<=high) {
				if(nums[mid]==0) {
					swap(nums, low, mid);
					mid++;
					low++;
				}else if(nums[mid]==2) {
					swap(nums, mid, high);
					high--;
				}
				else {
					mid++;
				}
			}
		}

		private void swap(int[] nums, int low, int high){
			int tmp = nums[low];
			nums[low] = nums[high];
			nums[high] = tmp;			
		}
	}
}
