package forOffer;

import struct.TreeNode;

public class offer26 {
    /**
     * 树的子结构
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root1==null || root2==null) return  false;
        return  isSubtreeWithRoot(root1,root2) || HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
    }

    private boolean isSubtreeWithRoot(TreeNode root1, TreeNode root2) {
        if(root2==null) return true; //如果tree2遍历完了都能对应上，返回true
        if(root1==null) return false; //如果tree1遍历完了都无法对应上，返回false
        if(root1.val!=root2.val){    //只要有一个点不匹配就是false
            return  false;
        }
        //如果根节点对应上了，就去看子节点是否匹配
        return isSubtreeWithRoot(root1.left,root2.left) && isSubtreeWithRoot(root1.right,root2.right);
    }
}
