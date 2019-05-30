package LeetCode;

import java.util.ArrayList;
import java.util.Set;

public class leetcode_wordBreakII
{
	/**
	 * word-breakII
	 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
	 * Return all such possible sentences.
	 * For example, given s =catsanddog"", dict =["cat", "cats", "and", "sand", "dog"].
	 * A solution is["cats and dog", "cat sand dog"].
	 */
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> res = new ArrayList<>();
        if(s==null || dict==null || dict.size()==0)
        	return res;
        dfs(s,s.length(),"",dict,res);
        return res;
	}

	private void dfs(String s, int index, String string, Set<String> dict, ArrayList<String> res)
	{
		if(index<=0) {
			if(string.length()>0) {
				res.add(string.substring(0,string.length()-1));
			}
		}
		for(int i=index;i>=0;i--) {
			if(dict.contains(s.substring(i, index))) {
				dfs(s, i, s.substring(i,index) +" "+ string, dict, res);
			}
		}
		
	}
}
