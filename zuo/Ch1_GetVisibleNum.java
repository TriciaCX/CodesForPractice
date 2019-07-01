import java.util.Stack;

public class Ch1_GetVisibleNum
{
    /**
     * p33 一个不含有负数的数组代表一圈环形山，每个位置的值代表山的高度。山峰A和山峰B能相互看见的条件为：
     * 1、如果A和B是同一座山，认为不能相互看见
     * 2、如果A和B是不同的山，并且在环中相邻， 
     * 3、如果A和B是不相邻的山，则两山中较矮的山，从顺时针或逆时针方向有一个方向没有比其更高的山，就能互相看见
     */
	public static void main(String[] args)
	{
		int[] arr = {5,4,3,5,4,2,4,4,5,3,2};
		Ch1_GetVisibleNum sl = new Ch1_GetVisibleNum();
		System.out.println(sl.getVisibleNumII(arr));

	}
    
	/*
	 * 原问题：不考虑重复值，复杂度为O(1)
	 * 环形结构中有i座山峰时，可见山峰对的数量为2*i-3（i>2）
	 */
	public int getVisibleNumI(int[] arr) {
		if(arr == null||arr.length<=1) {
			return 0;
		}
		return 2*arr.length-3;
	}
	
	
	
	/**
	 * 进阶问题：考虑重复值
	 */
	public class Record{
		public int value;
		public int times;
		
		public Record(int value) {
			this.value = value;
			this.times = 1;
		}
	}
	
	public int getVisibleNumII(int[] arr) {
		if(arr == null || arr.length<2) {
			return 0;
		}
		int size =  arr.length;
		int maxIndex = 0;
		//先在环中找一个最大值的位置，哪一个都行
		for(int i=0;i<size;i++) {
			maxIndex = arr[maxIndex]<arr[i]?i:maxIndex;
		}
		Stack<Record> stack = new Stack<>();
		//先把最大值放入stack中
		stack.push(new Record(arr[maxIndex]));
		//从最大值位置的下一个位置开始沿着逆时针方向遍历
		int index = nextIndex(maxIndex,size);
		//用小找大的方式统计所有氪金山峰对
		int res = 0;
		//遍历阶段开始，当index再次回到maxIndex的时候，说明已经转了一圈，遍历阶段结束
		while(index!=maxIndex) {
			//当前数字arr[index]要进栈，判断会不会破坏第一位的数字从顶到底一次变大
			//如果破坏了，就依次弹出栈顶记录，并计算山峰对数量
			while(stack.peek().value<arr[index]) {
				int k = stack.pop().times; //这个数有几个
				//弹出记录为（X,K），如果K==1，产生2对
				//如果K>1，产生2*K+C(2,k)对
				res+=getInternalSum(k)+2*k;
			}
			//当前数字arr[index]要进入栈了，如果和当前栈顶数字一样就合并，不一样就把记录(arr[index],1)压入栈中
			if(stack.peek().value == arr[index]) {
				stack.peek().times++;
			}else {
				stack.push(new Record(arr[index]));
			}
			index = nextIndex(index,size);
		}
		//清算阶段开始
		//清算阶段的第一小阶段
		while(stack.size()>2) {
			int times = stack.pop().times;
			res += getInternalSum(times)+2*times;
		}
		//清算阶段的第二小阶段
		if(stack.size()==2) {
			int times = stack.pop().times;
			res += getInternalSum(times)+(stack.peek().times==1?times:2*times);
		}
		//清算阶段的第三小阶段
		res+=getInternalSum(stack.pop().times);
		
		return res;
	}

	//计算C（2，k）
	private int getInternalSum(int k)
	{
        return k==1?0:(k*(k-1)/2);
	}

	//环形数组中当前位置为i，数组长度为size，返回i的下一个位置
	private int nextIndex(int i, int size)
	{
		return i<(size-1)?(i+1):0;
	}
}
