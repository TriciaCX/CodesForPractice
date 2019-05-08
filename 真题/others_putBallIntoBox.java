package others;

import java.util.Arrays;

public class others_putBallIntoBox
{


	public void getBalls(int n,int k) {	
		int []r = new int[k];
		f(r,0,n,k);
	}
	private void f(int[] r, int p, int n, int k)
	{
		if(k==1) {
			r[r.length-1] = n;
			System.out.println(Arrays.toString(r));
			r[r.length-1] = 0;
		}else {
			for(r[p]=0;r[p]<=n;++r[p]) {
				f(r, p+1, n-r[p], k-1);
			}
		}

	}


}

