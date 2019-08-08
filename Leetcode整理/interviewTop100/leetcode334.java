package interviewTop100;

public class leetcode334
{
/**
 * 递增的三元子序列
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。

数学表达式如下:

如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。

示例 1:
输入: [1,2,3,4,5]
输出: true
示例 2:
输入: [5,4,3,2,1]
输出: false
 */
	
	
	/**
	 * 3个连续递增子序列
有3个槽位，a,b,c
满足条件 a < b < c，即可
需要将合适的元素填入这3个槽位
	 */
	
	//写法简单速度慢
	public boolean increasingTriplet(int[] nums) {
		if(nums==null || nums.length<3)
			return false;
		int a = Integer.MAX_VALUE;
		int b = Integer.MAX_VALUE;
		
		for(Integer num:nums) {
			if(num<=a) {
				a = num;
			}else if (num<=b) {
			    b = num;	
			}else {
				return true;
			}
		}
		return false;
	}
	
	//效率高
	public boolean increasingTripet(int[] nums) {
		if(nums==null || nums.length<3)
			return false;
	    int len = nums.length;
	    int low = Integer.MAX_VALUE;
	    int mid = Integer.MAX_VALUE;
	    int high = Integer.MAX_VALUE;
	    for(int i=0;i<len;i++) {
	    	int tmp = nums[i];
	    	if(tmp<low) {
	    		if(mid==Integer.MAX_VALUE) {
	    			low = tmp;
	    		}else if (tmp<high) {
	    			high = tmp;
	    		}else {
	    			low = high;
	    			mid = tmp;
	    			high = Integer.MAX_VALUE;
	    		}
	    	}else if (tmp>low) {
	    		if(tmp<mid) {
	    			mid = tmp;
	    		}else if (tmp>mid) {
	    			return true;
	    		}
	    	}

	    }
	    return false;
	}
}
