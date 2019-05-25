package LeetCode;

public class leetcode_WordSearch
{
	/**
	 * word-search
	 * Given a 2D board and a word, find if the word exists in the grid.
	 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
	 * For example,Given board =
	 * [
	 *    ["ABCE"],
	 *    ["SFCS"],
	 *    ["ADEE"]
	 * ]
	 *  word ="ABCCED", -> returns true,
	 *  word ="SEE", -> returns true,
	 *  word ="ABCB", -> returns false.
	 */
	public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0||board[0].length==-0) 
        	return false;
        //用回溯法找?
        int col = board[0].length;
        int row = board.length;
        boolean[][] isVisited = new boolean[row][col];
        for(int i = 0; i < row; i++) {
           for (int j = 0; j<col; j++){
			  if(dfs(board,word,isVisited,i,j,row,col,0)) {
				  return true;
			  }
		   }
        }
        return false;
	}

	private boolean dfs(char[][] board, String word, boolean[][] isVisited, int i, int j, int row, int col, int start)
	{
		if(start == word.length()) {
			return true;
		}
		if (i<0||i>=row||j<0||j>=col||board[i][j]!=word.charAt(start))
			return false;
		
	    if(isVisited[i][j])
	    	return false;
	    
	    isVisited[i][j] = true;
	    boolean res=dfs(board, word, isVisited, i-1, j, row, col, start+1)||
	    		dfs(board, word, isVisited, i+1, j, row, col, start+1)||
	    		dfs(board, word, isVisited, i, j-1, row, col, start+1)||
	    		dfs(board, word, isVisited, i, j+1, row, col, start+1);
	    isVisited[i][j]=false;//回溯到上一个节点
		return res;
	}
}
