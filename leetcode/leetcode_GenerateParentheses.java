package LeetCode;

import java.util.ArrayList;

public class leetcode_GenerateParentheses
{
	/*
	 * search-in-rotated-sorted-array
	 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
	 * (i.e.,0 1 2 4 5 6 7might become4 5 6 7 0 1 2).
	 * You are given a target value to search. If found in the array return its index, otherwise return -1.
	 * You may assume no duplicate exists in the array.
	 */
	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> res = new ArrayList<>();
		generateParenthesisCore(n,n,"",res);
		return res;
	}

	private void generateParenthesisCore(int left, int right, String temp, ArrayList<String> res)
	{
		if(left<0||right<0||left>right) return;
		if(left == 0 && right == 0) {
			res.add(temp);
			return;
		}
		generateParenthesisCore(left-1, right, temp+"(", res);
		generateParenthesisCore(left, right-1, temp+")", res);
	}
}
