package interviewTop100;

public class leetcode200
{
/*
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
示例 1:
输入:
11110
11010
11000
00000
输出: 1

示例 2:
输入:
11000
11000
00100
00011
输出: 3

 */
	//深度优先搜索
	/**
	 * 线性扫描整个二维网格，如果一个结点包含 1，则以其为根结点启动深度优先搜索。在深度优先搜索过程中，每个访问过的结点被标记为 0。计数启动深度优先搜索的根结点的数量，即为岛屿的数量。
	 */
	public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0)
        	return 0;
		int cnt = 0;
		int row = grid.length;
        int col = grid[0].length;
    
        for(int i = 0;i<row;i++) {
        	for(int j=0;j<col;j++) {
        		if(grid[i][j] =='1') {
                    cnt++;
        			dfs(grid,i,j); 			
        		}
        	}
        }
        
        return cnt;
	}

	private void dfs(char[][] grid, int i, int j){
	    int row = grid.length;
	    int col = grid[0].length;
	    if(i>=row||i<0||j>=col||j<0||grid[i][j]=='0')
	    	return;
	    grid[i][j] = '0';
	    dfs(grid, i-1, j);
	    dfs(grid, i, j-1);
	    dfs(grid, i+1, j);
	    dfs(grid, i, j+1);
	}
	
}


		


