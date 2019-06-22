package 算法;

public class ShellSort
{
    public static void main(String []args) {
    	int[] nums= {0,9,1,5,8,3,7,4,6,2};
    	int i,j;
    	int increment=nums.length;
    	do {
    		increment = increment/3+1; /*增量序列*/
    		for(i=increment+1;i<=nums.length;i++) {
    			if(nums[i]>nums[i-increment]) {
    				
    			}
    		}
    	}
    }
}
