package interviewTop100;

import java.util.HashMap;
import java.util.Map;

public class leetcode149
{
/**
 * 直线上最多的点数
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。

示例 1:
输入: [[1,1],[2,2],[3,3]]
输出: 3
解释:
^
|
|        o
|     o
|  o  
+------------->
0  1  2  3  4


示例 2:
输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
输出: 4
解释:
^
|
|  o
|     o        o
|        o
|  o        o
+------------------->
0  1  2  3  4  5  6

 */
	
	/**
	 * 固定一点, 找其他点和这个点组成直线, 统计他们的斜率!
	 * 这里有一个重点: 求斜率.用两种方法
	 * 用最大约数方法(gcd), 把他化成最简形式, 3/6 == 2/4 == 1/2
	 * 除数(不太精确, 速度快!)
	 */
	public int maxPoints(int[][] points) {
       int n = points.length;
       if(n==0) return 0;
       if(n==1) return 1;
       int res = 0;
       
       for(int i=0;i<n-1;i++) {
    	  Map<String, Integer> slope = new HashMap<>();
    	  int repeat = 0;
    	  int tmp_max = 0;
    	  for(int j=i+1;j<n;j++) {
    		  int dy = points[i][1] - points[j][1];
    		  int dx = points[i][0] - points[j][0];
    		  if(dy==0 && dx==0) {
    			  repeat++; //用于记录重复的点
    			  continue;
    		  }
    		  
    		  //最大公约数代替直接用除法求斜率
    		  int g = gcd(dy,dx);  
    		  if(g!=0) {
    			  dy/=g;
    			  dx/=g;
    		  }  		  
    		  String tmp = String.valueOf(dy)+"/"+String.valueOf(dx);
      		  
    		  slope.put(tmp,slope.getOrDefault(tmp, 0)+1);
    		  tmp_max = Math.max(tmp_max, slope.get(tmp));
    	  }
    	  res = Math.max(res, repeat+tmp_max+1);
       }
       return res;
	}

	//欧几里德算法又称辗转相除法，是指用于计算两个正整数a，b的最大公约数。应用领域有数学和计算机两个方面。计算公式gcd(a,b) = gcd(b,a mod b)。
	private int gcd(int dy, int dx){
        return dx==0? dy:gcd(dx, dy%dx);
	}
}