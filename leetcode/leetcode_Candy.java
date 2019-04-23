package LeetCode;

public class leetcode_Candy
{
	public int candy(int[] ratings) {
		if(ratings==null||ratings.length<=0) return 0;
		int res = 0;
		int len = ratings.length;
		int[] nums = new int[len];

		for(int i=0;i<len;i++) {
			nums[i] = 1;
		}

		if(len==1) return 1;

		for(int i=1;i<len;i++) {
			if(ratings[i]>ratings[i-1]) {
				nums[i]=nums[i-1]+1;
			}
		}

		for(int i=len-1;i>0;i--) {
			if(ratings[i]<ratings[i-1] && nums[i]>=nums[i-1]) {
				nums[i-1]=nums[i]+1;
			}
		}

		for(int i=0;i<len;i++) {
			res=res+nums[i];
		}

		return res;
	}
}
