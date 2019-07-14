package interviewTop100;

import java.util.HashSet;
import java.util.Set;

public class leetcode202
{
	/**
	 * leetcode202
	 * 编写一个算法来判断一个数是不是“快乐数”。
	 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
示例: 
输入: 19
输出: true
解释: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

	 */
	
	
	/*
	 * 到1的时候进入循环（即1，1，1……循环），返回true
到非1的时候进入循环，返回false
因为都会产生循环，直到开始进入循环的点跳出循环，检查开始进入循环的点是否是1，若是1，n就是快乐数，若不是，n就不是快乐数
	 */
	Set<Integer> set = new HashSet<>();
	public boolean isHappy(int n) {
       int res = 0;
       while(n>0) {
    	   int i = n%10;
    	   res += i*i;
    	   n/=10;
       }
       if(set.contains(res))
    	   return false;
       else 
		 set.add(res);
       if(res==1)
    	   return true;
       return isHappy(res);
	}
}
