package forOffer;

import java.util.ArrayList;
import java.util.HashMap;

public class offer56 {
    /**
     * 数组中只出现一次的数字
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
     */
    //方法一：hashmap 空间复杂度O(n)
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i:array){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i:map.keySet()){
            if(map.get(i)==1){
                list.add(i);
            }
        }
        num1[0] = list.get(0);
        num2[0] = list.get(1);
    }

    //方法二：异或
    // 两个不相等的元素在位级表示上必定会有一位存在不同，将数组的所有元素异或得到的结果为不存在重复的两个元素异或的结果。
    //diff &= -diff 得到出 diff 最右侧不为 0 的位，也就是不存在重复的两个元素在位级表示上最右侧不同的那一位，利用这一位就可以将两个元素区分开来。
    public static void main(String[] args) {
        int[] array = {2,4,3,2};
        int num1[] = new int[1];
        int num2[] = new int[1];
        FindNumsAppearOnceII(array,num1,num2);
        System.out.println(num1[0] +" "+num2[0]);
    }
    public static void FindNumsAppearOnceII(int [] array,int num1[] , int num2[]) {
        int diff =0; //记录两个只出现一次的数字的异或结果（出现两次的数字会在异或中抵消）
        for(int num:array){
            diff ^= num;
        }
        diff &= -diff; //得到出 diff 最右侧不为 0 的位，也就是不存在重复的两个元素在位级表示上最右侧不同的那一位，利用这一位就可以将两个元素区分开来。
        for(int num:array){
            if((num & diff)==0)
                num1[0] ^=num;
            else
                num2[0] ^=num;
        }
    }
}
