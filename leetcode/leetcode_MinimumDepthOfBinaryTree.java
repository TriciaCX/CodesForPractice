package LeetCode;

import java.util.LinkedList;

public class leetcode_MinimumDepthOfBinaryTree
{
	/*
	 * minimum-depth-of-binary-tree
	 * Given a binary tree, find its minimum depth.
	 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
	 */

	/**
	 * 题目名称：minimum-depth-of-binary-tree
	 * 题目描述：Given a binary tree, find its minimum depth.
	 * The minimum depth is the number of nodes along the shortest path
	 * from the root node down to the nearest leaf node.
	 */

	/**
	 * 思路1：
	 * 深度优先遍历（DFS）
	 * 如果当前节点是空，则最小深度为 0，返回
	 * 效率低
	 */
	public int run(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = run(root.left);
		int right = run(root.right);
		if (left == 0 || right == 0) {
			return left + right + 1;
		}
		return Math.min(left, right) + 1;
	}

	/**
	 * 思路2：
	 * 广度优先遍历（BFS）
	 * 找到第一个叶子结点就可以停止遍历
	 * 效率高
	 */
	public int run1(TreeNode root) {
		if (root == null) return 0;
		
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		LinkedList<TreeNode> layerList = new LinkedList<TreeNode>();
		queue.addFirst(root);
		int start = 0;
		int end = 1;
		int level = 1;
		while (!queue.isEmpty()) {
			TreeNode temp = queue.removeLast();
			start++;
			layerList.addFirst(temp);
			if (temp.left == null && temp.right == null) {
				return level;
			}
			if (temp.left != null) {
				queue.addFirst(temp.left);
			}
			if (temp.right != null) {
				queue.addFirst(temp.right);
			}
			if (start == end) {
				level++;
				start = 0;
				end = queue.size();
				layerList = new LinkedList<TreeNode>();
			}
		}

		return level;
	}
}
