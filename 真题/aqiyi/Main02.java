package enterprise.aqiyi;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main02 {
    /**
     * dp[i][j]表示i个红球和j个蓝球A的获胜概率.如果i=0,dp[i][j]=0.如果j=0,dp[i][j]=1.否则的话dp[i][j]由下列步骤求得:
     * dp[i][j]+=i/(i+j);//表示A直接取得红球的概率
     * 如果j=1,那么dp[i][j]+=0.A取蓝球之后,B肯定获胜
     * 如果j=2,dp[i][j]+=j/(i+j)*(j-1)/(i+j-1)*dp[i-1][j-2];j/(i+j)是A取蓝球的概率,在A取蓝球的基础上B再取蓝球A才有获胜机会,所以(j-1)/(i+j-1)表示B再取蓝球的概率,然后C只能从红球选一个,在ABC选一轮后,A的获胜概率就要加上dp[i-1][j-2],所以A获胜的概率为j/(i+j)*(j-1)/(i+j-1)*dp[i-1][j-2];
     * 如果j>2,dp[i][j]+=j/(i+j)*(j-1)/(i+j-1)*(i/(i+j-2)*dp[i-1][j-2]+(j-2)/(i+j-2)*dp[i][j-3]);i/(i+j-2)*dp[i-1][j-2]+(j-2)/(i+j-2)*dp[i][j-3]表示A从蓝球选一个,B从蓝球选一个后,C分别从红球蓝球取出一个的A的获胜概率.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int red = scanner.nextInt(); //红球数量
        int blue = scanner.nextInt(); //蓝球数量
        double[][] dp = new double[red+1][blue+1];
        dp[0][0] = 0;
        for(int i=1;i<red+1;i++){
            dp[i][0] = 1; //没有蓝球，红必胜
        }
        for(int i=1;i<red+1;i++){
            for(int j=1;j<blue+1;j++){
                double ii = (double)i;
                double jj = (double)j;
                dp[i][j] += ii/(ii+jj);  //直接取到红色的概率
                if(j==1){
                    dp[i][j] += 0;
                }else if(j==2){
                    dp[i][j] += (jj/(ii+jj)) *((jj-1)/(ii+jj-1)) *dp[i-1][j-2];  //A拿了蓝色，B再拿蓝色，蓝色球拿完了，A再拿到红球就赢了
                }else if(j>2){
                    dp[i][j] += (jj/(ii+jj)) *((jj-1)/(ii+jj-1)) *(ii/(ii+jj-2)*dp[i-1][j-2]+(j-2)/(ii+jj-2)*dp[i][j-3]); //A拿了蓝，B也拿了蓝，C拿了红或蓝，之后A拿到红
                }
            }
        }
        double res = dp[red][blue];
        DecimalFormat decimalFormat = new DecimalFormat("0.00000");
        System.out.println(decimalFormat.format(res));
    }
}
