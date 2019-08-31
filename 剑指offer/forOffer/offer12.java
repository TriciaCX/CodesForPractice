package forOffer;

public class offer12 {
    /**
     * 矩阵中的路径
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
     * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
     * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
     * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bccced"的路径，但是矩阵中不包含"abcb"路径，
     * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
     */

    public static  void main(String[] args){
        char[] matrix = "ABCESFCSADEE".toCharArray();
        char[] str = "ABAB".toCharArray();
        System.out.println(hasPath(matrix,3,4,str));
    }

    public static  boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
       if(matrix==null ||matrix.length==0 || rows<=0 || cols<=0 || str==null)
           return false;
       if(str.length==0) return  true;

       boolean[] flags = new  boolean[matrix.length];
       for(int i=0;i<rows;i++){
           for(int j=0;j<cols;j++){
               if(findStr(str,flags,matrix,i,j,cols,rows,0)){
                   return  true;
               }
           }
       }
       return  false;
    }

    private static  boolean findStr(char[] str, boolean[] flags, char[] matrix, int rowI, int colJ, int cols, int rows, int idx) {
        if(rowI<0 || rowI>=rows|| colJ<0 ||colJ>=cols || matrix[rowI*cols+colJ]!=str[idx] || flags[rowI*cols+colJ]){
            return  false;
        }
       if(idx==str.length-1){
           return  true;
       }

       flags[rowI*cols+colJ] = true;

       if(findStr(str,flags,matrix,rowI+1,colJ,cols,rows,idx+1)
                   ||findStr(str,flags,matrix,rowI-1,colJ,cols,rows,idx+1)
                   ||findStr(str,flags,matrix,rowI,colJ+1,cols,rows,idx+1)
                   ||findStr(str,flags,matrix,rowI,colJ-1,cols,rows,idx+1))
           return  true;

       flags[rowI*cols+colJ] = false;
       return false;
    }
}
