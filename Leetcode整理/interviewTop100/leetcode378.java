package interviewTop100;

import java.util.Arrays;

public class leetcode378
{
/*
 * 有序矩阵中第K小的元素
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
请注意，它是排序后的第k小元素，而不是第k个元素。

示例:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

返回 13。

 */
	//暴力
	 public int kthSmallest(int[][] matrix, int k) {
	     int n = matrix.length;
	     int[] arr = new int[n*n];
	     int idx = 0;
	     for(int i=0;i<n;i++) {
	    	 for(int j=0;j<n;j++) {
	    		 arr[idx++] = matrix[i][j];
	    	 }
	     }
	     Arrays.sort(arr);
	     return arr[k-1];
	 }
	 
	 //二分查找
	 /**
	  * 二分查找法来做，
	  * 我们由于是有序矩阵，那么左上角的数字一定是最小的，而右下角的数字一定是最大的，所以这个是我们搜索的范围，
	  * 然后我们算出中间数字mid，由于矩阵中不同行之间的元素并不是严格有序的，所以我们要在每一行都查找一下 mid，
	  * 我们使用 upper_bound，这个函数是查找第一个大于目标数的元素，如果目标数在比该行的尾元素大，则 upper_bound 返回该行元素的个数，
	  * 如果目标数比该行首元素小，则 upper_bound 返回0, 
	  * 我们遍历完所有的行可以找出中间数是第几小的数，然后k比较，进行二分查找，left 和 right 最终会相等，并且会变成数组中第k小的数字
	  * 
	  * 
	  * 上面的解法还可以进一步优化到 O(nlgX)，其中X为最大值和最小值的差值，我们并不用对每一行都做二分搜索法，我们注意到每列也是有序的，
	  * 我们可以利用这个性质，从数组的左下角开始查找，如果比目标值小，我们就向右移一位，
	  * 而且我们知道当前列的当前位置的上面所有的数字都小于目标值，那么 cnt += i+1，反之则向上移一位，这样我们也能算出 cnt 的值。
	  */
     public int kthSmallestII(int[][] matrix, int k) {
    	 int n = matrix.length;
    	 int low = matrix[0][0]; 
    	 int high = matrix[n-1][n-1];
    	 while(low<high) {
    		 int mid = low + (high-low)>>1;
    		 int count = 0;
    		 int j = matrix[0].length-1;
    		 for(int i = 0;i<matrix.length;i++) {
    			 while(j>=0 && matrix[i][j]>mid) j--; //寻找小于等于mid的元素的个数
    			 count+=j+1; //当前列的当前位置上面所有的数字都小于目标值
    		 }
    		 if(count<k) 
    			 low = mid+1;
    		 else 
				 high = mid;
			
    	 }
    	 return low;
     }
}
