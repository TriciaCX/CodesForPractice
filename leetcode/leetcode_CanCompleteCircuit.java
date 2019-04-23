package LeetCode;

public class leetcode_CanCompleteCircuit
{
	/**
	 * There are N gas stations along a circular route, where the amount of gas at station i isgas[i].
	 * You have a car with an unlimited gas tank and it costs cost[i]of gas to travel from station i to its next station (i+1). 
	 * You begin the journey with an empty tank at one of the gas stations.
	 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
	 * The solution is guaranteed to be unique.
	 */

	/*
	 * 方法一：
	 * 先计算，每个站res = gas-cost的值，求和，如果小于0则说明不可达
	 * 从头开始当发现res >0 ,则开始计算res的和sum，如果sum<0时，则继续往后找res>0的位置，在继续计算sum值
	 * （此思路的依据就是一定有唯一值，且只会从res>0的位置开始）
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if(gas.length<1||cost.length!=gas.length) return -1;
		int len = gas.length;
		int[] res = new int[len];
		int sumres = 0;

		for(int i=0;i<len;i++) {
			res[i] = gas[i] - cost[i];
			sumres+=res[i];
		}

		if(sumres<0) return -1;

		int j = 0;

		for(int i=0;i<len;i++) {
			j=(i+1)%len;
			int sum = res[i];
			while(j!=i) {
				if(sum < 0) break;
				sum = sum + res[j];
				j = (j+1)%len;
			}

			if(j==i) return i;
		}
		return -1;
	}
}
