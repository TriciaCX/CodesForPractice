package LeetCode;

import java.util.ArrayList;

public class leetcode_pascalsTriangle
{
	/*
	 * pascals-triangle
	 * Given numRows, generate the first numRows of Pascal's triangle.
	 */
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
    	
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(numRows==0) return res;
        
        
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        res.add(list1);
        if(numRows==1) return res;
        
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(1);
        res.add(list2);
        if(numRows==2) return res;
        
        int preM = 0;
        ArrayList<Integer> preList = new ArrayList<>();
       
        if(numRows>2) {
        	 for(int i=2;i<numRows;i++) { 
        	    ArrayList<Integer> temp = new ArrayList<>();
        		preList = res.get(i-1);
        		temp.add(1);
             	for(int j=1;j<=i-1;j++) {
             	   preM = preList.get(j-1)+preList.get(j);
             	   temp.add(j, preM);
             	}
             	temp.add(1);
              res.add(temp);
             }
        	
        }  
        return res;
    }
}
