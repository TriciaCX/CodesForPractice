package enterprise.kuangshi;

import java.util.Scanner;

public class Main01 {
    /**
     * 二进制中1的个数
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int cnt = 0;
        while(n!=0){
            n = n&(n-1);
            cnt++;
        }
        System.out.println(cnt);
    }
}
