package 算法;

public class ThreeSumSlow implements ThreeSum
{
/*
 * 该算法的内循环为 if (nums[i] + nums[j] + nums[k] == 0) 语句，
 * 总共执行的次数为 N(N-1)(N-2) = N3/6-N2/2+N/3，因此它的近似执行次数为 ~N3/6，增长数量级为 O(N3)。
 */
	@Override
	public int count(int[] nums)
	{
	    int N=nums.length;
	    int cnt=0;
	    for(int i=0;i<N;i++) {
	    	for(int j=i+1;j<N;j++) {
	    		for(int k=j+1;k<N;k++) {
	    			if(nums[i]+nums[j]+nums[k]==0)
	    				cnt++;
	    		}
	    	}
	    }
	    return cnt;
	}

}
