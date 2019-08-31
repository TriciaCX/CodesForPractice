package forOffer;

public class offer16 {
    /***
     * 数值的整数次方
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * 保证base和exponent不同时为0
     */
    public double Power(double base, int exponent) {
        if(base==0)
            return  0;
        if(exponent==0)
            return 1;

        double res =1;
        if(exponent<0){
            exponent = -exponent;
            while(exponent!=0){
                res*=base;
                exponent--;
            }
            return 1/res;
        }else{
            while(exponent!=0){
                res*=base;
                exponent--;
            }
            return res;
        }
    }
}
