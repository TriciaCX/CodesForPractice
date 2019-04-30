package LeetCode;

import java.util.Stack;

public class leetcode_maximalRectangle
{
	/*
	 * 84. Largest Rectangle in Histogram
	 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
	 * find the area of largest rectangle in the histogram.
	 */
	
	/*
	 * 1) Create an empty stack.
	 * 2) Start from first bar, and do following for every bar ‘hist[i]’ where ‘i’ varies from 0 to n-1. 
	 * ……a) If stack is empty or hist[i] is higher than the bar at top of stack, then push ‘i’ to stack.
	 * ……b) If this bar is smaller than the top of stack, then keep removing the top of stack while top of the stack is greater. 
	        Let the removed bar be hist[tp]. Calculate area of rectangle with hist[tp] as smallest bar.
	        For hist[tp], the ‘left index’ is previous (previous to tp) item in stack and ‘right index’ is ‘i’ (current index).
	 * 3) If the stack is not empty, then one by one remove all bars from stack and do step 2.b for every removed bar.

Following is implementation of the above algorithm.
	 */
	 public int largestRectangleArea(int[] height) {
	        int len = height.length;
	        Stack<Integer> s = new Stack<Integer>();
	        int maxArea = 0;
	        for(int i = 0; i <= len; i++){
	            int h = (i == len ? 0 : height[i]);
	            if(s.isEmpty() || h >= height[s.peek()]){
	                s.push(i);
	            }else{
	                int tp = s.pop();
	                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
	                i--;
	            }
	        }
	        return maxArea;
	    }


	/*
	  * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
	  */
	 //解法基于84.把每一行看成求直方图中最大矩形面积问题

	 public int maximalRectangle(char[][] matrix) {
		 if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			 return 0;
		 int m = matrix.length, n = matrix[0].length; //m为行，n为列
		 int max = 0;
		 int[] h = new int[n];
		 Stack<Integer> stack = new Stack<Integer>();
		 stack.push(-1);		 
		 for (int i = 0; i < m; i++) {
			 //求当前第i行往上连续1的个数，不连续就置为0，方便下一行统计
			 //j表示列号，即直方图的连续序号
			 for (int j = 0; j < n; j++) {			
				 if (matrix[i][j] == '1')
					 h[j] += 1;
				 else
					 h[j] = 0;
			 }
			 
			 for (int j = 0; j < n; j++) {
			//这里主要思路是遇到上升序列就入栈，遇到下降序列就计算当前前一个直方图(即当前栈顶序号)
            //到所有依次出栈（即降序且大于j指向直方图的高度）直方图的距离，然后乘以出栈直方图的高度，
            //即为当前的面积(不一定最大),剩下的序列依然是升序的，迭代下去
				 while (stack.peek() != -1 && h[j] < h[stack.peek()]) {
					 int top = stack.pop();
					 max = Math.max(max, (j - 1 - stack.peek()) * h[top]);
				 }
				 stack.push(j);
			 }
			//计算栈中最后一个上升序列的面积（方法同上）
			 while (stack.peek() != -1) {
				 int top = stack.pop();
				 max = Math.max(max, (n - 1 - stack.peek()) * h[top]);
			 }
		 }
		 return max;
	 }
}
