import java.util.LinkedList;

public class Ch1_GetNum
{
/**
 * p31
 * 给定数组arr和整数Num，共返回有多少个子数组满足如下情况：
 * max(arr[i..j])-min(arr[i..j])<=num
 * max(arr[i..j])表示子数组arr[i..j]中的最大值，min(arr[i..j])表示子数组arr[i..j]中的最小值
 */
	public static void main(String[] args) {
		int[] arr = {1,3,2};
		int num = 1;
		System.out.println(Ch1_GetNum.getNum(arr, num));
	}
	
	
	public static int getNum(int[] arr,int num) {
		if(arr == null || arr.length==0 ||num<0) {
			return 0;
		}
		LinkedList<Integer> qmin = new LinkedList<>(); //动态窗口arr[i..j]最小值
		LinkedList<Integer> qmax = new LinkedList<>(); //动态窗口arr[i..j]最大值
		//数组范围arr[i..j]
		int i=0;
		int j=0;
		//返回结果
		int res=0;
		while(i<arr.length) {
			while(j<arr.length) {
				if(qmin.isEmpty() || qmin.peekLast()!=j) { 
				    while((!qmin.isEmpty()) && arr[qmin.peekLast()]>=arr[j]) {
					    qmin.pollLast();
				    }
				    qmin.add(j);
				    while(!qmax.isEmpty() && arr[qmax.peekLast()]<=arr[j]) {
				    	qmax.pollLast();
				    }
				    qmax.add(j);
				}
				if(arr[qmax.getFirst()]-arr[qmin.getFirst()]>num) {
					break;
				}
				j++;
			}
			
			res +=j-i;
			
			if(qmin.peekFirst()==i) {
				qmin.pollFirst();
			}
			if(qmax.peekFirst()==i) {
				qmax.pollFirst();
			}
			i++;
			
		}
		return res;
	}
}
