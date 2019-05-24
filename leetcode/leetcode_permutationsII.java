package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class leetcode_permutationsII
{
	/**
	 * permutations-ii
	 * Given a collection of numbers that might contain duplicates,
	 * return all possible unique permutations.
	 * For example,[1,1,2]have the following unique permutations:
	 * [1,1,2],[1,2,1], and[2,1,1].
	 */
	ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
	Set<ArrayList<Integer>> resSet = new HashSet<>();
	boolean[] visited;
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		if(num==null||num.length<=0) return res;
		visited = new boolean[num.length];
		ArrayList<Integer> temp = new ArrayList<>();
		dfs(num,visited,temp);
		for (ArrayList<Integer> list : res)
		{
			resSet.add(list);
		}
		for (ArrayList<Integer> list : resSet)
		{
			resList.add(list);
		}
		return resList;
		
	}
	private void dfs(int[] num, boolean[] visited, ArrayList<Integer> temp)
	{
		if(temp.size()==num.length) {
			res.add(new ArrayList<>(temp));
			return;
		}
		for(int i=0;i<num.length;i++) {
			if(!visited[i]) {
				visited[i]=true;
				temp.add(num[i]);
				dfs(num, visited, temp);
				temp.remove(temp.size()-1);
				visited[i]=false;
			}

		}

	}
}
