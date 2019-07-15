package interviewTop100;

import java.util.LinkedList;
import java.util.Queue;

import struct.TreeNode;

public class leetcode101
{
/**
 * 给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3
说明:

如果你可以运用递归和迭代两种方法解决这个问题，会很加分。

 */
	public boolean isSymmetric(TreeNode root) {
		return isSymmetricTwo(root,root);
	}

	public boolean isSymmetricTwo(TreeNode r1, TreeNode r2) {
		if(r1==null && r2!=null)
			return false;
		if(r2==null && r1!=null)
			return false;
		if(r1==null && r2 ==null)
			return true;
		if(r1.val!=r2.val)
			return false;
		return isSymmetricTwo(r1.left, r2.right) && isSymmetricTwo(r1.right,r2.left);
	}


	/**
	 * 队列中每两个连续的结点应该是相等的，而且它们的子树互为镜像。最初，队列中包含的是 root 以及 root。
	 * 该算法的工作原理类似于 BFS，但存在一些关键差异。
	 * 每次提取两个结点并比较它们的值。
	 * 然后，将两个结点的左右子结点按相反的顺序插入队列中。
	 * 当队列为空时，或者我们检测到树不对称（即从队列中取出两个不相等的连续结点）时，该算法结束。
	 */
	public boolean isSymmetricII(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode t1 = q.poll();
			TreeNode t2 = q.poll();
			if (t1 == null && t2 == null) continue;
			if (t1 == null || t2 == null) return false;
			if (t1.val != t2.val) return false;
			q.add(t1.left);
			q.add(t2.right);
			q.add(t1.right);
			q.add(t2.left);
		}
		return true;
	}


}
