package interviewTop100;

import java.util.ArrayList;
import java.util.List;

public class leetcode54
{
/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

示例 1:

输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]
示例 2:

输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
        if(matrix==null || matrix.length==0 ||matrix[0].length==0)
        	return res;
        int row = matrix.length;
        int col = matrix[0].length;
        int cnt = (Math.min(row, col)+1)/2;
        int i = 0;
        while(i<cnt) {
        	for(int j=i;j<col-i;j++) {
        		res.add(matrix[i][j]);
        	}
        	for(int j=i+1;j<row-i;j++) {
        		res.add(matrix[j][(col-1)-i]);
        	}
        	for(int j=(col-1)-(i+1);j>=i && (row-1-i!=i);j--) {
        		res.add(matrix[row-1-i][j]);
        	}
        	for(int j=(row-1)-(i+1);j>=i+1 && (col-1-i!=i);j--) {
        		res.add(matrix[j][i]);
        	}
        	i++;
        }
        return res;
	}
}
