package forOffer;

import struct.TreeNode;

public class offer55_2 {
    /**
     * 平衡二叉树
     * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
     */

    boolean isBalanced = true;

    public boolean IsBalanced_Solution(TreeNode root) {
       if (root==null)
           return true;
       height(root);
       return isBalanced;
    }

    private int height(TreeNode root) {
        if(root == null || !isBalanced)
            return 0;
       int left = height(root.left);
       int right = height(root.right);
       if(Math.abs(left-right)>1)
           isBalanced = false;
       return  1+ Math.max(left,right);
    }
}
