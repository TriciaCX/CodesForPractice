package LeetCode;

public class leetcode_isPalindrome
{
	/*
	 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
	 * For example,"A man, a plan, a canal: Panama"is a palindrome. 
	 * "race a car"is not a palindrome.
	 * Note: Have you consider that the string might be empty? This is a good question to ask during an interview.
	 * For the purpose of this problem, we define empty string as valid palindrome.
	 */
	 public boolean isPalindrome(String s) {
	   if(s==null) return true;
	   //对字符串去空格，标点
	   String s1 = s.toLowerCase().replaceAll("[\\pP\\p{Punct}]", "").replace(" " ,"");
	   char[] c = s1.toCharArray();
	   int len = c.length;
	   for(int i =0;i<len/2;i++) {
		   if(c[i]!=c[len-1-i]) {
			  return false;
		   }
	   }
	   return true;
	 }
	 
	 //方法二：两头扫描
	 public boolean isPalindromeII(String s) {
	        int i = 0;
	        int j = s.length() - 1;
	        while (i < j) {
	            while ( ! isLetterOrNumber(s.charAt(i)) && i < j)
	                i ++;
	            while ( ! isLetterOrNumber(s.charAt(j)) && i < j)
	                j --;
	            if(i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
	            i ++;
	            j --;
	        }
	        return true;
	    }
	 
	    public static boolean isLetterOrNumber(char i) {
	        if(i >= '0' && i <= '9' || i >= 'a' && i <= 'z' || i >= 'A' && i <= 'Z') return true;
	        return false;
	    }
}
