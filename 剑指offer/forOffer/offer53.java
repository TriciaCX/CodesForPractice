package forOffer;

import static java.util.Arrays.binarySearch;

public class offer53 {
    /**
     * 数字在排序数组中出现的次数
     */
    public static void main(String[] args) {
        int[] array = {1,3,3,4,4,4,4,8,8,9,10};
        int k = 4;
        offer53 o =new offer53();
        System.out.println(GetNumberOfK(array,k));
    }


    //原始的二分
    public static int GetNumberOfK(int [] array , int k) {
       int low = 0;
       int high  = array.length;
       while(low<high){
           int mid = low + (high-low)/2;
           if(array[mid]<k){
               low = mid+1;
           }else  if(array[mid]>k){
               high = mid;
           }else{
               //找到了k
               int left = mid;
               int right = mid;
               while(left>=0 && array[left]==k){
                   left--;
               }
               while(right<=array.length-1 && array[right]==k){
                   right++;
               }
               return right-left-1;
           }
       }
       return 0;
    }

    //改进的二分
    public int GetNumberOfKII(int[] nums, int K) {
        int first = binarySearch(nums, K);
        int last = binarySearch(nums, K + 1);
        return (first == nums.length || nums[first] != K) ? 0 : last - first;
    }

    private int binarySearch(int[] nums, int K) {
        int l = 0, h = nums.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= K)
                h = m;
            else
                l = m + 1;
        }
        return l;
    }
}
