package LeetCode;

import java.util.ArrayList;

public class leetcode_NQueens
{
	/*
	 * n-queens
	 * Given an integer n, return all distinct solutions to the n-queens puzzle.
	 * Each solution contains a distinct board configuration of the n-queens' placement, where'Q'and'.'both indicate a queen and an empty space respectively.
	 * For example,There exist two distinct solutions to the 4-queens puzzle:
	 * [
        [".Q..",  // Solution 1
  		"...Q",
  		"Q...",
  		"..Q."],

 		["..Q.",  // Solution 2
  		"Q...",
  		"...Q",
  		".Q.."]
		]
	 */
	
	/**
	 * 著名n皇后问题
	 * 题目解析：
	 * n个皇后摆放在n*n的棋盘格中，使得横、竖和两个对角线方向均不会同时出现两个皇后
	 * <p>
	 * 解题思路：
	 * 由于需要在n*n的棋盘格中放入n个皇后，就必须每一行放一个
	 * 否则就会出现一行有两个皇后的情况，会发生冲突。
	 * 那么就可以递归的解决每一行问题
	 * 最核心的问题是：如何能快速判断不合法的情况，即快速剪枝
	 * 同行或同列的冲突可以简单用一个数组来考虑，难点是两条对角线
	 * 对角线条数2*n-1
	 * 左对角线：坐标x+y是一个唯一定值  x+y      范围为0到2*n-2
	 * 右对角线：坐标x-y是一个唯一定值  x-y+n-1  范围为0到2*n-2
	 */
	ArrayList<String[]> res = new ArrayList<>();
	boolean[] col;
	boolean[] dia1;
	boolean[] dia2;
	public ArrayList<String[]> solveNQueens(int n) {
       if(n==0) return res;
       col = new boolean[n];
       dia1 = new boolean[2*n-1];
       dia2 = new boolean[2*n-1];
       solveNQueensCore(n,0,new ArrayList<Integer>());
       return res;
	}
	
	//尝试在第j行中摆放皇后，row[i]表示皇后放在第i列
	private void solveNQueensCore(int n, int j, ArrayList<Integer> row)
	{
		if(j==n) { //到第n行了，结束（其实是0到n-1）
			res.add(displayBoard(n,row));
			return;
		}
       
		for(int i=0;i<n;i++) {
			//判断能否将第j行的皇后放在第i列
			if(!col[i] && !dia1[j+i] && !dia2[j-i+n-1]) {
				col[i] = true;
				dia1[j+i] = true;
				dia2[j-i+n-1] = true;
				
				row.add(i);
				solveNQueensCore(n, j+1, row);
				row.remove(row.size()-1);
				
				col[i] = false;
				dia1[j+i] = false;
				dia2[j-i+n-1] = false;
			}
		}
	}
	
	private String[] displayBoard(int n, ArrayList<Integer> row)
	{
		String[] temp = new String[n];
		for(int i=0;i<n;i++) {
			StringBuilder sBuilder = new StringBuilder();
			for(int j=0;j<n;j++) {
				if(j==row.get(i)) {
					sBuilder.append("Q");
				}else {
					sBuilder.append(".");
				}
			}
			temp[i]=sBuilder.toString();
		}
       return temp;
	}
}
