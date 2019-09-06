package forOffer;

public class offer67 {
    /**
     * 把字符串转换成整数
     * 将一个字符串转换成一个整数，字符串不是一个合法的数值则返回 0，要求不能使用字符串转换整数的库函数。
     *
     * Iuput:
     * +2147483647
     * 1a33
     *
     * Output:
     * 2147483647
     * 0
     */
    public int StrToInt(String str) {
       if(str==null || str.length()==0)
           return 0;
       boolean isNegtive = str.charAt(0)=='-';
       int res = 0;
       for(int i=0;i<str.length();i++){
           char c = str.charAt(i);
           if(i==0 && (c=='+'|| c=='-'))
               continue;
           if(c<'0' || c>'9')
               return 0;
           res=res*10 +(c-'0');
       }
       return  isNegtive? -res:res;

    }

}
