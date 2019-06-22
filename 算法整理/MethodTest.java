package 算法;

import java.util.Arrays;

public class MethodTest
{
public static void rightMethod(int[] arr) {
	Arrays.sort(arr);
}
//for test
public static int[] generateRandomArray(int size,int value)
{
	//生成长度随机的数组
	int[] arr = new int[(int)((size+1)*Math.random())];
	for(int i=0;i<arr.length;i++) {
		arr[i] =(int)((value+1)*Math.random())-(int)(value*Math.random());
	}
	return arr;
}

//for test
public static int[] copyArray(int[] arr) {
	if(arr==null) {
		return null;
	}
	return arr;
}

}
