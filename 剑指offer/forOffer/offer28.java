package forOffer;

import struct.TreeNode;

public class offer28 {
    /**
     * 对称的二叉树
     * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的
     */
    boolean isSymmetrical(TreeNode pRoot) {
        return  isSymmetricalCore(pRoot,pRoot);
    }

    private boolean isSymmetricalCore(TreeNode root1, TreeNode root2) {
        if(root1==null && root2!=null)
            return false;
        if(root1!=null && root2==null)
            return false;
        if(root1==null && root2==null)
            return true;
        if (root1.val!=root2.val)
            return false;
        return isSymmetricalCore(root1.left,root2.right) && isSymmetricalCore(root1.right,root2.left);
    }
}
