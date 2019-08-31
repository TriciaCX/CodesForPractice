package forOffer;

public class offer19 {
    /**
     * 正则表达式
     * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
     * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"和"匹配，但是与"aa.a"和"ab*a"均不匹配
     */

    public static void main(String[] args){
        String str = "";
        String pattern = ".";
        System.out.println(match(str.toCharArray(),pattern.toCharArray()));
    }
    public static  boolean match(char[] str, char[] pattern) {
        int m = str.length;
        int n = pattern.length;
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int i=1;i<=n;i++){
            if(pattern[i-1]=='*')
                dp[0][i] = dp[0][i-2];
        }

        for(int i=1;i<=m;i++){
            for(int j =1;j<=n;j++){
                if(pattern[j-1]==str[i-1] || pattern[j-1]=='.')
                    dp[i][j] = dp[i-1][j-1];
                else if(pattern[j-1]=='*'){
                    if(pattern[j-2]==str[i-1]||pattern[j-2]=='.'){
                        dp[i][j] |= dp[i][j - 1]; // a* counts as single a
                        dp[i][j] |= dp[i - 1][j]; // a* counts as multiple a
                        dp[i][j] |= dp[i][j - 2]; // a* counts as empty
                    } else
                        dp[i][j] = dp[i][j - 2];   // a* only counts as empty
                }
            }
        }
        return dp[m][n];
    }
}
