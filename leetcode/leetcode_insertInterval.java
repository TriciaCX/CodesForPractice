package LeetCode;

import java.util.ArrayList;

public class leetcode_insertInterval
{
	/**
	 * insert-interval
	 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
	 * You may assume that the intervals were initially sorted according to their start times.
	 * Example 1: Given intervals[1,3],[6,9], insert and merge[2,5]in as[1,5],[6,9].
	 * Example 2: Given[1,2],[3,5],[6,7],[8,10],[12,16], insert and merge[4,9]in as[1,2],[3,10],[12,16].
	 * This is because the new interval[4,9]overlaps with[3,5],[6,7],[8,10].
	 */
	 public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {	
	        ArrayList<Interval> res = new ArrayList<Interval>();
	        int index = 0;
	        while (index < intervals.size() && newInterval.start > intervals.get(index).end)
	            res.add(intervals.get(index++));
	        while (index < intervals.size() && newInterval.end >= intervals.get(index).start) {
	            newInterval=new Interval(
	                    Math.min(newInterval.start, intervals.get(index).start),
	                    Math.max(newInterval.end, intervals.get(index).end));
	            index++;
	        }
	        res.add(newInterval);
	        while (index < intervals.size())
	            res.add(intervals.get(index++));	         
	        return res;
	    }
}
