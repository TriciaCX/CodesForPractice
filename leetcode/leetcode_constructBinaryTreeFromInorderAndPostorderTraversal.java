package LeetCode;

public class leetcode_constructBinaryTreeFromInorderAndPostorderTraversal
{
	/*
	 * 根据中序遍历和后序遍历重构二叉树
	 * construct-binary-tree-from-inorder-and-postorder-traversal
	 */

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder==null||postorder==null||inorder.length!=postorder.length)
			return  null;
		return buildTreeCore(inorder,0,inorder.length-1,postorder,0,postorder.length-1);  
	}
	private TreeNode buildTreeCore(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight)
	{
		if(inLeft>inRight||postLeft>postRight) return null;
		TreeNode node = new TreeNode(postorder[postRight]);
		int index = 0;
		for(int i=0;i<=inRight;i++) {
			if(inorder[i]==postorder[postRight]) {
				index = i;
				break;
			}
		}
		node.left = buildTreeCore(inorder, inLeft,index-1, postorder, postLeft, postRight+index-inLeft-1);
		node.right = buildTreeCore(inorder, index+1, inRight, postorder,postLeft+index-inLeft, postRight-1);
		return node;
	}
}
