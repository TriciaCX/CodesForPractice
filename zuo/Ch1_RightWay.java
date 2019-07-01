
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Ch1_RightWay
{
/**
 * 给定一个不含有重复值的数组arr，找到每一个i位置左边和右边离i位置最近且值比arr[i]小的位置。返回所有位置相应的信息。
 * -1表示不存在相应的值
 */
	
	//解法一 O（N*N）
	public int[][] rightWayI(int[] arr){
		int[][] res = new int[arr.length][2];
		for(int i=0;i<arr.length;i++) {
			int leftLessIndex = -1;
			int rightLessIndex = -1;
			int cur = i-1;
			while(cur>=0) {
				if(arr[cur]<arr[i]) { 
					leftLessIndex = cur;
					break;
				}
				cur--;
			}
			cur = i+1;
			while(cur<arr.length) {
				if(arr[cur]<arr[i]) {
					rightLessIndex = cur;
					break;
				}
				cur++;
			}
			res[i][0] = leftLessIndex;
			res[i][1] = rightLessIndex;
		}
		return res;
	}
	
	
	/**
	 * 2、单调栈求解 O(N)
	 * 无重复元素
	 * @param arr
	 * @return
	 */
	public int[][] rightWayII(int[] arr){
		int[][] res = new int[arr.length][2];
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<arr.length;i++) {
			while(!stack.isEmpty() && arr[stack.peek()]>arr[i]) {
				int popIndex = stack.pop();
				int leftLessIndex = stack.isEmpty()?-1:stack.peek();
				res[popIndex][0] = leftLessIndex;
				res[popIndex][1] = i;
			}
			stack.push(i);
			while(!stack.isEmpty()) {
				int popIndex = stack.pop();
			    int leftLessIndex = stack.isEmpty()?-1:stack.peek();
			    res[popIndex][0] = leftLessIndex;
			    res[popIndex][1] = -1;
			}
		}
		return res;
	}
	
	
	/**
	 * 3、单调栈求求解（考虑重复元素）
	 */
	public int[][] rightWayIII(int[] arr){
		int[][] res = new int[arr.length][2];
		Stack<List<Integer>> stack = new Stack<>();
		for(int i=0;i<arr.length;i++) {
			while(!stack.isEmpty() && arr[stack.peek().get(0)]>arr[i]) {
				List<Integer> popIs = stack.pop();
				//取位于下面位置的列表中，最晚加入的那个
				int leftLessIndex = stack.isEmpty()?-1:stack.peek().get(stack.peek().size()-1);
				for(Integer popi:popIs) {
					res[popi][0] = leftLessIndex;
					res[popi][1] = i;
				}
			}
			if(!stack.isEmpty() && arr[stack.peek().get(0)]==arr[i]) {
				stack.peek().add(Integer.valueOf(i));
			}else {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(i);
				stack.push(list);
			}
		}
		
		while(!stack.isEmpty()) {
			List<Integer> popIs = stack.pop();
			//取位于下面位置的列表中，最晚加入的那个
		    int leftLessIndex = stack.isEmpty()?-1:stack.peek().get(stack.peek().size()-1);
			for(Integer popi:popIs) {
				res[popi][0] = leftLessIndex;
				res[popi][1] = -1;
			}
		}
		return res;
	}
}
