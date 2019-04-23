package LeetCode;

import java.util.ArrayList;

public class leetcode_GreyCode
{
	public ArrayList<Integer> grayCode(int n) {
		if(n<0) return null;
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(n==0) {
			res.add(0, 0);
		}
		if(n==1) {
			res.add(0,0);
			res.add(1,1);
		}
		if(n>1) {
            res = grayCode(n-1);
            int temp = 0;
            int j = 1;
            for(int i = (int) Math.pow(2, (n-1));i<Math.pow(2, n);i++,j++) {
            	temp = res.get((int) Math.pow(2, (n-1))-j);
            	res.add(temp+(int)Math.pow(2, (n-1)));
            }
        }
		return res;
	}
}
