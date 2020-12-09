package algorithm11_20.google.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        Map<Integer,Set<Integer>> map = new HashMap<Integer,Set<Integer>>();
        //store the x cordinates in Hash as key, y points as Set values for lookup
        // x=1 --> y {1,3}
        // x=3 --> y {1,3}
        // x=2 --> y{2}
        for(int[] point: points){
            map.computeIfAbsent(point[0], p -> new HashSet<Integer>()).add(point[1]);
        }
    
        int minArea = Integer.MAX_VALUE;
        for(int[] pointA: points){
            for(int[] pointB: points){
                //if the two points are similar , then skip
                if(pointA[0] == pointB[0] || pointA[1] == pointB[1])
                  continue;
                //if the two points do not have corresponding points , then skip
                if(!map.get(pointA[0]).contains(pointB[1]) || 
                   !map.get(pointB[0]).contains(pointA[1]))
                    continue;
                //get the absolution area difference
               int area = Math.abs(pointA[0]- pointB[0]) * Math.abs(pointA[1]- pointB[1]);
                minArea = Math.min(area,minArea);  
            }
            
        }
        //if there is no min rectange, then return 0, else return the min area
        return minArea == Integer.MAX_VALUE? 0: minArea ;
    }
}
