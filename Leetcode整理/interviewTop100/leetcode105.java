package interviewTop100;
import struct.TreeNode;

public class leetcode105
{
	/*
	 * 根据一棵树的前序遍历与中序遍历构造二叉树。
注意:
你可以假设树中没有重复的元素。
例如，给出
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：
    3
   / \
  9  20
    /  \
   15   7

	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int preLen = preorder.length;
		int inLen = inorder.length;
		return helper(preorder,0,preLen-1,inorder,0,inLen-1);
	}

	private TreeNode helper(int[] preorder,int preL, int preR,int[] inorder,int inL, int inR) {
		if (preL > preR || inL > inR) return null;	
		
		int rootVal = preorder[preL];
		int l = inL;
		while (l <= inR && inorder[l] != rootVal) l++;
		
		TreeNode root = new TreeNode(rootVal);
		root.left = helper(preorder, preL + 1, preL + l - inL, inorder, inL, l - 1);
		root.right = helper(preorder, preL + l - inL + 1, preR, inorder, l + 1, inR);
		return root;
	}


}
