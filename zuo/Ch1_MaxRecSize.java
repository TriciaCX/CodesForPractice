import java.util.Stack;


/**
 * 给定一个整型矩阵map，其中的值只有0和1两种，求其中全是1的所有矩形区域中，最大的矩形区域为1的数量。
 * step1:根据矩阵得到直方图
 * step2：根据直方图求面积最大的矩形--单调栈
 */
public class Ch1_MaxRecSize
{
	public static void main (String[] agrs)
	{
		int[][] map = {{1,0,1,1},{1,1,1,1},{1,1,1,0}};
		System.out.println(Ch1_MaxRecSize.maxRecSize(map));
	}
	
    public static int maxRecSize(int[][] map) {
    	if(map == null || map.length == 0 ||map[0].length == 0) {
    		return 0;
    	}
    	int maxArea = 0;
    	int[] height = new int[map[0].length];
    	for(int i=0;i<map.length;i++) {
    		for(int j=0;j<map[0].length;j++) { //得到直方图height[j] 
    			height[j] = map[i][j]==0?0:height[j]+1;
    		}
    		maxArea = Math.max(maxRecFromBottom(height), maxArea);
    	}
    	return maxArea;
    }

	private static int maxRecFromBottom(int[] height)
	{
		if(height == null || height.length ==0)
			return 0;
		int maxArea =0;
		Stack<Integer> stack = new Stack<>();
		for(int i = 0;i<height.length;i++) {
			while(!stack.isEmpty() && height[i]<=height[stack.peek()]) {
				int j = stack.pop();
				int k = stack.isEmpty()?-1:stack.peek();
				int curArea = (i-k-1)*height[j];
				maxArea = Math.max(curArea, maxArea);
			}
			stack.push(i);
		}
		while(!stack.isEmpty()) {
			int j = stack.pop();
			int k = stack.isEmpty()?-1:stack.peek();
			int curArea = (height.length -k -1)*height[j];
			maxArea = Math.max(curArea, maxArea);
		}
		return maxArea;
	}
}
