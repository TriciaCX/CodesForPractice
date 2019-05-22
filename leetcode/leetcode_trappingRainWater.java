package LeetCode;

public class leetcode_trappingRainWater
{
	/*
	 * trapping_rain_water
	 * Given n non-negative integers representing an elevation mapggggggggggggggggggg where the width of each bar is 1, compute how much water it is able to trap after raining
	 * For example, iven[0,1,0,2,1,0,1,3,2,1,2,1], return6.
	 */
	public int trap(int[] A) {
       if(A==null||A.length<=2) return 0;
       int maxInx = 0;
       int len = A.length;
       //找出数组最大值的下标
       for(int i=0;i<len;i++) {
    	   if(A[i]>A[maxInx]) {
    	       maxInx = i;
    	   }
       }
       int left=0, right=0,res=0;
       for(int i=0;i<maxInx;i++) {
    	   if(A[i]<left) {
    		   res+=left-A[i];
    	   }else {
    		   left=A[i];
    	   }
       }
       for(int i=A.length-1;i>maxInx;i--) {
    	   if(A[i]<right) {
    		   res+=right-A[i];
    	   }else {
    		   right=A[i];
    	   }
       }
       return res;
	}
}
