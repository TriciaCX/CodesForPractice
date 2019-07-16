package interviewTop100;

public class leetcode204
{
/**
 * 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
示例:
输入: 10
输出: 4
解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 
 */
	/*
	 * 厄拉多塞筛法
介绍：改算法在寻找素数时，采用了一种与众不同的方法：先将 2－N 的各数放入表中，然后在 2 的上面画一个圆圈，然后划去 2 的其他倍数；
第一个既未画圈又没有被划去的数是 3，将它画圈，再划去 3 的其他倍数；
现在既未画圈又没有被划去的第一个数是 5，将它画圈，并划去5的其他倍数……
依次类推，一直到所有小于或等于N的各数都画了圈或划去为止。
这时，表中画了圈的以及未划去的那些数正好就是小于 N 的素数。
普通方法会出现超时，所以只能以空间换时间，采用一个数组来进行标记是否是质数。
	 */
	
	public int countPrimes(int n) {
		boolean[] flags = new boolean[n];
		for(int i=2;i<flags.length;i++) { //首先全部初始化为true 
			flags[i] = true;
		}
		for(int i=2;i*i<flags.length;i++) {
			if(flags[i]) {
				for(int j = i*i;j<flags.length;j+=i) {
					flags[j] = false;
				}
			}
		}
		
		int cnt =0;
		for(boolean b:flags) {
			if(b)
				cnt++;
		}
		return cnt;
	}
}
