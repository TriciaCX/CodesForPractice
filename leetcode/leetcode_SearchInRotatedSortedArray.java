package LeetCode;

public class leetcode_SearchInRotatedSortedArray
{
	/*
	 * search-in-rotated-sorted-array
	 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
	 * (i.e.,0 1 2 4 5 6 7might become4 5 6 7 0 1 2).
	 * You are given a target value to search. If found in the array return its index, otherwise return -1.
	 * You may assume no duplicate exists in the array.
	 */
	//暴力解法
	public int searchII(int[] A, int target) {
       if(A==null||A.length<=0) return -1;
       for(int i=0;i<A.length;i++) {
    	   if(A[i]==target) 
    		   return i;
       }
       return -1;
	}
    //
	/**
     *       L     M     R
     *   |-------|---|-------|
     *   | 0 1 2 | 4 | 5 6 7 |
     *   | 7 0 1 | 2 | 4 5 6 |
     * T | 6 7 0 | 1 | 2 4 5 |
     *   | 5 6 7 | 0 | 1 2 4 |
     *   |-------|---|-------|
     *   | 4 5 6 | 7 | 0 1 2 |
     * B | 2 4 5 | 6 | 7 0 1 |
     *   | 1 2 4 | 5 | 6 7 0 |
     *   |-------|---|-------|
     */
 
	public int search(int[] A, int target) {
		if(A==null||A.length<=0) return -1;
		int low = 0;
		int high = A.length;
		while(low<=high) {
			int mid = (low+high)>>1;
			if(A[mid]==target) return mid;
			
			//target在T区 且在M+L区
			if(A[mid]<A[high] && A[mid]<target && target<=A[high])
				low = mid+1;
			// target在B区 且 不在L+M区
			else if(A[mid]>A[high] &&!(A[low]<=target && target<A[mid]))
				low = mid +1;
			else {
				high = mid+1;
			}
		}
		return -1;
	}
}
