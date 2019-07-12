package interviewTop100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class leetcode136
{
/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
示例 1:输入: [2,2,1] 输出: 1
示例 2:输入: [4,1,2,1,2] 输出: 4
 */
	
	//排序+遍历
	public int singleNumber(int[] nums) {
		Arrays.sort(nums);
		for(int i=0;i<nums.length-1;i++) {
			if(nums[i]!=nums[i+1]) {
				return nums[i];
			}
			i=i+1;
		}
		return nums[nums.length-1];
	}
	
	//hashmap
	public int singleNumberII(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			if(map.containsKey(nums[i]))
				map.put(nums[i], 2);
			else 
				map.put(nums[i], 1);
		}
		for(Integer i:map.keySet()) {
			if(map.get(i)==1)
				return i;
		}
		return -1;
	}
	 
	 //异或
	/*
	 * 既满足时间复杂度又满足空间复杂度，就要提到位运算中的异或运算XOR，主要因为异或运算有以下几个特点：
	 *  一个数和0做XOR运算等于本身：a⊕0 = a
	 *  一 个数和其本身做XOR运算等于0：a⊕a = 0
	 *  OR运算满足交换律和结合律：a⊕b⊕a = (a⊕a)⊕b = 0⊕b = b
	 */
	public int singleNumberIII(int[] nums) {
		int res = nums[0];
		for(int i=1;i<nums.length;i++) {
			res = res^nums[i];
		}
		return res;
	}
}
