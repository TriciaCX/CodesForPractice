package vivo;

import java.util.Scanner;

public class vivo0604_3
{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String  capacity = in.nextLine();
		String prices = in.nextLine();
		String hots = in.nextLine();
		//重量限制
		int c=Integer.valueOf(capacity);
		String[] price = prices.split(" ");
		//重量
		int[] p = new int[price.length];
		String[] hot = hots.split(" ");
		//价值
		int[] h = new int[hot.length];
		for (int i = 0; i < hot.length; i++) {
			p[i] = Integer.valueOf(price[i]);
			h[i] = Integer.valueOf(hot[i]);
		}
		//背包问题
		int ans = knapsack(p, h,c );
		System.out.println(ans);
	}

	public static int knapsack(int[] weight, int[] value, int maxweight) {
		int n = weight.length;
		int[][] maxvalue = new int[n + 1][maxweight + 1];

		//i:目前拿了i件物品
		//j:目前还能放下的重量为
		//n:一共有几件物品
		for(int i=1;i<=n;i++){
			for (int j = 1; j <= maxweight; j++) {
				maxvalue[i][j]=maxvalue[i-1][j];
				//还能放
				if(weight[i-1]<=j){
					if(maxvalue[i-1][j - weight[i-1]] + value[i-1]>maxvalue[i][j]) {
						maxvalue[i][j] = maxvalue[i-1][j - weight[i-1]] + value[i-1];
					}
				}

			}

		}
		return maxvalue[n][maxweight];

	    }


	
}
