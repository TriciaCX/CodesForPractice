package 字节;

import java.util.ArrayList;

public class ReorderArray
{
	/**
	 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
	 * @param array
	 */
	public void reOrderArray(int [] array) {
		int len = array.length;
		ArrayList<Integer> oddList = new ArrayList<>();
		ArrayList<Integer> evenList = new ArrayList<>();
		for(int i=0;i<len;i++) {
			if(array[i]%2==0) {
				evenList.add(array[i]);
			}else {
				oddList.add(array[i]);
			}
		}
		
		for(int i=0;i<oddList.size();i++) {
			array[i] =oddList.get(i);
		}
		for(int i=0;i<evenList.size();i++) {
			array[i+oddList.size()] = evenList.get(i);
		}
	}
}
