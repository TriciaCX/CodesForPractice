package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class leetcode_ValidSudoku
{
	/**
	 * valid-sudoku
	  * 数独规则：即确定每一行，每一列以及每一个九宫格是否有相同的数字
	 * HashSet的add方法，当添加成功（即set中不含有该元素）返回true
	 */
	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			Set<Character> row = new HashSet<Character>(); //存放校验行的set
			Set<Character> col = new HashSet<Character>(); //存放校验列的set
			Set<Character> cube = new HashSet<Character>(); //存放校验cube的set

			for (int j = 0; j < 9; j++) {
				// 第i行
				if (board[i][j] != '.' && !row.add(board[i][j]))
					return false;
				// 第i列
				if (board[j][i] != '.' && !col.add(board[j][i]))
					return false;
				// 小正方形
				int cubeRow = 3 * (i / 3) + j / 3;
				int cubeCol = 3 * (i % 3) + j % 3; //关键点
				if (board[cubeRow][cubeCol] != '.' && !cube.add(board[cubeRow][cubeCol]))
					return false;
			}
		}
		return true;
	}
}
