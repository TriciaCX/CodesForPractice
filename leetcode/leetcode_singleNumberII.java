package LeetCode;

public class leetcode_singleNumberII
{
	/*
	 * Given an array of integers, every element appears three times except for one. Find that single one.
	 */

	/*
	 * Single Number的本质，就是用一个数记录每个bit出现的次数，如果一个bit出现两次就归0，这种运算采用二进制底下的位操作^是很自然的。
	 * Single Number II中，如果能定义三进制底下的某种位操作，也可以达到相同的效果，
	 * https://www.cnblogs.com/bjwu/p/9323808.html
	 */
	public int singleNumber(int[] A) {
        int a = 0 , b = 0;
        for(int c : A){
            int ta,tb;
            ta = a;
            tb = b;
            a = (ta&(~tb)&(~c))|((~ta)&tb&c);
            b = ~ta&((~c&tb)|(~tb&c));
        }
        return a|b;
    }

}
