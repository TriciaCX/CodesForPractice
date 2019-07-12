package interviewTop100;


import java.util.HashMap;
import java.util.Map;

public class leetcode171
{
/**
 * Excel表列序号
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
例如，
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
示例 1:
输入: "A"
输出: 1
 */
	public int titleToNumber(String s) {
		if(s==null ||s.length()==0)
	    	   return 0;
	       int res = 0;
	       for(int i=s.length()-1;i>=0;i--) {
	    	   char tmp = s.charAt(i);
	    	  res += (Integer.valueOf(tmp)-64)*Math.pow(26,s.length()-i-1);
	           //System.out.println(Integer.valueOf(tmp)-64 +" "+Math.pow(26,s.length()-i-1));
	           
	       }
	       return res;    
	}

}
