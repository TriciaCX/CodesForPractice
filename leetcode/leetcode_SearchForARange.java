package LeetCode;

public class leetcode_SearchForARange
{
	/*
	 * search-for-a-range 
	 * Given a sorted array of integers, find the starting and ending position of a given target value.
	 * Your algorithm's runtime complexity must be in the order of O(log n).
	 * If the target is not found in the array, return[-1, -1].
	 * For example,Given[5, 7, 7, 8, 8, 10]and target value 8,return[3, 4].
	 */
	public int[] searchRange(int[] A, int target) {
		int[] res = {-1,-1};
		if(A==null||A.length<=0) return res;
		if(target<A[0]||target>A[A.length-1]) return res;
		int left = 0,right = A.length-1;
		int mid = (left+right)/2;
		int index1=-1,index2=-1;
		//使用二分查找到target
		while(left<=right) {
			if(A[mid]==target) {
				index1=mid;
				index2=mid;
				while(index1>=0&&A[index1]==target) index1--;
				while(index2<=A.length-1 && A[index2]==target) index2++;
				return new int[] {index1+1,index2-1};
			}
			if(A[mid]<target) {
				left = mid+1;
			}
			if(A[mid]>target) {
				right = mid-1;
			}
			mid = (left+right)/2;
		}
		res[0]=index1;
		res[1]=index2;
		return res;
	}
}
