package interviewTop100;

import java.util.PriorityQueue;

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
	 * 首先，我们选择一个枢轴，并在线性时间内定义其在排序数组中的位置。这可以通过 划分算法 的帮助来完成。

为了实现划分，沿着数组移动，将每个元素与枢轴进行比较，并将小于枢轴的所有元素移动到枢轴的左侧。

这样，在输出的数组中，枢轴达到其合适位置。所有小于枢轴的元素都在其左侧，所有大于或等于的元素都在其右侧。

这样，数组就被分成了两部分。如果是快速排序算法，会在这里递归地对两部分进行快速排序，时间复杂度为O(NlogN)。

而在这里，由于知道要找的第 N - k 小的元素在哪部分中，我们不需要对两部分都做处理，这样就将平均时间复杂度下降到O(N)。

具体做法
	 * 随机选择一个枢轴。
	 * 使用划分算法将枢轴放在数组中的合适位置 pos。将小于枢轴的元素移到左边，大于等于枢轴的元素移到右边。
	 * 比较 pos 和 N - k 以决定在哪边继续递归处理。
	 */
	public int findKthLargest(int[] nums, int k) {
		k = nums.length-k; 
		int left = 0;
		int right = nums.length-1;
		while(left<right) {
			int j = quickSort(nums,left,right);
			if(j==k) {
				return nums[j];
			}else if(j<k) {
				left = j+1;
			}else {
				right = j-1;
			}
		}
		return nums[k];
	}

	private int quickSort(int[] nums, int left, int right)
	{
		int i = left;
		int j = right+1;
		while(true) {
			while(nums[++i]<nums[left] && i<right);
			while(nums[--j]>nums[left] && j>left);
			if(i>=j)
				break;
			swap(nums,i,j);
		}
		swap(nums, left, j);
		return j;
	}

	private void swap(int[] nums, int i, int j)
	{
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;

	}	
	
	//method2 小顶堆，堆顶存放第k大元素 （堆是一颗完全二叉树）
	public int findKthLargestII(int[] nums, int k) {
		// init heap 'the smallest element first'
		PriorityQueue<Integer> heap =
				new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

		// keep k largest elements in the heap
		for (int n: nums) {
			heap.add(n);
			if (heap.size() > k)
				heap.poll();
		}

		// output
		return heap.poll();        
	}

}
