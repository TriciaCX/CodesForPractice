package forOffer;

public class offer58_1 {
    /**
     * 翻转单词顺序列
     */

    public static void main(String[] args) {
        String str = " ";
        System.out.println(ReverseSentence(str));
    }

    //辅助空间
    public static String ReverseSentence(String str) {
        if(str==null) return null;
        if(str.trim().equals("")) return str;
        String[] strs = str.split(" ");
        String res="";
        int len = strs.length;
        for(int i=len-1;i>=0;i--){
            if(i!=0)
                res+=strs[i]+" ";
            else
                res+=strs[i];
        }
        return res;
    }

    //不使用额外的空间 先旋转每个单词，再旋转整个字符串。
    public String ReverseSentenceII(String str) {
        int n = str.length();
        char[] chars = str.toCharArray();
        int i = 0, j = 0;
        while (j <= n) {
            if (j == n || chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        reverse(chars, 0, n - 1);
        return new String(chars);
    }

    private void reverse(char[] c, int i, int j) {
        while (i < j)
            swap(c, i++, j--);
    }

    private void swap(char[] c, int i, int j) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }
}
