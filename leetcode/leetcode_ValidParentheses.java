package LeetCode;

import java.util.Stack;

public class leetcode_ValidParentheses
{
	/**
	 * valid-parentheses
	 * Given a string containing just the characters'(',')','{','}','['and']', determine if the input string is valid.
	 * The brackets must close in the correct order,"()"and"()[]{}"are all valid but"(]"and"([)]"are not.
	 */
	public boolean isValid(String s) {
		if(s==null||s==""||s.length()<2) return false;
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='[') {
				stack.push(s.charAt(i));
			}else {
				if(!stack.isEmpty()) {
					if(s.charAt(i)==')'&& stack.peek()!='(') return false;
					if(s.charAt(i)==']'&& stack.peek()!='[') return false;
					if(s.charAt(i)=='}'&& stack.peek()!='{') return false;
					stack.pop();
				}else {
					return false;
				}
			}
		}
		if(!stack.isEmpty()) return false;
		return true;
	}
}
