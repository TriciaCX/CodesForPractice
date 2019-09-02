package forOffer;

import java.util.ArrayList;
import java.util.Arrays;

public class offer21 {
    /**
     * 调整数组顺序使奇数位于偶数前面
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     */

    public static  void main(String []args){
        int[] array = {1,3,2,4,5,5,6,8};
        reOrderArray(array);
        for(int i:array){
            System.out.print(i+" ");
        }
        System.out.println();
        bubbleSort(array);
        for(int i:array){
            System.out.print(i+" ");
        }
    }

    //辅助空间
    public static void reOrderArray(int [] array) {
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        for(int i=0;i<array.length;i++){
            if(array[i]%2==1){
                odd.add(array[i]);
            }else{
                even.add(array[i]);
            }
        }
        int index = 0;
        for(int i=0;i<odd.size();i++){
            array[index++] = odd.get(i);
        }
        for(int j=0;j<even.size();j++){
            array[index++] =even.get(j);
        }
    }

    //冒泡
    public void reOrderArrayI(int [] array) {
        int n = array.length;
        for(int i=n-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(array[j]%2==0 && array[j+1]%2!=0){
                    int tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    //原版的冒泡
    public static void bubbleSort(int[] array){
        int n = array.length;
        for(int i=n-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(array[j]>array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
    }
}
