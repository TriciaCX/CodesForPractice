package interviewTop100;

public class leetcode238
{
 public int[] productExceptSelf(int[] nums) {
  	 int[] res = new int[nums.length];
  	 int k=1;
  	 for(int i=0;i<res.length;i++) {
  		 res[i] = k;
  		 k = k*nums[i]; // 此时数组存储的是除去当前元素左边的元素乘积
  	 }
  	 k=1;
  	 for(int i=res.length-1;i>=0;i--) {
  		res[i] *=k;
  		k*=nums[i];
  	 }
  	 return res;
 }
}
