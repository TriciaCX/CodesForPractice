package 华为;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 明明想在学校中请一些同学一起做一项问卷调查，
 * 为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。
 * 请你协助明明完成“去重”与“排序”的工作(同一个测试用例里可能会有多组数据，希望大家能正确处理)。
 *
 */
public class Moni0604_2
{
	public static void main(String[] args) {
	      Scanner sc= new Scanner(System.in);
	      while(sc.hasNext()) {
	    	  int n=sc.nextInt();
	    	  int[] nums=new int[n];
	    	  for(int i=0;i<n;i++) {
	    		  nums[i] = sc.nextInt();
	    	  }
	    	  HashSet<Integer> set=new HashSet<>();
	          for(int j=0;j<n;j++) {
	             set.add(nums[j]);
	          }
	          ArrayList<Integer> list=new ArrayList<>();
	          for (Integer integer : set)
	    	{
	    		list.add(integer);
	    	}
	          Collections.sort(list);
	          int[] res=new int[list.size()];
	          for(int k=0;k<list.size();k++) {
	        	  res[k]=list.get(k);
	        	  System.out.println(res[k]);
	          }
	          
	    	}
	      }
}
