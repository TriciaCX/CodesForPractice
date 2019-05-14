package LeetCode;

import java.util.Stack;

public class leetcode_evaluateReversePolishNotation
{
	/*
	 * evaluate-reverse-polish-notation
	 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
	 * Valid operators are+,-,*,/. Each operand may be an integer or another expression.
	 * Some examples:  
	 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
	 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
	 */
	public int evalRPN(String[] tokens) {
       if(tokens==null||tokens.length<=0) return 0;
       int len = tokens.length;
       Stack<Integer> stack = new Stack<>();
       int res = 0;
       int temp1 = 0;
       int temp2 = 0;
       if(len==1) {
    	   res = Integer.parseInt(tokens[0]);
       }
       for(int i=0;i<len;i++) {
    	   if(tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/")) {
    		   temp1 = stack.pop();
    		   temp2 = stack.pop();
    		   if(tokens[i].equals("+")) res =temp2+temp1;
    		   if(tokens[i].equals("-")) res =temp2-temp1;
    		   if(tokens[i].equals("*")) res =temp2*temp1;
    		   if(tokens[i].equals("/")) {
    			  if(temp1!=0) {
    				  res =temp2/temp1;
    			  }else {
    				  res = Integer.MAX_VALUE;
    			  }
    		   }
    		   stack.push(res);
    	   }else {
    		   stack.push(Integer.parseInt(tokens[i]));
    	   }
       }
       return res;
	}
	
}
