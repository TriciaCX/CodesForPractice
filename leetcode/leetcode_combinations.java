package LeetCode;

import java.util.ArrayList;

public class leetcode_combinations
{
	/**
	 * combinations
	 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
	 * For example, If n = 4 and k = 2, a solution is:
	 * [
        [2,4],
        [3,4],
  		[2,3],
  		[1,2],
  		[1,3],
  		[1,4],
	   ]
	 */
	ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        if(n<k||k<=0) return res;
        ArrayList<Integer> temp = new ArrayList<>();
        dfs(1,n,k,temp);
		return res;
	}
	private void dfs(int start, int n, int k, ArrayList<Integer> temp)
	{
		if(k==0) {
			res.add(new ArrayList<>(temp));
		    return;
		}
		for(int i=start;i<=n;i++) {
			temp.add(i);
			dfs(i+1, n, k-1, temp);
			temp.remove(temp.size()-1);
		}
		
	}
}
