package forOffer;

public class offer17 {
    /**
     * 打印从 1 到最大的 n 位数
     *  输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。
     */
    public static void main(String[] args){
        int n=2;
        print1ToMaxOfDigits(n);
    }

    //由于 n 可能会非常大，因此不能直接用 int 表示数字，而是用 char 数组进行存储。
    //使用回溯法得到所有的数
    public static void print1ToMaxOfDigits(int n){
        if(n<=0)
            return;
        char[] num = new char[n];
        print1ToMaxOfDigitsCore(num,0);
    }

    private static void print1ToMaxOfDigitsCore(char[] num, int digit) {
        if(digit>=num.length) {
            printNumber(num);
            return;
        }
        for(int i=0;i<10;i++){
            num[digit] = (char) (i+'0');
            print1ToMaxOfDigitsCore(num,digit+1);
        }
    }

    public static void printNumber(char[] num){
        int idx =0;
        while(idx<num.length && num[idx]=='0')
            idx++;
        while (idx<num.length)
            System.out.print(num[idx++]);
        System.out.println();
    }
}
