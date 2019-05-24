package LeetCode;

import java.util.Stack;

public class leetcode_LongestValidParentheses
{
	/**
	 * longest-valid-parentheses
	 * Given a string containing just the characters'('and')',
	 * find the length of the longest valid (well-formed) parentheses substring.
	 * For"(()", the longest valid parentheses substring is"()", which has length = 2.
	 * Another example is")()())", where the longest valid parentheses substring is"()()", which has length = 4.
	 */
		public int longestValidParentheses(String s) {
	      int res = 0;
	      if(s==null||s.length()<=0||s=="") return res;
	      
	      Stack<Integer> stack = new Stack<>();
	      int flag=-1;
	      for(int i=0;i<s.length();i++) {
	    	  if(s.charAt(i)=='(') {
	    		  stack.push(i);
	    	  }else {
	    		  if(stack.isEmpty()) {
	    			  flag=i;
	    		  }else {
	    			  stack.pop();
	    			  if(stack.isEmpty()) {
	    				  res = Math.max(res, i-flag);
	    			  }else {
	    				  res = Math.max(res, i-stack.peek());
	    			  }
	    			  
	    		  }
	    	  }  
	      }
	      return res;
		}
}
