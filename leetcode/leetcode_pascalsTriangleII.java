package LeetCode;

import java.util.ArrayList;

public class leetcode_pascalsTriangleII
{
	/*
	 * pascals-triangle
	 * Given an index k, return the k th row of the Pascal's triangle.
	 * For example, given k = 3,Return[1,3,3,1].
	 * Note: Could you optimize your algorithm to use only O(k) extra space?
	 */
     public ArrayList<Integer> getRow(int rowIndex) {
    	 ArrayList<ArrayList<Integer>> res = new ArrayList<>();
               
         ArrayList<Integer> list1 = new ArrayList<>();
         list1.add(1);
         res.add(list1);
         if(rowIndex==0) return res.get(0);
         
         ArrayList<Integer> list2 = new ArrayList<>();
         list2.add(1);
         list2.add(1);
         res.add(list2);
         if(rowIndex ==1) return res.get(1);
         
         int preM = 0;
         ArrayList<Integer> preList = new ArrayList<>();
        
         if(rowIndex>1) {
         	 for(int i=2;i<=rowIndex;i++) { 
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
         return res.get(rowIndex);
     }
	
}
