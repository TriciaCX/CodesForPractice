package interviewTop100;

import java.util.LinkedList;

public class leetcode116
{
/**
 * 填充每个节点的下一个右侧节点指针
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
初始状态下，所有 next 指针都被设置为 NULL。
 */
	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}

	    public Node(int _val,Node _left,Node _right,Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	};

	
	public Node connect(Node root) {
		if(root==null) return root;
		Node curNode = root;
		Node preNode = null;
		while(curNode!=null) {
			while(preNode!=null) {
				preNode.left.next = preNode.right;
				if(preNode.next!=null)
					preNode.right.next = preNode.next.left;
				preNode = preNode.next;
			}
			preNode = curNode;
			curNode =curNode.left;
		}
		return root;
	}
}
