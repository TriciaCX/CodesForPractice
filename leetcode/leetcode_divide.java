package LeetCode;

public class leetcode_divide
{
	/*
	 * divide-two-integers
	 * Divide two integers without using multiplication, division and mod operator.
	 */
	public int divide(int dividend, int divisor) {       
        if(dividend ==  Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        
        boolean isNeg = (dividend < 0) ^ (divisor < 0);  //^异或运算，判断被除数和除数是否符号相反
        if(dividend > 0) dividend = -dividend; //取负
        if(divisor > 0) divisor = -divisor;
           
        return isNeg? -div(dividend, divisor) : div(dividend, divisor); //一正一负就改变符号
    }
	
    public int div(int dividend, int divisor){
        if(dividend > divisor) return 0;
        int curSum = divisor << 1, prevSum = divisor, q = 1;
        
        while(dividend <= curSum && curSum < prevSum){
            prevSum = curSum;
            curSum <<= 1; q <<= 1;
        }
        return q + div(dividend - prevSum, divisor);
    }
}
