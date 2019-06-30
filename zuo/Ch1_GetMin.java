import java.util.Stack;
public class Ch1_GetMin
{
	/**
	*1.1 
	*leetcode 155 最小栈
	设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
	push(x) -- 将元素 x 推入栈中。
	pop() -- 删除栈顶的元素。
	top() -- 获取栈顶元素。
	getMin() -- 检索栈中的最小元素。
	*/
	

	class MinStack {
	        Stack<Integer> stack;
	        Stack<Integer> minStack;  
	    /** initialize your data structure here. */
	    public MinStack() {
	        this.stack= new Stack<>();
	        this.minStack = new Stack<>();   
	    }
	    
	    public void push(int x) { //压栈
	        stack.push(x);
	        if(minStack.isEmpty() || x<=minStack.peek()){
	            minStack.push(x);
	        }
	    }
	    
	    public void pop() { //删除栈顶的元素
	        if((minStack.peek()).equals(stack.pop())){
	            minStack.pop();
	        }
	    }
	    
	    public int top() {   //获取栈顶的元素
	        return stack.peek();
	    }
	    
	    public int getMin() { //检索栈的最小元素（常数时间）
	        return minStack.peek();
	    }
	}

	/**
	 * Your MinStack object will be instantiated and called as such:
	 * MinStack obj = new MinStack();
	 * obj.push(x);
	 * obj.pop();
	 * int param_3 = obj.top();
	 * int param_4 = obj.getMin();
	 */
}
