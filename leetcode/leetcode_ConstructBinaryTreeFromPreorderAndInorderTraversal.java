package LeetCode;

public class leetcode_ConstructBinaryTreeFromPreorderAndInorderTraversal
{
	/*
	 * 根据前序遍历和中序遍历重构二叉树
	 * construct-binary-tree-from-preorder-and-inorder-traversal
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeCore(preorder,0, preorder.length-1,inorder,0,inorder.length-1);
	}

	private TreeNode buildTreeCore(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight)
	{
		if(preRight<preLeft) return null;
		TreeNode node = new TreeNode(preorder[preLeft]);
		if(preRight==preLeft) return node;
		int index = 0;
		for(int i=inLeft;i<=inRight;i++) {
			if(preorder[preLeft]==inorder[i]) {
				index = i;
				break;
			}
		}
		int len = index - inLeft;
		node.left = buildTreeCore(preorder, preLeft+1, preLeft+len, inorder, inLeft, inLeft+len-1);
        node.right = buildTreeCore(preorder, preLeft+len+1, preRight, inorder, index+1, inRight);
        return node;
     }
}
