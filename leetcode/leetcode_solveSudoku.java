package LeetCode;

public class leetcode_solveSudoku
{
	/**
	 * sudoku-solver
	 * Write a program to solve a Sudoku puzzle by filling the empty cells.
	 * Empty cells are indicated by the character'.'.
	 * You may assume that there will be only one unique solution.
	 */
	public void solveSudoku(char[][] board) {		
		if(board==null||board.length==0||board[0].length==0)
			return;
		solveSudokuCore(board);
	}

	private boolean solveSudokuCore(char[][] board)
	{
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				if(board[i][j]=='.') {
					for(char c='1';c<='9';c++) {
						if(isValid(board,c,i,j)) {
							board[i][j]=c;
							if(solveSudokuCore(board))
								return true;
							board[i][j]='.';
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	private boolean isValid(char[][] board, char c, int row, int col)
	{
		//判断添加的字符是否满足行列的要求（不重复就行）
		for(int i=0;i<board.length;i++) {
			if(board[i][col]==c)
				return false;
			if(board[row][i]==c)
				return false;
		}

		//判断是否满足小方格的要求
		int squareRow=(row/3)*3;
		int squareCol=(col/3)*3;
		for(int i=squareRow;i<squareRow+3;i++) {
			for(int j=squareCol;j<squareCol+3;j++) {
				if(board[i][j]==c)
					return false;
			}
		}

		return true;
	}
}
