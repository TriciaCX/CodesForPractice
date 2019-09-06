package forOffer;

import struct.TreeNode;

public class offer68 {
    /**
     * 树中两个节点的最低公共祖先
     */
    //二叉查找树--leetcode235
    //二叉查找树中，两个节点 p, q 的公共祖先 root 满足 root.val >= p.val && root.val <= q.val。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return root;
        if(root.val>p.val && root.val>q.val)
            return lowestCommonAncestor(root.left,p,q);
        if(root.val<p.val && root.val<q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
    //普通二叉树--leetcode236
    //在左右子树中查找是否存在 p 或者 q，如果 p 和 q 分别在两个子树中，那么就说明根节点就是最低公共祖先。
    public TreeNode lowestCommonAncestorII(TreeNode root,TreeNode p,TreeNode q){
        if(root == null || root==p || root==q)
            return  root;
        TreeNode left = lowestCommonAncestorII(root.left,p,q);
        TreeNode right = lowestCommonAncestorII(root.right,p,q);
        return left==null? right:right==null?left:root;
    }
    class Solution {
        TreeNode res = null;
        public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q) {
            dfs(root, p, q);
            return res;
        }

        private int dfs(TreeNode root, TreeNode p, TreeNode q){
            if(root==null) return 0;
            int left = dfs(root.left, p, q);
            int right = dfs(root.right, p, q);
            int mid = root==p ||root==q?1:0;
            if(left+mid+right>1) res = root;
            return left+mid+right>0? 1:0;
        }
    }


}
