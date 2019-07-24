package interviewTop100;

import java.util.Arrays;
import java.util.HashSet;

public class leetcode287
{
	/**
	 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。

示例 1:

输入: [1,3,4,2,2]
输出: 2
示例 2:

输入: [3,1,3,4,2]
输出: 3
说明：

不能更改原数组（假设数组是只读的）。
只能使用额外的 O(1) 的空间。
时间复杂度小于 O(n2) 。
数组中只有一个重复的数字，但它可能不止重复出现一次。。
	 */
	public int findDuplicate(int[] nums) {
       HashSet<Integer> set = new HashSet<>();
       for(Integer i:nums) {
    	   if(!set.add(i))
    		   return i;
       }
       return -1;
	}
	
	public int findII(int[] nums) {
		Arrays.sort(nums);
		for(int i=0;i<nums.length-1;i++) {
			if(nums[i]==nums[i+1])
				return nums[i];
		}
		return -1;
	}
	
	
	/*
	 * 弗洛伊德的乌龟和兔子（循环检测）
	 * 如果我们对 nums 进行这样的解释，即对于每对索引 i 和值 v_i而言，“下一个” v_j 位于索引 v_i处，我们可以将此问题减少到循环检测。
	 * 算法： 首先，我们可以很容易地证明问题的约束意味着必须存在一个循环。因为 nums中的每个数字都在 1和 n之间，所以它必须指向存在的索引。
	 * 此外，由于 0不能作为 nums 中的值出现，nums[0]不能作为循环的一部分。
	 * (抽象成链表的环)
	 * 我们看下数据结构，一个n+1大小的数组，数组内的元素为1~n,我们用1个索引对应一个相应的数字，例如数字1对应index1，那么肯定有多个数字对应了同一个index，那么这个index就是我们要找的重复数
因为我们不能用额外的空间，我们可以将这个特殊的数组想像成这样一个链表这个数据结构，链表结点的value为数组值，而同时链表的value又指向下一个链表结点。那么我们的问题可以抽象为在链表中找环的入口问题，使用一个fast指针和一个slow指针，先找到在环内的交点，然后从起点开始，和交点一起按照步长为1运动，最后的交点就是我们要找到重复数字
（快慢指针）

使用数组中的值作为索引下标进行遍历，遍历的结果肯定是一个环（有一个重复元素） 检测重复元素问题转换成检测环的入口 为了找到环的入口，可以进行如下步骤：

设置两个快慢指针， fast每次走两步，slow每次走一步，最终走了slow走了n步与fast相遇，fast走了2*n，fast可能比slow多饶了环的i圈，得到环的周长为n/i
slow指针继续走, 且另设第三个指针每次走一步，两个指针必定在入口处相遇
假设环的入口和起点的距离时m
当第三个指针走了m步到环的入口时
slow刚好走了n + m步，换句话说时饶了环i圈（环的周长为n/i）加m步（起点到入口的距离）
得到相遇的是环的入口，入口元素即为重复元素


	 */
	public int findIII(int[] nums) {
		int tortoise = nums[0];
		int hare = nums[0];
		do {
			tortoise = nums[tortoise];
			hare = nums[nums[hare]];
		} while (tortoise != hare);

		int ptr1 = nums[0];
		int ptr2 = tortoise;
		while (ptr1 != ptr2) {
			ptr1 = nums[ptr1];
			ptr2 = nums[ptr2];
		}

		return ptr1;
	}
	
	/*方法：二分法
	关键：这道题的关键是对要定位的“数”做二分，而不是对数组的索引做二分。要定位的“数”根据题意在 1 和 n之间，每一次二分都可以将搜索区间缩小一半。
	以 [1, 2, 2, 3, 4, 5, 6, 7] 为例，一共有 8 个数，每个数都在 1 和 7之间。
	1 和 7的中位数是 4，遍历整个数组，统计小于 4 的整数的个数，至多应该为 3个，如果超过 3 个就说明重复的数存在于区间 [1,4)（注意：左闭右开）中；否则，重复的数存在于区间 [4,7]（注意：左右都是闭）中。
	这里小于 4 的整数有 4个（它们是 1, 2, 2, 3），因此砍掉右半区间，连中位数也砍掉。以此类推，最后区间越来越小，直到变成 1 个整数，这个整数就是我们要找的重复的数。
	*/
	public int find(int[] nums) {
		int len = nums.length;
		int left = 1;
		int right = len-1;
		while(left<right) {
			int mid = (left+right)>>>1;
		    int cnt = 0;
		    for(int num:nums) {
		    	if(num<=mid) {
		    		cnt++;
		    	}
		    }
		    if(cnt>mid) {
		    	right = mid;
		    }else {
		    	left = mid+1;
		    }
		}
		return left;
	}
}
