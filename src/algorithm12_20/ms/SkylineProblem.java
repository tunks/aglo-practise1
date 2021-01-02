package algorithm12_20.ms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * 
 * https://leetcode.com/problems/the-skyline-problem/ 
 **/
public class SkylineProblem {
	 class BPoint{
	        public int x;
	        public int height;
	        public int side = 0; //defaut: 0 -> left side, 1 right side
	       
	        public BPoint(int x, int height)
	        {
	            this(x,height,0);
	        }
	         public BPoint(int x, int height, int side){
	            this.x = x;
	            this.height = height;
	            this.side =  side;
	         }
	        
	        public String toString(){
	            return "[x: "+x+", height: "+height+", side: "+side+"]";
	        }
	    }
	    public List<List<Integer>> getSkyline(int[][] buildings) {
	      //Store all the right, 
	      //left sides and heights of the building as separate points
	      List<BPoint> points = new ArrayList<BPoint>();
	        //[0] => x, x[1] => height, x[2]= {0 -> left side, 1 right side} 
	      for(int[] b : buildings){
	          points.add(new BPoint(b[0],b[2])); //add building left side
	          points.add(new BPoint(b[1],b[2],1)); //add building right side 
	      }
	      //sorting the building points
	      Collections.sort(points,(a,b)->{
	          //when x coodinates are same, then compare the heights
	          if(a.x == b.x)
	          {
	             //check left side
	            return (((a.side == 0)? -a.height: a.height) - 
	                    ((b.side == 0)? -b.height: b.height));
	          }
	          return a.x- b.x;
	      });
	        
	      List<List<Integer>> results = new ArrayList<List<Integer>>();
	      
	      TreeMap<Integer,Integer> mapHeap = new TreeMap<Integer,Integer>();
	      mapHeap.put(0,1);
	      
	      for(BPoint point: points){
	         int prevMaxHeight = mapHeap.isEmpty()? 0: mapHeap.lastKey();
	         if(point.side == 0){
	            mapHeap.put(point.height, mapHeap.getOrDefault(point.height, 0 ) + 1);   
	         } 
	         else{
	             mapHeap.put(point.height, mapHeap.getOrDefault(point.height,0) - 1);  
	             if(mapHeap.get(point.height)<=0){
	                mapHeap.remove(point.height);
	             }
	         }
	          
	          int currentMaxHeight = mapHeap.isEmpty()? 0: mapHeap.lastKey();
	          if(prevMaxHeight != currentMaxHeight){
	             List<Integer> list = new ArrayList<Integer>();
	             list.add(point.x);
	             list.add(currentMaxHeight);
	             results.add(list);
	          }
	      }  
	        
	      return results;   
	    }
}
