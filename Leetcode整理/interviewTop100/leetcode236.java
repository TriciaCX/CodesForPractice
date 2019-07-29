package interviewTop100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import struct.TreeNode;

public class leetcode236
{
	/**
	 * 二叉树的最近公共祖先
	 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
	 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
	 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
	 */
	
	

	/**
	 * 方法一：递归
这种方法非常直观。先深度遍历改树。当你遇到节点 p 或 q 时，返回一些布尔标记。该标志有助于确定是否在任何路径中找到了所需的节点。最不常见的祖先将是两个子树递归都返回真标志的节点。它也可以是一个节点，它本身是p或q中的一个，对于这个节点,子树递归返回一个真标志。

让我们看看基于这个想法的形式算法。

算法：

从根节点开始遍历树。
如果当前节点本身是 p 或 q 中的一个，我们会将变量 mid 标记为 true，并继续搜索左右分支中的另一个节点。
如果左分支或右分支中的任何一个返回 true，则表示在下面找到了两个节点中的一个。
如果在遍历的任何点上，左、右或中三个标志中的任意两个变为 true，这意味着我们找到了节点 p 和 q 的最近公共祖先。

	 */
	class Solution {

	    private TreeNode ans;

	    public Solution() {
	        // Variable to store LCA node.
	        this.ans = null;
	    }

	    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

	        // If reached the end of a branch, return false.
	        if (currentNode == null) {
	            return false;
	        }

	        // Left Recursion. If left recursion returns true, set left = 1 else 0
	        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

	        // Right Recursion
	        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

	        // If the current node is one of p or q
	        int mid = (currentNode == p || currentNode == q) ? 1 : 0;


	        // If any two of the flags left, right or mid become True
	        if (mid + left + right >= 2) {
	            this.ans = currentNode;
	        }

	        // Return true if any one of the three bool values is True.
	        return (mid + left + right > 0);
	    }

	    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        // Traverse the tree
	        this.recurseTree(root, p, q);
	        return this.ans;
	    }
	}

	
	/**
	 * method2 使用父指针迭代
	 * 如果每个节点都有父指针，那么我们可以从 p 和 q 返回以获取它们的祖先。在这个遍历过程中，我们得到的第一个公共节点是 LCA 节点。我们可以在遍历树时将父指针保存在字典中。
	 * 算法：从根节点开始遍历树。在找到 p 和 q 之前，将父指针存储在字典中。
	 * 一旦我们找到了 p 和 q，我们就可以使用父亲字典获得 p 的所有祖先，并添加到一个称为祖先的集合中。
	 * 同样，我们遍历节点 q 的祖先。如果祖先存在于为 p 设置的祖先中，这意味着这是 p 和 q 之间的第一个共同祖先（同时向上遍历），因此这是 LCA 节点。
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Map<TreeNode, TreeNode> parent  = new HashMap<TreeNode, TreeNode>();
        parent.put(root, null);
        stack.push(root);
        
        while(!parent.containsKey(p) || !parent.containsKey(q)) {
        	TreeNode node = stack.pop();
        	if(node.left!=null) {
        		parent.put(node.left, node);
        		stack.push(node.left);
        	}
        	if(node.right!=null) {
        		parent.put(node.right, node);
        		stack.push(node.right);
        	}
        }
        
        Set<TreeNode> ancestors = new HashSet<>();
        while(p!=null) {
        	ancestors.add(p);
        	p = parent.get(p);
        }
        
        while(!ancestors.contains(q))
        	q = parent.get(q);
        return q;
	}
	
	
	//DFS回溯
	/**
	 * 对二叉树做后序遍历，回溯：
	 * 回溯时：捕获mid，即当前节点是否为P或Q;
	 * 当left right mid中有两个为true时，说明当前节点是最近的公共节点，记录至res
	 * 返回值：左子树或右子树或当前节点中包含p或q
	 * 最终返回最近公共节点res
	 */
	
	class SolutionII {
	    
		TreeNode res = null;
	    
	    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        dfs(root, p, q);
	        return res;
	    }
	    
	    private int dfs(TreeNode root, TreeNode p, TreeNode q){
	        if(root == null) return 0;
	        int left = dfs(root.left, p, q);
	        int right = dfs(root.right, p, q);
	        int mid = root == p || root == q ? 1 : 0;  //当前节点是否是p或q
	        if(left + right + mid > 1) res = root;
	        return left + right + mid > 0 ? 1 : 0;
	    }
	}
	
	
	class SolutionIII{
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
