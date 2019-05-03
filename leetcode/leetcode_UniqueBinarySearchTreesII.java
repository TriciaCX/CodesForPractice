package LeetCode;

import java.util.ArrayList;

public class leetcode_UniqueBinarySearchTreesII
{
	/*
	 *unique-binary-search-trees-ii
	 *Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
	 *For example, Given n = 3, your program should return all 5 unique BST's shown below. 
	 */
	public ArrayList<TreeNode> generateTrees(int n) {
		return generateCore(1,n);
	}

	private ArrayList<TreeNode> generateCore(int low, int high)
	{
		ArrayList<TreeNode> res = new ArrayList<>();
		if(low>high) {  
			res.add(null);
			return res;
		}
		for(int i=low;i<=high;++i) {
			ArrayList<TreeNode> leftTreeNodes = generateCore(low, i-1);
			ArrayList<TreeNode> righTreeNodes = generateCore(i+1, high);
			for(int j=0;j<leftTreeNodes.size();++j) {
				for(int k=0;k<righTreeNodes.size();++k) {
					TreeNode rootTreeNode = new TreeNode(i);
					rootTreeNode.left = leftTreeNodes.get(j);
					rootTreeNode.right = righTreeNodes.get(k);
					res.add(rootTreeNode);
				}
			}
		}
		return res;
	}
}
