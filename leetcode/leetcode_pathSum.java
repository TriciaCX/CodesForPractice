package LeetCode;

import java.util.ArrayList;

public class leetcode_pathSum
{
	/*
	 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
	 */
	ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<Integer> list = new ArrayList<>();
		pathsCore(root,sum,list);
		return res;
	}
	private void pathsCore(TreeNode root, int sum, ArrayList<Integer> list)
	{
		if(root==null) return;
		if(root.left==null && root.right==null && sum-root.val==0) {
			list.add(root.val);
			res.add(new ArrayList<Integer>(list));
			list.remove(list.size()-1);
			return;
		}
		list.add(root.val);
		pathsCore(root.left, sum-root.val, list);
		pathsCore(root.right, sum-root.val, list);
		list.remove(list.size()-1);		
	}
}
