package 字节;

public class SearchRotateMatrix
{
	/**
	 * leetcode33
	 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
你可以假设数组中不存在重复的元素。
你的算法时间复杂度必须是 O(log n) 级别。
示例 1:
输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
	 */
	public int search(int[] nums, int target) {
       //找到旋转点--数组中最小的元素		
	   //二分查找目标值
		 if (nums == null || nums.length == 0) return -1;
	        int left = 0;
	        int right = nums.length - 1;
	        while (left < right) {
	            int mid = left + (right - left) / 2;
	            if (nums[mid] > nums[right]) 
	            	left = mid + 1;
	            else 
	            	right = mid;
	        }

	        int split_t = left; //旋转点
	        
	        left = 0;
	        right = nums.length - 1;
	        if (nums[split_t] <= target && target <= nums[right]) 
	        	left = split_t;
	        else 
	        	right = split_t;
	        while (left <= right) {
	            int mid = left + (right - left) / 2;
	            if (nums[mid] == target) 
	            	return mid;
	            else if (nums[mid] > target) right = mid - 1;
	            else left = mid + 1;
	        }
	        return -1;
	}
	
	//leetcode 81. 搜索旋转排序数组II(包含重复元素)
	public boolean searchII(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) 
            	return true;
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid])
                	right = mid - 1;
                else 
                	left = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[right])
                	left = mid + 1;
                else 
                	right = mid - 1;
            }
        }
        return false;  
    }


}
