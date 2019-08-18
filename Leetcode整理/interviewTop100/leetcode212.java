package interviewTop100;

import java.util.ArrayList;
import java.util.List;

public class leetcode212
{
	/**
	 * 单词搜索
	 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。

示例:

输入: 
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

输出: ["eat","oath"]
说明:
你可以假设所有输入都由小写字母 a-z 组成。

提示:
你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
	 */
	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<String>();
        if(board==null ||board.length==0 ||board[0].length==0)
        	return res;
        for(String s:words) {
        	if(invlovesWord(board,s)) {
        		res.add(s);
        	}
        }
        return res;
	}

	private boolean invlovesWord(char[][] board, String s){
		int row = board.length;
		int col = board[0].length;
		boolean[][] isVisited = new boolean[row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(board[i][j]==s.charAt(0)) {
					if(findWord(board,isVisited,i,j,s,0))
						return true;
				}
			}
		}
		return false;
	}

	private boolean findWord(char[][] board, boolean[][] isVisited, int rowI, int colJ, String s,int index){
		if(index>=s.length()) {
			return true;
		}
        
		if(rowI<0 || rowI>board.length-1 || colJ<0 || colJ>board[0].length-1 || isVisited[rowI][colJ] || board[rowI][colJ]!=s.charAt(index)) {
			return false;
		}
		isVisited[rowI][colJ]=true;
		boolean flag = findWord(board, isVisited,rowI+1, colJ, s, index+1) 
				|| findWord(board, isVisited,rowI-1, colJ, s, index+1) 
				|| findWord(board, isVisited,rowI, colJ+1, s, index+1) 
				|| findWord(board, isVisited,rowI, colJ-1, s, index+1);
		isVisited[rowI][colJ]=false;
		return flag;
	}
}
