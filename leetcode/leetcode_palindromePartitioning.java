package LeetCode;

import java.util.ArrayList;

public class leetcode_palindromePartitioning
{
	/**
	 * palindrome-partitioning
	 * Given a string s, partition s such that every substring of the partition is a palindrome.
	 * Return all possible palindrome partitioning of s.
	 * For example, given s ="aab",Return
	 *   [
	 *   ["aa","b"],
	 *   ["a","a","b"]
	 *   ]
	 */
	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> res = new ArrayList<>();
		ArrayList<String> temp = new ArrayList<>();
		if(s==null||s.length()==0||s.isBlank()) return res;
		dfs(s,0,temp,res);
		return res;  
	}

	private void dfs(String s, int index, ArrayList<String> temp, ArrayList<ArrayList<String>> res)
	{
		if(index==s.length()) {
			res.add(new ArrayList<>(temp));
			return;
		}

		for(int i=index+1;i<=s.length();i++) {
			if(isValid(s.substring(index,i))) {			
				temp.add(s.substring(index,i));
				dfs(s, i, temp, res);
				temp.remove(temp.size()-1);
			}
		}	
	}

	private boolean isValid(String str)
	{
		if(str==null)
			return false;
		int start=0;
		int end=str.length()-1;
		while(start<end) {
			if(str.charAt(start++)!=str.charAt(end--)) {
				return false;
			}
		}
		return true;
	}
	
}
