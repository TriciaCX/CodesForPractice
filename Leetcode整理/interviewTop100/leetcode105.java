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
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps > pe) {
            return null;
        }
        // 前序遍历第一个节点为根节点
        int rootVal = preorder[ps];
        TreeNode root = new TreeNode(rootVal);
        // 确定根节点在中序遍历中的位置
        int im = is;
        while (im < ie && inorder[im] != rootVal) {
            im++;
        }
        // 根据根节点在中序遍历中的位置得到左右子树的前序遍历和中序遍历序列
        root.left = buildTree(preorder, ps + 1, ps + im - is, inorder, is, im - 1);
        root.right = buildTree(preorder, ps + im - is + 1, pe, inorder, im + 1, ie);
        return root;
    }

}
