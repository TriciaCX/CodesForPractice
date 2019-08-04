package interviewTop100;


import java.util.Random;

public class leetcode384
{
/**
 * 打乱一个没有重复元素的数组。

示例:
// 以数字集合 1, 2 和 3 初始化数组。
int[] nums = {1,2,3};
Solution solution = new Solution(nums);
// 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
solution.shuffle();
// 重设数组到它的初始状态[1,2,3]。
solution.reset();
// 随机返回数组[1,2,3]打乱后的结果。
solution.shuffle();
 */
	
	//暴力解法
	//假设我们把每个数都放在一个 ”帽子“ 里面，然后我们从帽子里面把它们一个个摸出来，摸出来的数按顺序放入数组，这个数组正好就是我们要的洗牌后的数组。
//	class Solution {
//
//		private int[] array;
//		private int[] original;
//		private Random random = new Random();
//		
//		private List<Integer> getArrayCopy(){
//			List<Integer> asList = new ArrayList<>();
//			for(int i=0;i<array.length;i++) {
//				asList.add(array[i]);
//			}
//			return asList;
//		}
//		
//		public Solution(int[] nums) {
//            array = nums;
//            original = nums.clone();
//		}
//
//		/** Resets leetcodethe array to its original configuration and return it. */
//		public int[] reset() {
//            array = original;
//            original = original.clone();
//            return array;
//		}
//
//		/** 随机返回数组打乱后的结果 */
//		public int[] shuffle() {
//			List<Integer> aux = getArrayCopy();
//			
//			for(int i=0;i<array.length;i++) {
//				int removeIdx = random.nextInt(aux.size());
//				array[i] = aux.get(removeIdx);
//				aux.remove(removeIdx);
//			}
//			return array;
//		}
//	}

	/**
	 * Your Solution object will be instantiated and called as such:
	 * Solution obj = new Solution(nums);
	 * int[] param_1 = obj.reset();
	 * int[] param_2 = obj.shuffle();
	 */
	
	//洗牌算法
	/**
	 * 思路:我们可以用一个简单的技巧来降低之前算法的时间复杂度和空间复杂度，那就是让数组中的元素互相交换，这样就可以避免掉每次迭代中用于修改列表的时间了。
	 * 算法:Fisher-Yates 洗牌算法跟暴力算法很像。
	 * 在每次迭代中，生成一个范围在当前下标到数组末尾元素下标之间的随机整数。
	 * 接下来，将当前元素和随机选出的下标所指的元素互相交换 - 这一步模拟了每次从 “帽子” 里面摸一个元素的过程，
	 * 其中选取下标范围的依据在于每个被摸出的元素都不可能再被摸出来了。
	 * 此外还有一个需要注意的细节，当前元素是可以和它本身互相交换的 - 否则生成最后的排列组合的概率就不对了。
	 */
	class Solution {

		private int[] array;
		private int[] original;
		Random rand = new Random();
		
		private int randRange(int min,int max) {
			return rand.nextInt(max-min)+min;
		}
		
	    public Solution(int[] nums) {
	        array = nums;
	        original = nums.clone();
	    }
	    
	    /** Resets the array to its original configuration and return it. */
	    public int[] reset() {
	        array = original;
	        original = original.clone();
	        return original;
	    }
	    
	    /** Returns a random shuffling of the array. */
	    public int[] shuffle() {
	        for(int i=0;i<array.length;i++) {
	        	swap(i,randRange(i, array.length));
	        }
	        return array;
	    }

		private void swap(int i, int j){
			int tmp = array[i];
			array[i] = array[j];
			array[j] = tmp;
		}
	}

	/**
	 * Your Solution object will be instantiated and called as such:
	 * Solution obj = new Solution(nums);
	 * int[] param_1 = obj.reset();
	 * int[] param_2 = obj.shuffle();
	 */
}
