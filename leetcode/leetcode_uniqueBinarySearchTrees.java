package LeetCode;

public class leetcode_uniqueBinarySearchTrees
{
	/*
	 * unique-binary-search-trees
	 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
	 * For example,Given n = 3, there are a total of 5 unique BST's.
	 */
	
	/*
	 *----- 解题思路-----
	 * 叉搜索树有个性质，就是左边的数都比根小，右边的数都比根大。
	 * 另外，题目说明二叉树的节点是从1到n，所以我们能确定如果根为k，则根左边的数是1到k-1，根右边的数是k+1到n。
	 * 还有一点技巧是，对于通过一个根来说，唯一二叉树的数量是其左子树的数量乘以右子树的数量，这是简单的乘法原理。
	 * 并且，左右子树的形态数量是跟具体的数无关的，只跟这个树里有多少节点有关。
	 * 而根可以选择从1到n的任意的数，唯一二叉树的总数，就是根为1到n的树相加。
	 * 所以该问题化简为以k为根，其唯一左子树和右子树各有多少，这就是个动态规划的问题了。
	 * 我们建立一个数组dp[i]，代表节点数为i的唯一子树有多少个。显然dp[0]=dp[1]=1。
	 */
	//其实是卡兰特数的思想
    public int numTrees(int n) {
        if(n<=0) return 0;
        int []dp = new int[n+1];
        dp[0] = 1; //产生的是null的树
        dp[1] = 1;
        for(int i=2;i<n+1;i++) {
           for(int j=0;j<i;j++) {
        	   dp[i] +=dp[j]*dp[i-j-1];  
           }
        }
        return dp[n];    		        
    }
}
