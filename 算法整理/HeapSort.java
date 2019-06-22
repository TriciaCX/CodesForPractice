package 算法;


/**
 * heapSort   堆排序
 */
public class HeapSort
{
	public static void main(String [] args) {
		HeapSort sl = new HeapSort();
		int[] arr = {5,6,1,2,4,5};
		sl.heapSort(arr);
		for (int i : arr)
		{
			System.out.print(i+" ");
		}
	}
	
	public static void heapSort(int[] arr) {
		if(arr==null||arr.length<2)
			return;
		for(int i=0;i<arr.length;i++) {
			heapInsert(arr,i);  //0~i
		}
		int heapSize = arr.length;
		swap(arr,0,--heapSize);
		while(heapSize>0) {
			heapify(arr, 0, heapSize);
			swap(arr, 0, --heapSize);
		}
	}
	

	private static void heapInsert(int[] arr, int index)
	{
		while(arr[index]>arr[(index-1)/2]) { //如果父节点的值大，交换位置
			swap(arr, index, (index-1)/2);	
			index = (index-1)/2;
		}
	}

	/**
	 *堆调整
	 * 一个值变小（因为堆顶的数和最后一个数交换位置了），往下沉的过程
	 */
	private static void heapify(int[] arr, int index, int heapSize)
	{
		//0~heapSize-1的范围已经形成了堆，再往外称为越界
		int left = index*2+1;  //左孩子
		while(left<heapSize) {  //左孩子存在
			int largest = left +1 < heapSize && arr[left+1]>arr[left] ? left+1: left;
					//右孩子存在且右孩子的值大于左孩子的值，右孩子作为largest否则左孩子作为largest					
			largest = arr[largest] > arr[index]? largest:index; 
			if(largest==index)   //根节点仍是最大值，不用往下沉了
				break;
			swap(arr, largest, index); //largest!=index
			index = largest;
			left = index*2+1; //又去和它的左孩子比较了
		}
	}

	//节点交换
	private static void swap(int[] arr, int i, int j)
	{
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
