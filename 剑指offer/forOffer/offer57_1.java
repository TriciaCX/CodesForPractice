package forOffer;

import java.util.ArrayList;
import java.util.Arrays;

public class offer57_1 {
    /**
     * 和为S的两个数字
     * 输入一个递增排序的数组和一个数字 S，在数组中查找两个数，使得他们的和正好是 S。如果有多对数字的和等于 S，输出两个数的乘积最小的。
     */
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        int low = 0;
        int high = array.length-1;
        while (low<high){
           int tmp = array[low]+array[high];
           if(tmp==sum){
               return new ArrayList<>(Arrays.asList(array[low],array[high]));
           }else if(tmp>sum){
               high--;
           }else{
               low++;
           }
        }
        return new ArrayList<>();
    }
}
