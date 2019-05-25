package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class leetcode_3Sum
{
	/**
	 * 3-sum
	 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
	 * Find all unique triplets in the array which gives the sum of zero.
	 * Note:Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
	 * The solution set must not contain duplicate triplets.
	 */
	
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if(num==null||num.length==0) return res;
		Arrays.sort(num);
		int sum,left,right;
		for(int i=0;i<num.length-2;i++) {
			if(i!=0 && num[i]==num[i-1]) {
				continue;
			}
			left=i+1;
			right = num.length-1;
			while(left<right) {
				sum = num[left]+num[right];
				if(sum+num[i]==0) {
					ArrayList<Integer> temp = new ArrayList<>();
					temp.add(num[i]);
					temp.add(num[left]);
					temp.add(num[right]);
					res.add(temp);
					left++;right--;
					while(left<right && num[left]==num[left-1]) {
						left++;
					}
					while(left<right && num[right]==num[right+1]) {
						right--;
					}
				}else if (sum+num[i]<0) {
					left++;
				}else {
					right--;
				}
			}
		}
		return res;
	}
}
