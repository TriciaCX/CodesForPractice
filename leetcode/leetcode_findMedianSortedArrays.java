package LeetCode;

public class leetcode_findMedianSortedArrays
{
	/*
	 * 寻找两个排序数组的中位数
	 * There are two sorted arrays A and B of size m and n respectively. 
	 * Find the median of the two sorted arrays. 
	 * The overall run time complexity should be O(log (m+n)).
	 */
	 public double findMedianSortedArrays(int A[], int B[]) {
	     if(A==null && B==null) return -1;
	     if(A==null) return findMedian(B);
	     if(B==null) return findMedian(A);
	     
	     int lenA = A.length;
	     int lenB = B.length;
	     int len = lenA+lenB;
	     
	     int[] C = new int[len];
	     
	     int i=0,j=0,k=0;
	     while(i<lenA||j<lenB) {
	    	 while(i<lenA&&j<lenB) {
	    		 if(A[i]<B[j]) {
	    			 C[k] = A[i];
	    			 i++;
	    		 }else {
	    			 C[k] = B[j];
	    			 j++;
	    		 }
	    		 k++;
	    	 }
	    	 if(i<lenA) {
	    		 for( ;k<len;i++,k++) {
	    			 C[k] = A[i];
	    		 }
	    	 }
	    	 if(j<lenB) {
	    		 for( ;k<len;j++,k++) {
	    			 C[k] = B[j];
	    		 }
	    	 }
	     }
	     
	     return findMedian(C);

	 }

	private double findMedian(int[] A)
	{
		if(A==null||A.length==0) return -1;
		
		int len = A.length;
		if(len%2==0) { //偶数
			return ((double)A[(len/2-1)]+(double)A[len/2])/2;
		}else { //奇数
			return (double)A[(len-1)/2];
		}
		
	}
	 
	
}
