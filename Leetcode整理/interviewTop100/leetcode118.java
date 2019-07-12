package interviewTop100;

import java.util.ArrayList;
import java.util.List;



public class leetcode118
{
	
	/**
	 * 杨辉三角
	 * 输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
	 */
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows<=0)
           return res;
        
        List<Integer> tmp1 = new ArrayList<>();
           tmp1.add(1);
           res.add(tmp1);
        if(numRows==1)
        	return res;
        
        List<Integer> tmp2 = new ArrayList<>();
        tmp2.add(1);
        tmp2.add(1);
        res.add(tmp2);
        if(numRows==2)
        	return res;
        
        if(numRows>=3) {
        	for(int i=3;i<=numRows;i++) {
        		List<Integer> tmpi = new ArrayList<>();
        		tmpi.add(1);
        		tmp1 = res.get(i-2);
        		for(int j=0;j<i-2;j++) {
        			tmpi.add(tmp1.get(j)+tmp1.get(j+1));
        		}
        		tmpi.add(1);

        	}
        }
        return res;
    }
	
	public static void mian (String []args) {
		leetcode118 sl = new leetcode118();
		List<List<Integer>> resArrayList = sl.generate(1);
		for(int i=0;i<resArrayList.size();i++) {
			for(Integer j:resArrayList.get(i)) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
}
