package forOffer;

import struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class offer32_2 {
    /**
     * 把二叉树打印成多行
     *从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot==null)
            return  res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);

        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
