package forOffer;

import java.util.Arrays;

public class offer13 {
    /**
     * 机器人的运动范围
     * 地上有一个 m 行和 n 列的方格。一个机器人从坐标 (0, 0) 的格子开始移动，每一次只能向左右上下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于 k 的格子。
     * 例如，当 k 为 18 时，机器人能够进入方格 (35,37)，因为 3+5+3+7=18。但是，它不能进入方格 (35,38)，因为 3+5+3+8=19。请问该机器人能够达到多少个格子？
     */

    public static  int movingCount(int threshold, int rows, int cols){
       if(rows<=0 ||cols<=0 || threshold<1)
           return  0;
       boolean[]isVisted = new boolean[rows*cols];
        Arrays.fill(isVisted,false);
        int res =   moveCore(isVisted, threshold,0,0,rows,cols);
       return  res;
    }

    private static int moveCore(boolean[] isVisted, int threshold, int rowI, int colJ, int rows, int cols) {
        int res = 0;
        if( rowI<0 || colJ<0 || rowI>=rows ||colJ>=cols||isVisted[rowI*cols+colJ]  || !isValid(rowI,colJ,threshold)){
            return res;
        }
        isVisted[rowI*cols+colJ]=true;
        res= 1+
        moveCore(isVisted,threshold,rowI+1,colJ,rows,cols)+
        moveCore(isVisted,threshold,rowI-1,colJ,rows,cols)+
        moveCore(isVisted,threshold,rowI,colJ+1,rows,cols)+
        moveCore(isVisted,threshold,rowI,colJ-1,rows,cols);
        return  res;
    }

    private static  boolean isValid(int rowI, int colJ, int threshold) {
        int sum1 = 0,sum2 =0;
        while(rowI!=0){
            sum1+=rowI%10;
            rowI/=10;
        }
        while(colJ!=0){
            sum2+=colJ%10;
            colJ/=10;
        }
        if(sum1+sum2>threshold)
            return  false;
        else
            return  true;
    }


    public static void main(String[] args){
        System.out.println(movingCount(5,10,10));
    }
}
