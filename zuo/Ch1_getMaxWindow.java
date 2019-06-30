import java.util.LinkedList;

public class Ch1_getMaxWindow
{
	/**
	 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
	 * 返回滑动窗口最大值。
	 * @param nums
	 * @param k
	 * @return
	 */
	 public int[] maxSlidingWindow(int[] nums, int k) {
	        if(nums == null || nums.length<k || k<1){
	            return nums;
	        }
	        int[] res = new int[nums.length-k+1];
	        int index = 0;
	        LinkedList<Integer> qmax = new LinkedList<>();
	        for(int i = 0;i<nums.length;i++){
	            while(!qmax.isEmpty() && nums[qmax.peekLast()]<=nums[i]){
	               qmax.pollLast();
	            }
	            qmax.addLast(i);
	            if(qmax.peekFirst()==i-k){
	                qmax.pollFirst();
	            }
	            if(i>=k-1){
	                res[index++]=nums[qmax.peekFirst()];
	            }
	        }   
	        return res;
	    }
}
