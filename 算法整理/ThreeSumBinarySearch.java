package 算法;

import java.util.Arrays;

public class ThreeSumBinarySearch implements ThreeSum
{

	/**
	 * 将数组进行排序，对两个元素求和，并用二分查找方法查找是否存在该和的相反数，如果存在，就说明存在和为 0 的三元组。
	 * 应该注意的是，只有数组不含有相同元素才能使用这种解法，否则二分查找的结果会出错。
	 * 该方法可以将 ThreeSum 算法增长数量级降低为 O(N2logN)。
	 */
	@Override
	public int count(int[] nums)
	{
		Arrays.sort(nums);
		int N=nums.length;
		int cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++){
				int target =-nums[i]-nums[j];
				int index = BinarySearch.search(nums,target);
				if(index>j) {
					cnt++;
				}
			}
		}
		return cnt;
	}

}
