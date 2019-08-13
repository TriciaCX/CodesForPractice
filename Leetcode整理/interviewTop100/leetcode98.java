package interviewTop100;

import java.util.ArrayList;

import struct.TreeNode;

public class leetcode98
{
/**
 * 验证二叉搜索树
 * 定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
示例 1:

输入:
    2
   / \
  1   3
输出: true
示例 2:

输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 

 */
	//因为二叉搜索树中序遍历是递增的,所以我们可以中序遍历判断前一数是否小于后一个数.
	/**
	 *  这个解法是基于二叉树的中序遍历
 2 定义一个变量用于存储上一遍历结点的值
 3 递归遍历二叉树
 4 如果左子树返回true，对比根节点与缓存变量的值
 5 如果2.4的对比成立，则将根节点的值赋给缓存变量
 6 递归遍历右子树
	 */
	double last =-Double.MAX_VALUE;
	public boolean isValidBST(TreeNode root) {
		if(root==null)
			return true;
		if(isValidBST(root.left)) {
			if(last<root.val) {
				last = root.val;
				return isValidBST(root.right);
			}
		}
		return false;
	}
	
}
