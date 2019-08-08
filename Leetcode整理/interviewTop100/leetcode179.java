package interviewTop100;

import java.util.Arrays;
import java.util.Comparator;

public class leetcode179
{
	/**
	 * 最大数
	 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
示例 1:
输入: [10,2]
输出: 210
示例 2:
输入: [3,30,34,5,9]
输出: 9534330
说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
	 */
	
	//自定义s1+s2的大小排序
	 public String largestNumberII(int[] nums) {
		 //转换为String数组
		 String[] strings = new String[nums.length];
		 for(int i=0;i<nums.length;i++) {
			 strings[i]=String.valueOf(nums[i]);
		 }
		 //重写排序方法
		 Arrays.sort(strings,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2){
				return -(o1+o2).compareTo(o2+o1); //逆序排列哦
			}
		});
		 //拼接一下就行
		 if(strings[0].equals("0")) return "0";
		 String res = "";
		 for(String s:strings) {
			 res+=s;
		 }
		 return res;
	 }
	
	//快排
	public String largestNumber(int[] nums) {
        nums = sort(nums,0,nums.length-1);
        if(nums[0]==0)
        	return "0";
        
        String res = "";
        for(int i:nums) {
        	res+="i";
        }
        return res;
	}

	private int[] sort(int[] nums, int start, int end){
		int op = nums[(start+end)/2];
		int i = start;
		int j = end;
		while(i<j) {
			while(i<j && compare(nums[j],op)<0) {
				j--;
			}
			while(i<j && compare(op,nums[i])<0) {
				i++;
			}
			if(i<j && compare(nums[i],nums[j])==0) {
				i++;
			}else {
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
			}
		}
		if (i - 1 > start) {
            nums = sort(nums, start, i - 1);
        }

        if (j + 1 < end) {
            nums = sort(nums, j + 1, end);
        }

        return nums;
	}

	private int compare(int a, int b){
		return (a+""+b).compareTo(b+""+a);
	}
}
