package forOffer;

import struct.TreeLinkNode;

public class offer08 {
    /**
     * 二叉树的下一个结点
     * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        //有右子树
        if(pNode.right!=null) {
            //返回右子树最左的节点
            TreeLinkNode node = pNode.right;
            while(node.left!=null) {
                node = node.left;
            }
            return node;
        }
        //没有右子树的话,向上找第一个左链接指向的树包含该节点的祖先节点。
        else {
            while(pNode.next!=null) {
                TreeLinkNode parentNode = pNode.next;
                if(parentNode.left==pNode)
                    return parentNode;
                pNode = pNode.next;
            }
        }
        return null;
    }
}
