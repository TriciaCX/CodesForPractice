package interviewTop100;

import java.util.Stack;

public class leetcode42
{
	/**
	 * 接雨水
	 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
	 */
	
	/**
	 * 栈
	 * 当前高度小于等于栈顶高度，入栈，指针后移。
	 * 当前高度大于栈顶高度，出栈，计算出当前墙和栈顶的墙之间水的多少，然后计算当前的高度和新栈的高度的关系，重复第 2 步。
	 * 直到当前墙的高度不大于栈顶高度或者栈空，然后把当前墙入栈，指针后移。
	 */
	
	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(height));
	}
	 
	public static int trap(int[] height) {
		if(height==null || height.length<=2)
			return 0;
		int sum =0;
		Stack<Integer> stack = new Stack<Integer>();
		int cur = 0;
		while(cur<height.length) {
			//当前高度大于栈顶的高度，说明之前的积水到这里停下，我们可以计算下有多少积水了。计算完，就把当前的墙继续入栈，作为新的积水的墙。
			while(!stack.isEmpty() && height[cur]>height[stack.peek()]) {
				int h = height[stack.pop()]; //出栈的元素对应的高度
				if(stack.isEmpty()) break;
				int distance = cur - stack.peek()-1;   //因为这里本质上是横着算面积的，可以理解为在y轴方向看
				int min = Math.min(height[stack.peek()], height[cur]);  //栈顶元素的高度和当前遍历的高度，取较小的一个
				sum += distance*(min-h);
			}
			//当前高度小于栈顶的墙高度，说明这里会有积水，我们将墙的高度的下标入栈
			stack.push(cur);
			cur++;       
		}       
		return sum;
	}
}
