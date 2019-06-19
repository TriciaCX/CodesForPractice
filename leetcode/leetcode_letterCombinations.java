package LeetCode;

import java.util.ArrayList;

public class leetcode_letterCombinations
{
	/**
	 * letter-combinations-of-a-phone-number
	 * 给定一个数字字符串，返回该数字可能代表的所有可能的字母组合。
	 * 下面给出了数字到字母的映射（就像在电话按钮上一样）。
	 * Given a digit string, return all possible letter combinations that the number could represent.
	 * A mapping of digit to letters (just like on the telephone buttons) is given below.
	 * Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
	 */
	String[] map = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	public ArrayList<String> letterCombinations(String digits) {    
		ArrayList<String> res = new ArrayList<>();
		if(digits==null) {
			res.add("");
			return res;
		}    
		dfs(0,digits,res,"");
		return res;

	}
	private void dfs(int index, String digits, ArrayList<String> res, String string)
	{
		if(index==digits.length() && string!=null) {
			res.add(string);
			return;
		}
		String temp = map[Character.getNumericValue(digits.charAt(index))];
		for(char c:temp.toCharArray()) {
			dfs(index+1, digits, res, string+c);
		}
	}
}
