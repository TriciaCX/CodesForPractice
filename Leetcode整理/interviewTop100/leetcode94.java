package interviewTop100;

import java.util.ArrayList;
import java.util.Collections;

import struct.TreeNode;


public class leetcode94
{
/**
 * 二叉搜索树中第k小的元素
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。

说明：
你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。

示例 1:

输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 1
示例 2:

输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 3
进阶：
如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？

 */ 
	
	//暴力解法（面试别用）
	ArrayList<Integer> res = new ArrayList<>();
	 public int kthSmallest(TreeNode root, int k) {    
	     res = getList(root);
	     Collections.sort(res);
	     return res.get(k-1);
	 }

private ArrayList<Integer> getList(TreeNode root)
{
     if(root==null)
    	 return res;
     getList(root.left);
     res.add(root.val);
     getList(root.right);
     return res;
}
	

//提前终止中序遍历

	int tar = Integer.MIN_VALUE;
	int cnt = 0;
	public int kthSmallestII(TreeNode root, int k) {
		cnt = k;
		inorder(root);
		return tar;
	}

	private void inorder(TreeNode root){
		if(root==null)
			return;
		inorder(root.left);
 		if(tar!=Integer.MIN_VALUE)
 			return;
 		if(--cnt==0)
 			tar = root.val;
 		inorder(root.right);
	}
}
