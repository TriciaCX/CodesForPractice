package forOffer;

public class offer51 {
    /**
     * 数组中的逆序对
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
     * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
     * 输入描述:
     * 题目保证输入的数组中没有的相同的数字
     * 数据范围：
     * 	对于%50的数据,size<=10^4
     * 	对于%75的数据,size<=10^5
     * 	对于%100的数据,size<=2*10^5
     */

    //归并排序   归并排序的基本思想是分治，在治的过程中有前后数字的大小对比，此时就是统计逆序对的最佳时机。
    private long cnt = 0;
    private int[] tmp; //在这里声明辅助数组

    public int InversePairs(int [] nums) {
       if(nums==null || nums.length==0) return 0;
       tmp = new int[nums.length];
       mergeSort(nums,0,nums.length-1);
       return (int)(cnt%1000000007);
    }

    private void mergeSort(int[] nums, int low, int high) {
        if(high-low<1)
            return;
        int mid = low+(high-low)/2;
        mergeSort(nums,low,mid);
        mergeSort(nums,mid+1,high);
        merge(nums,low,mid,high);
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int i = low;
        int j = mid+1;
        int k = low;
        while(i<=mid || j<=high){
            if(i>mid)
                tmp[k] = nums[j++];
            else if (j>high)
                tmp[k] = nums[i++];
            else if(nums[i]<=nums[j])
                tmp[k] = nums[i++];
            else {
                tmp[k] = nums[j++];
                this.cnt += mid-i+1; //numd[i]>nums[j] 说明nums[i,..,mid]都大于nums[j]
            }
            k++;
        }
        for(k=low;k<=high;k++){
            nums[k] = tmp[k];
        }
    }
}
