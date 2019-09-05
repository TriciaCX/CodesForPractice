package forOffer;

import java.util.ArrayList;

public class offer50 {
    /**
     * 第一个只出现一次的字符的位置
     */


    public int FirstNotRepeatingChar(String str) {
        if(str==null || str.length()==0) return -1;
        int[] chars = new int[256];
        for(int i=0;i<str.length();i++){
            chars[str.charAt(i)]++;
        }
        for(int i=0;i<str.length();i++){
            if(chars[str.charAt(i)]==1)
                return i;
        }
        return -1;
    }
}
