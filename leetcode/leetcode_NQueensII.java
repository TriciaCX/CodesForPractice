package LeetCode;

import java.util.ArrayList;

public class leetcode_NQueensII
{
	/**
	 * n-queens-ii
	 * Follow up for N-Queens problem.
	 * Now, instead outputting board configurations, 
	 * return the total number of distinct solutions.
	 */
	boolean[] col ;
	boolean[] dia1;
	boolean[] dia2;
	int res = 0;
	public int totalNQueens(int n) {
		if(n<=0) return 0;
		col = new boolean[n];
		dia1 = new boolean[2*n-1];
		dia2 = new boolean[2*n-1];	
		NQueensCore(n,0,new ArrayList<Integer>());
		return res;
	}


	private void NQueensCore(int n, int j, ArrayList<Integer> row)
	{
		if(j==n) {
	        res++;
			return;
		}
		for(int i=0;i<n;i++) {
			if(!col[i] && !dia1[j+i] &&!dia2[j-i+n-1]) {
				col[i] = true;
				dia1[j+i]=true;
				dia2[j-i+n-1]=true;
				
				row.add(i);
				NQueensCore(n, j+1, row);
				row.remove(row.size()-1);
				
				col[i] = false;
				dia1[j+i]=false;
				dia2[j-i+n-1]=false;
			}
		}
	}
}
