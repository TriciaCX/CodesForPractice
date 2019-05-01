package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class leetcode_maxPoints
{
	/*
	 * Given n points on a 2D plane, 
	 * find the maximum number of points that lie on the same straight line.
	 */
	 public int maxPoints(Point[] points) {
	   if(points == null||points.length<2) return points.length;
	  
	   int res = 0;
	   for(int i = 0;i<points.length;i++) {
	      int dup=1,ver =0;
	      Map<Float, Integer> map = new HashMap<Float, Integer>();
	      Point aPoint = points[i];
	      
	      for(int j = i+1;j<points.length;j++) {

	          Point bPoint = points[j];
	          if(aPoint.x==bPoint.x) {
	               if(aPoint.y==bPoint.y) {
	                   dup++;
	               }else {
	            	   ver++;
	               }
	          }else {
	        	  float k = (float)(aPoint.y-bPoint.y)/(aPoint.x-bPoint.x);
	        	  if(k==0) k=0;
	        	  if(map.containsKey(k)) {
	        		  map.put(k, map.get(k)+1);
	        	  }else {
	        		  map.put(k, 1);
	        	  }
	          }  
	      }
	      int max = ver;
          for(float k:map.keySet()) {
             max = Math.max(max, map.get(k));
          }
          res = Math.max(res, max+dup);
	   }
	   return res;
	}
	
}
