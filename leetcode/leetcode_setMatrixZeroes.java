package LeetCode;

import java.util.ArrayList;

public class leetcode_setMatrixZeroes
{
	/**
	 * set-matrix-zeroes
	 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
	 * Follow up:Did you use extra space?
	 * A straight forward solution using O(m n) space is probably a bad idea.
	 * A simple improvement uses O(m + n) space, but still not the best solution.
	 * Could you devise a constant space solution?
	 */
	  public void setZeroes(int[][] matrix) {
	     int rows = matrix.length;
	     int cols = matrix[0].length;
	     ArrayList<Integer> rowArrayList = new ArrayList<>();
	     ArrayList<Integer> colsArrayList = new ArrayList<>();
	     for(int i=0;i<rows;i++) {
	    	 for(int j=0;j<cols;j++) {
	    		 if(matrix[i][j]==0) {
	    			 rowArrayList.add(i);
	    			 colsArrayList.add(j);
	    		 }
	    	 }
	     }
	     for (Integer integer : rowArrayList)
		{
			for(int i = 0;i<cols;i++) {
			   matrix[integer][i] = 0;
			}
		}
	     for (Integer integer : colsArrayList)
			{
				for(int i = 0;i<rows;i++) {
				   matrix[i][integer] = 0;
				}
			}
	  }
}
