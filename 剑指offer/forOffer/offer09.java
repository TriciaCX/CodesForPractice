package forOffer;

import java.util.Stack;

public class offer09 {
    /**
     * 用两个栈实现队列
     * 用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack1.isEmpty()) {
            return -1;
        }
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int res = stack2.pop();
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return res;
    }
}
