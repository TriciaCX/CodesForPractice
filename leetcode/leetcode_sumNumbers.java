package LeetCode;

public class leetcode_sumNumbers
{
	/*
	 * sum-root-to-leaf-numbers
	 * Given a binary tree containing digits from0-9only, each root-to-leaf path could represent a number.
	 * An example is the root-to-leaf path1->2->3which represents the number123.
	 * Find the total sum of all root-to-leaf numbers.
	 */
	public int sumNumbers(TreeNode root) {
      int sum = 0;
      if(root==null) return sum;
      return preorderSum(root,sum);
	}

	private int preorderSum(TreeNode root, int sum)
	{
		if(root==null) return 0;
		sum = sum*10+root.val;
		if(root.left==null && root.right==null) return sum;		
		return preorderSum(root.left, sum)+preorderSum(root.right, sum);
	}
}
