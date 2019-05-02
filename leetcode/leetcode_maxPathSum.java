package LeetCode;

public class leetcode_maxPathSum
{
	/*
	 * binary-tree-maximum-path-sum
	 * Given a binary tree, find the maximum path sum.
	 * The path may start and end at any node in the tree.
	 * For example:Given the below binary tree,Return 6.
       1
      / \
     2   3
	 */
	int max = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
       if(root==null) return 0;
       maxSum(root);
       return max;      
	}
	private int maxSum(TreeNode root)
	{
	   if(root==null) return 0;
	   int left = maxSum(root.left);
	   int  right = maxSum(root.right);
	   int sum = root.val;
	   if(left>0) sum+=left;
	   if(right>0) sum+=right;
	   if (max<sum) max=sum;
	   return Math.max(left, right)>0?Math.max(left, right)+root.val:root.val;
		
	}

}
