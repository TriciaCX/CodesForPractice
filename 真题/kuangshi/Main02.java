package enterprise.kuangshi;

import java.util.Scanner;

public class Main02 {
    /**
     * leetcode314
     * 给定一个只包含小写英文字母的字符串以及一个常数k，求字符串最长的包含不超过k种字母的子串的长度
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k  =scanner.nextInt();
        String s = scanner.next();
        int[] map = new int[256];
        int cnt = 0;
        int res = 0;
        int p=0;

        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(map[chars[i]]==0){ //出现了一个新字符
                cnt++;
            }
            map[chars[i]]++;
            while(cnt>k){   //超出之后开始减
                if(--map[chars[p++]]==0)
                    cnt--;
            }
            res = Math.max(res,i-p+1);
        }
        System.out.println(res);
    }
}
