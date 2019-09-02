package forOffer;

import struct.TreeNode;

public class offer27 {
    /**
     * 二叉树的镜像
     * 操作给定的二叉树，将其变换为源二叉树的镜像。
     * 输入描述:
     * 二叉树的镜像定义：源二叉树
     *     	    8
     *     	   /  \
     *     	  6   10
     *     	 / \  / \
     *     	5  7 9 11
     *     	镜像二叉树
     *     	    8
     *     	   /  \
     *     	  10   6
     *     	 / \  / \
     *     	11 9 7  5
     */
    //先前序遍历这棵树的每个节点，如果遍历的树有子节点，就交换它的两个子节点，当交换完所有非叶子节点后，就得到了镜像
    public void Mirror(TreeNode root) {
        if(root==null)
            return;
        if(root.left==null && root.right==null)
            return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right =tmp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
