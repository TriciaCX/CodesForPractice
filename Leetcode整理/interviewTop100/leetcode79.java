package interviewTop100;

public class leetcode79
{
/**
 * 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
示例:
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
给定 word = "ABCCED", 返回 true.
给定 word = "SEE", 返回 true.
给定 word = "ABCB", 返回 false.
 */
	public boolean exist(char[][] board, String word) {
        if(board==null ||board.length ==0) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++) {
        	for(int j=0;j<board[0].length;j++) {
        		if(board[i][j]==word.charAt(0))
        		  if(check(board, word,visited, i, j, 0))
        			 return true;
        	}
        }
        return false;
	}

	private boolean check(char[][] board, String word,boolean[][] visited, int row,int col, int start){
		if(start>=word.length())
			return true;
		if(row<0 || row>board.length-1 || col<0 ||col>board[0].length-1 ||board[row][col]!=word.charAt(start)||visited[row][col])
			return false;
		visited[row][col] = true;
		
		boolean res = check(board, word, visited, row-1, col, start+1) ||
				      check(board, word, visited, row+1, col, start+1) ||
				      check(board, word, visited, row, col+1, start+1) ||
				      check(board, word, visited, row, col-1, start+1);
        visited[row][col] = false;
		return res;	
	}
}
