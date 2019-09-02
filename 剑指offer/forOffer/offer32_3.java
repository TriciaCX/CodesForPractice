package forOffer;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class offer32_3 {
    /**
     * 按之字形顺序打印二叉树
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
       ArrayList<ArrayList<Integer>> res = new ArrayList<>();
       if(pRoot==null) return res;
        LinkedList<TreeNode> dqueue = new LinkedList<>();
        dqueue.add(pRoot);
        int level = 1;
        while(!dqueue.isEmpty()){
            int size = dqueue.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            if(level%2==1){ //奇数，从左到右
                for(int i=0;i<size;i++){
                    TreeNode node = dqueue.pollFirst();
                    tmp.add(node.val);
                    if(node.left!=null) dqueue.addLast(node.left);
                    if(node.right!=null) dqueue.addLast(node.right);
                }
            } else{
                for(int i=0;i<size;i++){
                    TreeNode node = dqueue.pollLast();
                    tmp.add(node.val);
                    if(node.right!=null) dqueue.addFirst(node.right);
                    if(node.left!=null) dqueue.addFirst(node.left);
                }
            }
            level++;
            res.add(tmp);
        }
        return res;
    }
}
