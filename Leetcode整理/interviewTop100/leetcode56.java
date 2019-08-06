package interviewTop100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class leetcode56
{
	/**
	 * 给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
	 */
	 class interval{
			int a;
			int b;
			
			public interval(int a,int b) {
			   this.a =a;
			   this.b =b;
			}
		}
		
		public class myComparetor implements Comparator<interval>{

			@Override
			public int compare(interval o1, interval o2){
				return o1.a<o2.a?-1:o1.a==o2.a?0:1;
			}
			
		}
		public int[][] merge(int[][] intervals) {
	        ArrayList<interval> list = new ArrayList<>();
	        for(int[] p:intervals) {
	        	interval tmp = new interval(p[0], p[1]);
	        	list.add(tmp);
	        }
	        return mergeCore(list);
		}
		private int[][] mergeCore(ArrayList<interval> list)
		{
			List<int[]> res = new ArrayList<>();
			Collections.sort(list, new myComparetor());
			for(int i=0;i<list.size();i++) {
				int left = list.get(i).a;
				int right = list.get(i).b;
				while(i<list.size()-1 && list.get(i+1).a<=right) {			
					right = Math.max(right, list.get(i+1).b);
	                i++;
				}
				res.add(new int[] {left,right});
			}
			return res.toArray(new int[res.size()][2]);
		}
}
