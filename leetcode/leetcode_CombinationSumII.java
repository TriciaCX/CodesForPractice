package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class leetcode_CombinationSumII
{
	/**
	 * combination-sum-ii
	 * Given a collection of candidate numbers ( C ) and a target number ( T ), 
	 * find all unique combinations in C where the candidate numbers sums to T .
	 * Each number in C may only be used once in the combination.
	 * Note:All numbers (including target) will be positive integers.
	 * Elements in a combination (a 1, a 2, … , a k) must be in non-descending order. (ie, a 1 ≤ a 2 ≤ … ≤ a k).
	 * The solution set must not contain duplicate combinations.
	 * For example, given candidate set10,1,2,7,6,1,5and target8, 
	 * A solution set is: 
	 * [1, 7]
	 * [1, 2, 5]
	 * [2, 6]
	 * [1, 1, 6]
	 */
	ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
		if(num==null||num.length<=0) return res;
		//先对num排个序
		Arrays.sort(num);
		ArrayList<Integer> temp = new ArrayList<>();
		dfs(num,0,target,temp);
        return res;
	}
	private void dfs(int[] num,int start, int diff, ArrayList<Integer> temp)
	{
		if(diff==0) {
			res.add(new ArrayList<>(temp));
			return;
		}
		if(diff<0)
			return;
		for(int i=start; i<num.length; i++) {
			if(i>start && num[i]==num[i-1]) { //这一步是为了去重吗？
				System.out.println(i+"start "+start);
				continue;
			}
			temp.add(num[i]);
			dfs(num, i+1, diff-num[i], temp);
			temp.remove(temp.size()-1);
		}
	}
}
