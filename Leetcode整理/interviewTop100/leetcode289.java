package interviewTop100;

public class leetcode289
{
	/**
	 * 生命游戏
	 * 根据百度百科，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在1970年发明的细胞自动机。
给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞具有一个初始状态 live（1）即为活细胞， 或 dead（0）即为死细胞。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：

如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
根据当前状态，写一个函数来计算面板上细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
	 */

	
	/**
	 * 1、遍历二维数组，然后改变每个点的状态； 
	 * 2、遍历取当前位置周围8个细胞，同时记录活细胞数量。如果x坐标或y坐标超出边界，则不记录； （important）把即将死亡的 活细胞 置为 2， 把即将复活的 死细胞 ，置为 -1； 则在判断 当前细胞 >0 时当前为活细胞，<= 0 当前为死细胞；
	 * 3、根据题目要求，通过活细胞数量来改变该点的状态；
	 * 4、最后，再遍历数组，将2 还原为 0，将 -1 还原为 1；
	 */
	
	public void gameOfLife(int[][] board) {
		//遍历数组
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                changeBorder(board,i,j);
            }
        }
        
        //恢复二维数组
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == -1){  //复活的死细胞
                    board[i][j] = 1;
                }
                if(board[i][j] == 2){   //死亡的活细胞
                    board[i][j] = 0;
                }
            }
        }
        
    }

    public void changeBorder(int[][] board,int x, int y){
        int row = board.length;
        int col = board[0].length;

        int total = 0; // 该细胞周围活细胞的数量

        for(int i= x - 1; i <= x + 1 ; i++){
            for(int j= y - 1; j <= y + 1; j++){
                if(i == x && j == y){
                    continue;
                }
                if(i >= 0 && i < row && j >= 0 && j < col){
                    if(board[i][j] > 0){
                        total ++;
                    }
                }
            }
        }
        if(board[x][y] > 0){
            if(total < 2 || total > 3){
                board[x][y] = 2;
            }
        }
        if(board[x][y] <= 0 && total == 3){
            board[x][y] = -1;
        }

    }

}
