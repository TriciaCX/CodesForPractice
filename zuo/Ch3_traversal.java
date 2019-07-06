import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import struct.Node;
import struct.TreeNode;

public class Ch3_traversal
{
	//二叉树前序遍历--递归实现
	List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null)
        	return res;
        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return res;
    }
    
	//二叉树前序遍历--非递归实现
    public List<Integer> preorderTraversalII(TreeNode root) {
    	if(root==null)
        	return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
        	root = stack.pop();
        	res.add(root.val);
        	if(root.right!=null) {
        		stack.push(root.right);
        	}
        	if(root.left!=null) {
        		stack.push(root.left);
        	}
        }
        return res;
    }
    

    //leetcode589 N叉树的前序遍历 --非递归
    
    public List<Integer> preorder(Node root) {
        if(root==null) {
        	return res;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
        	root = stack.pop();
        	res.add(root.val);
        	List<Node> list = root.children;
        	for(int i=list.size()-1;i>=0;i--) {
        		stack.push(list.get(i));
        	}
        }
        
        return res;
    
    }
    
    //二叉树的中序遍历--递归
     public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null)
        	return res;
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }
     
     //二叉树的中序遍历--非递归
     public List<Integer> inorderTraversalII(TreeNode root) {
    	 if(root == null)
    		 return res;
    	 Stack<TreeNode> stack = new Stack<>();
    	 while(!stack.isEmpty() || root!=null) {
    		 if(root!=null) {
    			 stack.push(root);
    			 root = root.left;
    		 }else {
    			 root = stack.pop();
    			 res.add(root.val);
    			 root = root.right;
    		 }
    	 }
    	 return res;
     }
     
     //二叉树的后序遍历--递归
     public List<Integer> postorderTraversal(TreeNode root) {
         if(root == null) {
        	 return res;
         }
         postorderTraversal(root.left);
         postorderTraversal(root.right);
         res.add(root.val);
         return res;
     }
     
     //二叉树的后序遍历--非递归 2个栈
     public List<Integer> postorderTraversalII(TreeNode root) {
    	 if(root!=null) {
    		 Stack<TreeNode> s1 = new Stack<>();
    		 Stack<TreeNode> s2 = new Stack<>();
    		 s1.push(root);
    		 while(!s1.isEmpty()) {
    			 root = s1.pop();
    			 s2.push(root);
    			 if(root.left!=null) {
    				 s1.push(root.left);
    			 }
    			 if(root.right!=null) {
    				 s1.push(root.right);
    			 }
    		 }
    		 while(!s2.isEmpty()) {
    			 res.add(s2.pop().val);
    		 }
    	 }
    	 return res;
     }
     
      // 二叉树的后序遍历--非递归 1个栈
//     public List<Integer> postorderTraversalIII(TreeNode root) {
//    	 
//     }
     
     
     //二叉树的层序遍历
    
     public List<List<Integer>> levelOrder(TreeNode root) {
    	 List<List<Integer>> resList = new ArrayList<>();
         if(root==null) {
        	 return resList;
         }
         Queue<TreeNode> queue = new LinkedList<TreeNode>();
         queue.add(root);
         int level =0; //第几层了（从0开始）
         while(!queue.isEmpty()) { 
        	 resList.add(new ArrayList<Integer>()); //每一层新建一个链表

        	 int level_num = queue.size(); //这一层有几个元素
        	 for(int i=0;i<level_num;i++) {
        		 TreeNode node = queue.remove();
        		 resList.get(level).add(node.val);

        		 if(node.left!=null) {
        			 queue.add(node.left);
        		 }
        		 if(node.right!=null) {
        			 queue.add(node.right);
        		 }
        	 }
        	 level++;
         }
         return resList;
     }
     
     
     
     List<List<Integer>> levels = new ArrayList<List<Integer>>();

     public List<List<Integer>> levelOrderII(TreeNode root) {
         if (root == null) return levels;
         helper(root, 0);
         return levels;
     }
     
     public void helper(TreeNode node, int level) {
         // start the current level
         if (levels.size() == level)
             levels.add(new ArrayList<Integer>());

          // fulfil the current level
          levels.get(level).add(node.val);

          // process child nodes for the next level
          if (node.left != null)
             helper(node.left, level + 1);
          if (node.right != null)
             helper(node.right, level + 1);
     }
     



}
