package enterprise.xiaomi;

import java.util.Scanner;

public class Main02 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static void solutonImpro(String[] input){
        if(input==null) return;
        for(int i=0;i<input.length;i++){
            String[] chars = input[i].split(" ");
            //合并相同值
            for(int j=0;j<chars.length-1;j++){
                int p1 = Integer.parseInt(chars[j]);
                int p2 = Integer.parseInt(chars[j+1]);
                if(p1!=0 && p1==p2){
                    chars[j] = String.valueOf(p1+p2);
                    chars[j+1] = String.valueOf(0);
                }
            }
            //移动位置
            StringBuilder stringBuilder = new StringBuilder();
            int cnt = 0; //记录0的个数
            for(int j=0;j<chars.length;j++){
                if(!chars[j].equals("0")){
                    stringBuilder.append(chars[j]).append(" ");
                }else {
                    cnt++;
                }
            }
            while (cnt-- >0){
                stringBuilder.append("0").append(" ");
            }
            System.out.println(stringBuilder);
        }
    }





    static void solution(String[] input) {

        int rows = input.length;
        String tmp = input[0];
        int cols = tmp.replace(" ","").length();
        int[][] matrix = new int[rows][cols];
        for(int i=0;i<rows;i++){
            String[] t = input[i].split(" ");
            for(int j=0;j<cols;j++)
            matrix[i][j] = Integer.valueOf(t[j]);
        }
        getRes(matrix);

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

    }

    private static void getRes(int[][] matrix) {
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++){
                for( int k=j;k<matrix[0].length;k++){
                    if(matrix[i][k]!=0){
                        if(k<matrix[0].length-1){
                            if(matrix[i][k]!=matrix[i][k+1]){
                                int tmp = matrix[i][k];
                                matrix[i][k] = 0;
                                matrix[i][j] = tmp;
                            }else{
                                int tmp = 2*matrix[i][k];
                                matrix[i][k] =0;
                                matrix[i][k+1] =0;
                                matrix[i][j] = tmp;
                            }
                        }
                        else{
                            int tmp = matrix[i][k];
                            matrix[i][k] =0;
                            matrix[i][j] = tmp;
                        }
                        break;
                    }
                }
            }
        }
    }

    /******************************结束写代码******************************/


    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        in.nextLine();
//        for(int i=0;i<n;i++){
//            String s = in.nextLine();
//            String
//        }
        Scanner in = new Scanner(System.in);
        String res;

        int _input_size = 0;
        _input_size = Integer.parseInt(in.nextLine().trim());
        String[] _input = new String[_input_size];
        String _input_item;
        for(int _input_i = 0; _input_i < _input_size; _input_i++) {
            try {
                _input_item = in.nextLine();
            } catch (Exception e) {
                _input_item = null;
            }
            _input[_input_i] = _input_item;
        }
       solution(_input);

    }
}
