package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class leetcode_combinationSum
{
	/**
	 * combination-sum
	 * Given a set of candidate numbers ( C ) and a target number ( T ), find all unique combinations in C where the candidate numbers sums to T .
	 * The same repeated number may be chosen from C unlimited number of times.
	 * Note:
	 * All numbers (including target) will be positive integers.Elements in a combination (a 1, a 2, … , a k) must be in non-descending order. (ie, a 1 ≤ a 2 ≤ … ≤ a k).
	 * The solution set must not contain duplicate combinations.
	 * For example, given candidate set2,3,6,7and target7, 
	 * A solution set is: [7] [2, 2, 3]
	 */
	 public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
	    ArrayList<ArrayList<Integer>> res = new ArrayList<>();  
	    ArrayList<Integer> list = new ArrayList<>();
	    if(candidates==null || candidates.length<=0) return res;
	    Arrays.sort(candidates);
	    dfs(candidates,target,0,list,res);
	    return res;
	 }


	private void dfs(int[] candidates, int diff, int start, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res)
	{
		if(diff==0) {
			res.add(new ArrayList<>(list));
			return;
		}
		
		for(int i=start;i<candidates.length;i++) {
			if(diff<candidates[i]) return;
			list.add(candidates[i]);
			dfs(candidates, diff-candidates[i], i, list, res);
			list.remove(list.size()-1);
		}	
	}
}
