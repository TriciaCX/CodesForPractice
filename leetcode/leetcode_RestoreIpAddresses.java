package LeetCode;

import java.util.ArrayList;

public class leetcode_RestoreIpAddresses
{
	/**
	 * restore-ip-addresses
	 * Given a string containing only digits, 
	 * restore it by returning all possible valid IP address combinations.
	 * For example:Given"25525511135",return["255.255.11.135", "255.255.111.35"]. (Order does not matter)
	 */
	ArrayList<String> res = new ArrayList<>();
	public ArrayList<String> restoreIpAddresses(String s) { 
        if(s==null||s.length()<=0||s=="") return res;
        ArrayList<String> temp = new ArrayList<>();
        dp(s,0,temp);
        return res;
	}
	private void dp(String s, int start, ArrayList<String> temp)
	{
		if(temp.size()==4 && start==s.length()) {
			res.add(temp.get(0)+'.'+temp.get(1)+'.'+temp.get(2)+'.'+temp.get(3));
			return;
		}
		if(s.length()-start>3*(4-temp.size()))
			return;
		if(s.length()-start<(4-temp.size()))
			return;
		int num=0;
		for(int i=start;i<start+3&&i<s.length();i++) {
			num = num*10+((s.charAt(i))-'0');
			if(num<0||num>255)
				continue;
			temp.add(s.substring(start,i+1));
			dp(s, i+1, temp);
			temp.remove(temp.size()-1);
			
			if(num==0)
				break;
		}
	}
}
