package interviewTop100;

import java.util.ArrayList;
import java.util.List;

public class leetcode22
{
	/**
	 * 括号生成
	 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

	 */
	
	//回溯法
	public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        backtrack(res,"",0,0,n);
        return res;
	}

	private void backtrack(List<String> res, String str, int open, int close, int max){
	   if(str.length()==max*2) {
		   res.add(str);
	       return;
	   }
	   
	   if(open<max) 
		   backtrack(res, str+"(", open+1, close, max);
	   if(close<open)
		   backtrack(res, str+")", open, close+1, max);
		
	}

}
