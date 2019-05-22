package LeetCode;

import java.util.ArrayList;

public class leetcode_permutations
{
	/**
	 * permutations
	 * dfs求解
	 * Given a collection of numbers, return all possible permutations.
	 * For example,[1,2,3] have the following permutations:
	 * [1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2], and[3,2,1].
	 */
	 public ArrayList<ArrayList<Integer>> permute(int[] num) {
	     ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	     if(num==null||num.length==0) {
	    	 return res;
	     }
	     ArrayList<Integer> temp = new ArrayList<>();
	     boolean[] marked = new boolean[num.length];
	     dfs(num,marked,temp,res);
	     return res;
	 }


	private void dfs(int[] num, boolean[] marked, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res)
	{
		if(temp.size()==num.length) {
			res.add(new ArrayList<>(temp));
		}else {
			for(int i=0;i<num.length;i++) {
				if(!marked[i]) {
					marked[i]=true;
					temp.add(num[i]);
					dfs(num, marked, temp, res);
					temp.remove(temp.size()-1); //回溯 
					marked[i]=false;
				}
			}
		}
		
	}
}
