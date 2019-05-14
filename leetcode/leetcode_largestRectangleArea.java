package LeetCode;

import java.util.Stack;

public class leetcode_largestRectangleArea
{
	/*
	 * largest-rectangle-in-histogram
	 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
	 * find the area of largest rectangle in the histogram.
	 */
	
	/*
	 * 用堆栈计算每一块板能延伸到的左右边界
	 * 对每一块板
	 * 堆栈顶矮，这一块左边界确定，入栈
	 *  堆栈顶高，堆栈顶右边界确定，出栈，计算面积
	 *  入栈时左边界确定
	 *   出栈时右边界确定
	 *   堆栈里元素是递增的
	 *   本质：中间的短板没有用！
	 *   复杂度 O(n)
	 */
	
	/*
	 * 利用栈来保持一个递增的序列，比如输入1 2 3 4 5，就将其入内.
	 * 如果此时再出现一个4，则需要将5弹出，并计算的当前的最大面积，1*5 = 5，然后将4插入其中;
	 * 如果后续又出现一个3，则4弹栈，计算当前的面积1*4 = 4，而此时前面还是一个4，将前面的4弹栈，计算面积，4*3 = 12，
	 * 因为这个4之后有5，4两个值，所以，最大面积应该是12，
	 * 这里特别注意，每一个数如果进接着它后面的数弹出栈了，说明，这个数一定大于当前栈顶元素。
	 *  基于以上的思路，其实栈中存放数组下标更为合适，当出现栈顶元素比当前元素小时，直接将当前元素入栈;
	 *  如果出现栈顶元素大于当前元素，则需要将栈顶元素弹出，计算栈顶元素与当前元素之间的下标差距，求出对应的面积，
	 *  而后与全局最优解的变量对比，求最大即可。
	 */
	public int largestRectangleArea(int[] height) {
       int len = height.length;
       int res = 0;
       Stack<Integer> stack = new Stack<>();
       for(int i=0;i<len;i++) {
    	   while(!stack.isEmpty()&&height[stack.peek()]>=height[i]) {
    		   int h = height[stack.pop()];
    		   res = Math.max(res, (i-1-(stack.isEmpty()?(-1):stack.peek()))*h);
    	   }
    	   stack.push(i);
       }
       while(!stack.isEmpty()) {
    	   int h = height[stack.pop()];
    	   res = Math.max(res, (len-1-(stack.isEmpty()?-1:stack.peek()))*h);
       }
       return res;
	}
}
