package ch2;

import java.util.Arrays;
import java.util.HashSet;

public class offer03{
/**
 * 数组中重复的数字
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
	//排序法
	public boolean duplicate(int numbers[],int length,int [] duplication) {
		if(numbers==null||numbers.length<=1){
			duplication[0]=-1;
			return false;
		}
		Arrays.sort(numbers);
		for(int i =0;i<length-1;i++) {
			if(numbers[i]==numbers[i+1]) {
				duplication[0] = numbers[i];
				return true;
			}
		}
		return false;
	}
	
	//哈希set
	public boolean duplicateII(int numbers[],int length,int [] duplication) {
		if(numbers==null||numbers.length<=1){
			duplication[0]=-1;
			return false;
		}
		HashSet<Integer> set = new HashSet<>();
		for(int num:numbers) {
			if(set.contains(num)) {
				duplication[0] = num;
				return true;
			}else {
				set.add(num);
			}
		}
		return false;
	}
	
	//抽屉原理
	public boolean duplicateIII(int numbers[],int length,int [] duplication) {
		if(numbers==null||numbers.length<=1){
			duplication[0]=-1;
			return false;
		}

		for(int i=0;i<length;i++) {
			while(numbers[i]!=i) {
				if(numbers[i]==numbers[numbers[i]]) {
					duplication[0] = numbers[i];
					return true;
				}
				int tmp = numbers[i];
				numbers[i] = numbers[tmp];
				numbers[tmp] = tmp;
			}
		}
		return false;
	}
}
