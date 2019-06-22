package 算法;

public class MergeSort
{
	public static void mergeSort(int[] arr) {
		if(arr == null || arr.length <2) {
			return;
		}
		sortProcess(arr,0,arr.length-1);
	}

	private static void sortProcess(int[] arr, int L, int R)
	{
		if(L==R) {
			return;
		}
		int mid = L + ((R-L)>>1); //L和R中点的位置（L+R）/2
		/**
		 * mid = L + ((R-L)>>1的补充说明
		 * mid = (L+R)/2 有可能会溢出，不安全
		 * mid = L +(R-L)/2 防溢出
		 * mid = L +(R-L)>>1 右移相当于除以2
		 */
		sortProcess(arr, L, mid);  //T(N/2)
		sortProcess(arr, mid+1, R); //T(N/2)
        merge(arr,L,mid,R); //O(N)
        //T(N) = 2T(N/2)+O(N)
	}

	private static void merge(int[] arr, int L, int mid, int R)
	{
		int[] help = new int[R-L+1];  //辅助数组
		int i = 0;
		int p1 = L;
	    int p2 = mid+1;
	    while(p1<=mid && p2<=R) { //谁小就在help数组里填谁
	    	help[i++] = arr[p1] < arr[p2]?arr[p1]:arr[p2];
	    }
	    //两个必有且只有一个越界
	    while(p1<=mid) {
	    	help[i++] = arr[p1++];
	    }
	    while(p2<=R) {
	    	help[i++] = arr[p2++];
	    }
	    for(i=0;i<help.length;i++) {
	    	arr[L+i] = help[i];
	    }
	}
}
