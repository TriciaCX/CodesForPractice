package enterprise.cisco;

import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str  = scanner.next();
        String[] strs = str.split("<");
        str =strs[0];
        StringBuilder sb = new StringBuilder(str);
        if(sb.charAt(0)=='"'){
            sb.deleteCharAt(0);
        }
        if(sb.charAt(sb.length()-1)=='"'){
            sb.deleteCharAt(sb.length()-1);
        }
        if(sb.subSequence(0,3).equals("%22")){
            sb.delete(0,3);
        }
        if(sb.subSequence(sb.length()-3,sb.length()).equals("%22")){
            sb.delete(sb.length()-3,sb.length());
        }
        System.out.println(sb.toString());
    }
}
