import java.util.Stack;

public class Ch1_SortStackByStack
{
	
   /**
    * zuo0105 用一个栈实现另一个栈的排序
    * @param stack
    */
   public void sortStackByStack(Stack<Integer> stack) {
	   Stack<Integer> help = new Stack<>();
	   while(!stack.isEmpty()) {
		   int cur = stack.pop();
		   while(!help.isEmpty() && help.peek()<cur) {
			   stack.push(help.pop());
		   }
		   help.push(cur);		   
	   }
	   while(!help.isEmpty()) {
		   stack.push(help.pop());
	   }
   }
}
