package 算法;

public class SelectionSort
{
    public static void SelectionSort(int[] arr) {
    	if(arr == null || arr.length<2)
    		return;
    	for(int i=0;i<arr.length;i++) {
    		int minIndex = i;
    		for(int j=i+1;j<arr.length;j++) {
    			minIndex=arr[j]<arr[minIndex]?j:minIndex;
    		}
    		swap(arr,i,minIndex);
    	}
    }

	private static void swap(int[] arr, int i, int minIndex)
	{
		int temp = arr[i];
		arr[i]=arr[minIndex];
		arr[minIndex]=temp;
	}
}
