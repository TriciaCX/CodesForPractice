package LeetCode;

public class leet_CountAndSay
{
	/*
	 * The count-and-say sequence is the sequence of integers beginning as follows:
     1, 11, 21, 1211, 111221, ...
     1is read off as"one 1"or11.
     11is read off as"two 1s"or21.
     21is read off as"one 2, then one 1"or1211.
     Given an integer n, generate the nth sequence.
     Note: The sequence of integers will be represented as a string.
	 */
	public String countAndSay(int n) {
		if(n<=0) return "";
		String resultString = "1";
		for(int i=1;i<n;i++) {
			resultString = countAndSayCore(resultString);
		}
		return resultString;
	}


	private String countAndSayCore(String resultString)
	{
		if(resultString==null||resultString=="") {
			return null;
		}
		int len = resultString.length();
		char temp = resultString.charAt(0);
		int num = 1;
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<len;i++) {
			if(resultString.charAt(i)==temp) {
				num++;
				continue;
			}else {
				sb.append(String.valueOf(num)+temp);
				temp = resultString.charAt(i);
				num=1;
			}
		}
		sb.append(String.valueOf(num)+temp);
		return sb.toString();
	}
}
