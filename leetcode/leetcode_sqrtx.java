package LeetCode;

public class leetcode_sqrtx
{
	/**
	 * sqrtx
	 * Implementint sqrt(int x).Compute and return the square root of x.
	 */
	public int sqrtI(int x) {
		long i=1;
		while(i*i<x) {
			i*=2;
		}
		while(i*i>x) {
			i=i-1;
		}
		return (int)i;
	}
	
	//牛顿逼近法
	public int sqrtII(int x){
		long r = x;
		while(r*r>x) {
			r=(r+x/r)/2;
		}
		return (int)r;
	}

}
