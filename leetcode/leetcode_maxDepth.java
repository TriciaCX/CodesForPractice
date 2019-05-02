package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_maxDepth
{
	/*
	 * Given a binary tree, find its maximum depth.
	 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
	 */
	
	/*
	 * 解法一：递归
	 */
	public int maxDepth(TreeNode root) {
		if(root==null) return 0;       
		return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
	}

	/*
	 * 解法二： 使用queue进行层序遍历
	 */
	public int maxDepth_1(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		int res = 0;
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
			res++;
		}

		return res;
	}

}
