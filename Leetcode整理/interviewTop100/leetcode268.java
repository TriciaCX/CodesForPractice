package interviewTop100;

import java.util.Arrays;
import java.util.HashSet;

public class leetcode268
{
	/**
	 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。

示例 1:

输入: [3,0,1]
输出: 2
示例 2:

输入: [9,6,4,2,3,5,7,0,1]
输出: 8
说明:
你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?

	 */
	
	//排序 O(NlogN)
	public int missingNumber(int[] nums) {
        Arrays.sort(nums);
		for(int i=0;i<nums.length;i++) {
    	   if(nums[i]!=i)
    		   return i;
        }
		return nums.length;
	}
	
	//哈希表
	public int missingNumberII(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for(Integer i:nums) {
			set.add(i);
		}
		
		for(int i=0;i<=nums.length;i++) {
			if(!set.contains(i))
				return i;
		}
		return -1;
	}
	
	//位运算
	//由于异或运算（XOR）满足结合律，并且对一个数进行两次完全相同的异或运算会得到原来的数，因此我们可以通过异或运算找到缺失的数字。
	public int misssingNumberIII(int[] nums) {
		int target = nums.length;  //设的初值就是n这就避免了下标的问题
		for(int i=0;i<nums.length;i++) {
			target^=i^nums[i];
		}
			
		return target;
	}
	
	//求和
	public int missingNumberIIII(int[] nums) {
		int len = nums.length;
		int sum = 0;
		for(int i=0;i<len;i++) {
			sum+=nums[i];
		}
		return len*(len+1)/2-sum;
	}
}
