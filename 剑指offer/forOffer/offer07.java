package forOffer;

import struct.TreeNode;

import java.util.HashMap;

public class offer07 {
    /**
     * 重建二叉树
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     */

    private HashMap<Integer, Integer> map = new HashMap<>();  //用于存储中序遍历的每个点的位置

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if(pre==null || in==null || pre.length!=in.length) {
            return null;
        }
        for(int i =0;i<in.length;i++) {
            map.put(in[i], i);
        }
        return reConstructBinaryTreeCore(pre, 0,pre.length-1,0);
    }

    private TreeNode reConstructBinaryTreeCore(int[] pre, int preL, int preR, int inL){
        if(preL>preR)
            return null;
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = map.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTreeCore(pre, preL+1, preL+leftTreeSize, inL);
        root.right = reConstructBinaryTreeCore(pre, preL+leftTreeSize+1, preR, inL+leftTreeSize+1);
        return root;
    }
}
