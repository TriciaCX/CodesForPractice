package interviewTop100;

import java.util.Stack;

public class leetcode155
{
	class MinStack {

		Stack<Integer> stack;
		Stack<Integer> minStack; 
	    /** initialize your data structure here. */
	    public MinStack() {
	       this.stack = new Stack<>();
	       this.minStack = new Stack<>();
	    }
	    
	    public void push(int x) {
	        stack.push(x);
	        if(minStack.isEmpty()) {
	        	minStack.push(x);
	        }else {
	        	if(minStack.peek()>x) {
	        		minStack.push(x);
	        	}else {
	        		minStack.push(minStack.peek());
	        	}
	        }
	    }
	    
	    public void pop() { //删除栈顶元素
	       stack.pop();
	       minStack.pop();
	    }
	    
	    public int top() {
	       return stack.peek();       
	    }
	    
	    public int getMin() {
            if(minStack.isEmpty()){
                return -1;
            }
	        return minStack.peek();
	    }
	}
}
