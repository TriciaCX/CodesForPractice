package LeetCode;

public class leetcode_SymmetricTree
{
	/*
	 * symmetric-tree
	 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
	 */
	public boolean isSymmetric(TreeNode root) {
        return isSymmetricCore(root,root);
	}

	private boolean isSymmetricCore(TreeNode node1, TreeNode node2)
	{
		if(node1==null && node2==null) 
			return true;
		if((node1==null&&node2!=null)||(node1!=null&&node2==null))
			return false;
		
		return node1.val==node2.val
				&& isSymmetricCore(node1.left, node2.right)
				&& isSymmetricCore(node1.right,node2.left);
	}
}
