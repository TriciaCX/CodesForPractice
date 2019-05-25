package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class leetcode_4Sum
{
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
       
        if(num==null||num.length==0) return res;
        Arrays.sort(num);
       
        for(int i=0;i<num.length-3;i++) {
             for(int j=i+1;j<num.length;j++) {
            	int sum = target-num[i]-num[j];
            	int left = j+1;
            	int right = num.length-1;
            	while(left<right) {
            		while(left<right && num[left]+num[right]>sum) {
            		    right--;
            		}
            		if(left==right)
            			break;
            		if(num[left]+num[right]==sum) {
            			ArrayList<Integer> temp = new ArrayList<>();
            			temp.add(num[i]);
            			temp.add(num[j]);
            			temp.add(num[left]);
            			temp.add(num[right]);
            			res.add(temp);
            			while(left<right && num[left]==num[left+1]) {
            				left++;
            			}
            		}
            		left++;
            	}
            	while(j<num.length-1 && num[j]==num[j+1]) {
            		j++;
            	}
             }
             while(i<num.length-1&&num[i]==num[i+1]) {
            	 i++;
             }
        }
        
        return res;
    }
}
