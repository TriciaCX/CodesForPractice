package forOffer;

public class offer11 {
    /**
     * 旋转数组中最小的数字
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     */


    /**
     * 此时问题的关键在于确定对半分得到的两个数组哪一个是旋转数组，哪一个是非递减数组。我们很容易知道非递减数组的第一个元素一定小于等于最后一个元素。
     * 通过修改二分查找算法进行求解（l 代表 low，m 代表 mid，h 代表 high）：
     * 当 nums[m] <= nums[h] 时，表示 [m, h] 区间内的数组是非递减数组，[l, m] 区间内的数组是旋转数组，此时令 h = m；
     * 否则 [m + 1, h] 区间内的数组是旋转数组，令 l = m + 1。
     */

    //如果数组元素允许重复，会出现一个特殊的情况：nums[l] == nums[m] == nums[h]，此时无法确定解在哪个区间，
    // 需要切换到顺序查找。例如对于数组 {1,1,1,0,1}，l、m 和 h 指向的数都为 1，此时无法知道最小数字 0 在哪个区间。
    public int minNumberInRotateArray(int [] array) {
         if(array==null || array.length==0)
             return  0;
         int p1 = 0,mid = 0;   //p1前一个递增子序列
         int p2 = array.length-1;
         while(p1<p2){
            mid = p1+(p2-p1)/2;
            if(array[p1] == array[mid] && array[mid]==array[p2]){
                return  minNumber(array,p1,p2);
            }else if(array[mid]<=array[p2]){
                p2 = mid;
            }else{
                p1 = mid+1;
            }
         }
         return  array[p1];
    }

    private int minNumber(int[] array, int p1, int p2) {
        for(int i=p1;i<p2;i++){
            if(array[i]>array[i+1])
                return  array[i+1];
        }
        return array[p1];
    }
}
