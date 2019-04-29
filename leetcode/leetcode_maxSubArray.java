package LeetCode;

public class leetcode_maxSubArray
{
	/*
	 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
	 * For example, given the array[−2,1,−3,4,−1,2,1,−5,4], the continuous subarray[4,−1,2,1]has the largest sum =6.
	 * More practice: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
	 */
	
	//从头开始累加，直到和为负。此时前面这段不能给后面的串带来正收益，应舍弃，sum清零
	//然后在开始统计最大的sum.
	 public int maxSubArray(int[] A) {
	    int len = A.length;
	    int sum = 0;
	    int max = A[0];
	    for(int i=0;i<len;i++) {
	    	sum +=A[i];
	    	if(max<sum) max = sum;
	    	if(sum<  0) sum=0;

	    }
	    return max;
	 }
}
