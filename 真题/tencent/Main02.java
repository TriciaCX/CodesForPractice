package enterprise.tencent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Create by Tricia on 2019/9/1
 *
 * 鹅厂的下午茶时间到！很多人都去了公司楼下的星巴克买咖啡。由于买咖啡的人很多，所以就排起了长队。
 * 队伍当中有n个顾客，从1到n标号。一开始，每个顾客在队伍当中的位置是i。
 * 每个顾客的不满意度等于站在他前面的人与ai的乘积，加上站在他后面的人与bi的乘积。
 * 也就是说，假设顾客i位于位置j，那么他的不满意度为ai*(j-1)+bi*(n-j)
 * 作为咖啡店的经理，本着顾客至上的原则，你需要重新安排每个顾客的位置，使得所有顾客的不满意度的总和最小。
 */
public class Main02 {

    static class cus{
        int a;
        int b;
        public cus(int a,int b){
            this.a = a;
            this.b = b;
        }
    }

    public static void  main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //顾客的数量
        int[][] matrix = new int[n][2];
        for(int i=0;i<n;i++){
            matrix[i][0] = scanner.nextInt();
            matrix[i][1] = scanner.nextInt();
        }

        ArrayList<cus> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new cus(matrix[i][0],matrix[i][1]));
        }
        Collections.sort(list, new Comparator<cus>() {
            @Override
            public int compare(cus o1, cus o2) {
                if(o1.b-o1.a<o2.b-o2.a)
                    return 1;
                else if(o1.b-o1.a>o2.b-o2.a)
                    return -1;
                return 0;
            }
        });

        int res =0;
        for(int i=0;i<n;i++){
            res +=list.get(i).a*(i-1)+list.get(i).b*(n-i);
        }
        System.out.println(res);
    }
}
