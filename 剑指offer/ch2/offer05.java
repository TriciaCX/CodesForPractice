package ch2;

public class offer05
{
	/**
	 * 替换空格
	 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
	 */
	public static void main(String[] args){
		StringBuffer sb = new StringBuffer("We are happy");
		System.out.println(replaceSpace(sb));
	}
	
	
	//方法一：直接用replace方法
	public static String replaceSpace(StringBuffer str) {
      if(str==null ||str.length()==0)
    	   return "";
      for(int i =0;i<str.length();i++) {
    	  if(str.charAt(i)==' ') {
    		  str.replace(i, i+1, "%20");
    	  }
      }
      return str.toString(); 
	}
	
	/*
	 * 
	 * 在字符串尾部填充任意字符，使得字符串的长度等于替换之后的长度。因为一个空格要替换成三个字符（%20），因此当遍历到一个空格时，需要在尾部填充两个任意字符。
	 * 令 P1 指向字符串原来的末尾位置，P2 指向字符串现在的末尾位置。P1 和 P2 从后向前遍历，当 P1 遍历到一个空格时，就需要令 P2 指向的位置依次填充 02%（注意是逆序的），否则就填充上 P1 指向字符的值。
	 * 从后向前遍是为了在改变 P2 所指向的内容时，不会影响到 P1 遍历原来字符串的内容。
	 */
	public static String replaceSpaceII(StringBuffer str) {
		int P1 = str.length() - 1;  //P1为记录原字符串末尾的指针
		for (int i = 0; i <= P1; i++)  
			if (str.charAt(i) == ' ')
				str.append("  ");   //遇到一个空格加两格位置

		int P2 = str.length() - 1;   //p2为记录新字符串末尾的指针
		while (P1 >= 0 && P2 > P1) {
			char c = str.charAt(P1--);  
			if (c == ' ') {
				str.setCharAt(P2--, '0');
				str.setCharAt(P2--, '2');
				str.setCharAt(P2--, '%');
			} else {
				str.setCharAt(P2--, c);
			}
		}
		return str.toString();		
	}
}
