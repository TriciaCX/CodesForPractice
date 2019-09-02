package forOffer;

import struct.TreeNode;

import java.util.ArrayList;

public class offer34 {
    /**
     * 二叉树中和为某一值的路径
     * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     *  路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
     */

   ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
       if(root==null) return res;
       ArrayList<Integer> tmp = new ArrayList<>();
       find(root,target,tmp);
       return  res;
    }

    private void find(TreeNode root, int target, ArrayList<Integer> tmp) {
        if(root==null)
            return;
        target-=root.val;
        tmp.add(root.val);
        if(target==0 && root.left==null && root.right==null){
            res.add(new ArrayList<>(tmp));
        }else{
            find(root.left,target,tmp);
            find(root.right,target,tmp);
        }
        tmp.remove(tmp.size()-1);
    }
}



