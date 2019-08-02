package interviewTop100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode17
{
	/**
	 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。给出数字到字母的映射如下（与电话按键相同）。注意 1不对应任何字母。
	 * 示例:
输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
	 */
	public List<String> letterCombinations(String digits) {

		if(digits.length()==0||digits==null) 
			return new ArrayList<String>();

		Map<Integer,String> map = new HashMap<>();
		map.put(2,"abc");
		map.put(3,"def");
		map.put(4,"ghi");
		map.put(5,"jkl");
		map.put(6,"mno");
		map.put(7,"pqrs");
		map.put(8,"tuv");
		map.put(9,"wxyz");
		
		return letterCombinations(digits,map);
	}


	public List<String> letterCombinations(String digits,Map<Integer,String> map){
		List<String> now = new ArrayList<>();

		if(digits.length() == 1){
			String s = map.get(Integer.parseInt(digits));
			for(int i=0;i<s.length();i++){
				now.add(""+s.charAt(i));
			}
			return now;
		}

		List<String> pre = letterCombinations(digits.substring(1),map);
		String head = map.get(Integer.parseInt(digits.substring(0,1)));


		for(String s : pre){
			for(int j=0;j<head.length();j++){
				now.add(head.charAt(j)+s);
			}

		}
		return now;
	}


	
	
	

	class Solution{

		private String letterMap[] = {
				" ",    //0
				"",     //1
				"abc",  //2
				"def",  //3
				"ghi",  //4
				"jkl",  //5
				"mno",  //6
				"pqrs", //7
				"tuv",  //8
				"wxyz"  //9
		};

		private ArrayList<String> res = new ArrayList<>();

		public List<String> letterCombinations(String digits) {
            if(digits==null || digits.length()==0)
            	return res;
            getCombinations(digits,0,"");
            return res;
		}

		private void getCombinations(String digits, int index, String str){
			if(index==digits.length()) {
				res.add(str);
				return;
			}
			
			Character c = digits.charAt(index);
			String s = letterMap[c-'0'];
			for(int i= 0;i<s.length();i++) {
			     getCombinations(digits, index+1, str+s.charAt(i));
			}
            return;
			
		}

	}
}