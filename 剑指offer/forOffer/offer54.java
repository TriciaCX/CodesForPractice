package forOffer;

import struct.TreeNode;

public class offer54 {
    /**
     * 二叉查找树的第K个节点
     * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
     */
    private int cnt =0;
    private TreeNode ret;
    TreeNode KthNode(TreeNode pRoot, int k) {
        inorder(pRoot,k);
        return ret;
    }

    private void inorder(TreeNode pRoot, int k) {
        if(cnt>=k || pRoot==null)
        return;
        inorder(pRoot.left,k);
        cnt++;
        if(cnt==k)
            ret = pRoot;
        inorder(pRoot.right,k);
    }

}
