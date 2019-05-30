package LeetCode;

import java.util.ArrayList;

public class leetcode_permutationSequence
{
	/**
	 * permutation-sequence
	 * The set[1,2,3,…,n]contains a total of n! unique permutations.
	 * By listing and labeling all of the permutations in order,
	 * We get the following sequence (ie, for n = 3):
	 * "123"
	 * "132"
	 * "213"
	 * "231"
	 * "312"
	 * "321"
	 * Given n and k, return the kth permutation sequence. 第k个排列的序列
	 * Note: Given n will be between 1 and 9 inclusive.假设n在1和9之间
	 */
	
    public String getPermutation(int n, int k) {
        if(n<=0||k<=0)
        	return "";
        String string="";
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<n;i++) {
           res.add(i+1);
        }
        int[] dp=new int[n];
        dp[0] = 1;
        k--;
        for(int i=1;i<n;i++) {
        	dp[i]=dp[i-1]*i;
        }
        for (int i=n; i>=1; i--){
			int j=k/dp[i-1];
			k%=dp[i-1];
			string+=res.get(j);
			res.remove(j);
		}
		return string;
	}

}
