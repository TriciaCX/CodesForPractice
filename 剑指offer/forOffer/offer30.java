package forOffer;

import java.util.Stack;

public class offer30 {
    /**
     * 包含min函数的栈
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的 min 函数。
     */

    private Stack<Integer> num = new Stack<>();
    private Stack<Integer> min = new Stack<>();
    public void push(int node) {
        num.push(node);
        if(min.isEmpty()){
            min.push(node);
        }else{
            if(min.peek()<=node){
                min.push(min.peek());
            }else{
                min.push(node);
            }
        }
    }

    public void pop() {
       min.pop();
       num.pop();
    }

    public int top() {
        return num.peek();
    }

    public int min() {
       if(min.isEmpty())
           return -1;
       return min.peek();
    }
}
