package forOffer;

import java.util.Arrays;

public class offer48 {
    /**
     * 最长不含重复字符的子字符串
     * 输入一个字符串（只包含 a~z 的字符），求其最长不含重复字符的子字符串的长度。例如对于 arabcacfr，最长不含重复字符的子字符串为 acfr，长度为 4。
     */
    public int longestSubStringWithoutDuplication(String str){
        int curLen = 0, maxLen = 0;
        if(str==null || str.length()==0)
            return maxLen;
        int[] preIndex = new int[26]; //用来存储每个字符前一次出现的下标
        Arrays.fill(preIndex,-1);
        for(int curI =0;curI<str.length();curI++){
            int c = str.charAt(curI)-'a';
            int preI = preIndex[c];
            if(preI==-1 || curI-preI>curLen){ //没有出现过 或者 出现的已经在该段外了   a,b,c,[b.a] 这里的a是不算重复的
                curLen++;
            }else{
                maxLen = Math.max(maxLen,curLen);
                curLen = curI - preI;
            }
            preIndex[c] = curI; //更新当前字符的下标
        }
        maxLen = Math.max(maxLen,curLen);
        return maxLen;
    }
}
