package vivo;

import java.util.HashSet;

public class vivo0604_1
{
	/**
	 * 有两个整型数组A和B，要求找出A有而B没有的元素，要求保持原顺序
	 */
    public static void main(String[] args)
	{       
    	int[] A= {1,2,3,5};
    	int[] B= {2,3,4};
 	    HashSet<Integer> setB = new HashSet<>();
	    for(int i=0;i<B.length;i++) {
	    	setB.add(B[i]);
	    }
	    for(int i=0;i<A.length;i++) {
	       if(!setB.contains(A[i])) {
	    	   System.out.print(A[i]+" ");
	       }
	    }
	}
}
