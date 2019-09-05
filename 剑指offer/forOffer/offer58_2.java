package forOffer;

public class offer58_2 {
    /**
     * 左翻转字符串
     * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
     * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
     * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
     */
     //先将 "abc" 和 "XYZdef" 分别翻转，得到 "cbafedZYX"，然后再把整个字符串翻转得到 "XYZdefabc"。
    public String LeftRotateString(String str,int n) {
        if (n >= str.length())
            return str;
        int len = str.length();
        char[] chars = str.toCharArray();
        reverse(chars,0,n-1);
        reverse(chars,n,len-1);
        reverse(chars,0,len-1);
        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start<=end){
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }
}
