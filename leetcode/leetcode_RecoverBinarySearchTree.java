package LeetCode;

public class leetcode_RecoverBinarySearchTree
{
	/*
	 * recover-binary-search-tree 重构二叉搜索树
	 * Two elements of a binary search tree (BST) are swapped by mistake.
	 * Recover the tree without changing its structure.
	 * Note: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
	 */
	
	/*
	 * 中序遍历二叉树，出现的节点的值会升序排序.
	 * 如果有两个节点位置错了，那肯定会出现降序。
	 * 设置一个pre节点指针，记录当前节点中序遍历时的前节点，
	 * 如果当前节点小于pre节点的值，说明需要调整次序。
	 * 如果在中序遍历时节点值出现了两次降序，第一个错误的节点为第一次降序时较大的节点，第二个错误节点为第二次降序时较小的节点。比如，原来的搜索二叉树在中序遍历的节点值依次为{1,2,3,4,5}，如果因为两个节点位置错了而出现{1,5,3,4,2}，
	 *  第一次降序为5->3，所以第一个错误节点为5，第二次降序为4->2,所以第二个错误节点为2，将5和2换过来就可以恢复。
	 */
	TreeNode pre,p,q;
	public void recoverTree(TreeNode root) { 
		pre = p = q = null; 
		dfs(root); 
		//找到节点之后做值交换
		int tmp = p.val; 
		p.val = q.val; 
		q.val = tmp; 
	} 

	//中序遍历
	public void dfs(TreeNode root) { 
		if (root == null) { 
			return; 
		} 
		dfs(root.left); 
		if (pre != null && pre.val > root.val) { 
			if (p == null) { 
				p = pre; 
				q = root; 
			} else { 
				q = root; 
			} 
		} 
		pre = root; 
		dfs(root.right); 
	} 
}
