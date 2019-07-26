package interviewTop100;


public class leetcode215
{
/*
 * 数组中的第k大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
示例 2:

输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
 */



	/**
	 * 随机选择一个枢轴。
	 * 使用划分算法将枢轴放在数组中的合适位置 pos。将小于枢轴的元素移到左边，大于等于枢轴的元素移到右边。
	 * 比较 pos 和 N - k 以决定在哪边继续递归处理。
	 */
	public int findKthLargest(int[] nums, int k) {
		k= nums.length-k;
		int left = 0;
		int right = nums.length-1;
		while(left<right) {
			int j = partition(nums,left,right);
			if(j==k) {
				break;
			}else if(j<k) {
				left = j+1;
			}else {
				right = j-1;
			}
		}
		return nums[k];
	}

	private int partition(int[] nums, int left, int right){
		int i = left;
		int j = right;
		while(true) {
			while(nums[++i]<nums[left] && i<right);
			while(nums[--j]>nums[right] && j>left);
			if(i>=j) {
				break;
			}
			swap(nums,i,j);
			return j;
		}
		return 0;
	}

	private void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;		
	}

}
