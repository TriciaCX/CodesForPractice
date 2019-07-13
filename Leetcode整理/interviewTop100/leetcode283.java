package interviewTop100;

public class leetcode283
{
	/**
	 * 移动0
	 *给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
示例:
输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:
必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。

	 */

	//类似冒泡
	public void moveZeroes(int[] nums) {		
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==0) {
				for(int j=i;j<nums.length;j++) {
                    if(nums[j]!=0) {
                    	nums[i] = nums[j];
                    	nums[j] = 0;
                    }
				}
			}
		}
	}
	
	//双指针法
	/*
	 * 可以先把所有非0的元素移到前面，然后将后面的位置补0。 
	 * 使用指针i，指向需要插入的下标，使用指针j指向遍历的下标。
	 * 遍历一遍，如果j指向的位置为0，则i不变，j++后移；
	 * 如果j指向的位置不为0，则将j位置的元素值赋值到i位置，然后i++。
	 */
	public void moveZeroesII(int[] nums) {
		//i:插入位置下标 ; j:查找位置下标
		int i = 0; 
		for(int j = 0; j < nums.length; j++){
			if(nums[j] != 0){
				nums[i] = nums[j];
				i++;
			}
		}
		//将后面的位置补0
		for(int p = i; p < nums.length; p++){
			nums[p] = 0;
		}
	}

}
