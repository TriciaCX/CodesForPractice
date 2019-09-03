package forOffer;

import java.util.ArrayList;
import java.util.Arrays;

public class offer38 {
    /**
     * 字符串的排列
     * 输入一个字符串，按字典序打印出该字符串中字符的所有排列。
     * 例如输入字符串 abc，则打印出由字符 a, b, c 所能排列出来的所有字符串 abc, acb, bac, bca, cab 和 cba。
     */
    ArrayList<String> res = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
       if(str==null || str.length()==0)
           return res;
       char[] chars = str.toCharArray();
       Arrays.sort(chars);
       boolean[] isVisited = new boolean[chars.length];
       permuCore(chars,isVisited,new StringBuilder());
       return res;
    }

    private  void permuCore(char[] chars, boolean[] isVisited, StringBuilder sb) {
        if(sb.length()==chars.length){
            res.add(sb.toString());
            return;
        }
        for(int i=0;i<chars.length;i++){
            if(isVisited[i]) continue;
            if(i>0 && chars[i]==chars[i-1] && isVisited[i-1]) continue;
            isVisited[i] =true;
            sb.append(chars[i]);
            permuCore(chars,isVisited,sb);
            sb.deleteCharAt(sb.length()-1);
            isVisited[i] =false;
        }
    }


}
