package algorithm12_20.jp;

import java.util.LinkedList;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.Queue;

/**
 * 
 * Given N X N matrix filled with 1, 0, 2, 3. Find whether there is a path possible from source to destination, traversing through blank cells only. You can traverse up, down, right, and left. 
 

    A value of cell 1 means Source.
    A value of cell 2 means Destination.
    A value of cell 3 means Blank cell.
    A value of cell 0 means Blank Wall.

Note: there are an only a single source and single destination(sink).

Example 1:
M[3][3] = {{ 0, 3, 2 }, 
		   { 3, 3, 0 }, 
		   { 1, 3, 0 }}; 
Output : Yes

https://www.geeksforgeeks.org/find-whether-path-two-cells-matrix/  
 */
public class PathBetweenTwoPoints {
     
	public static boolean pathExists(int[][] points) {
    	 Queue<Entry<Integer,Integer>> queue = new LinkedList<Entry<Integer,Integer>>();
    	 for(int i =0; i< points.length; i++) {
    		 for(int j =0; j < points[i].length; j++) {
    			 if(points[i][j] == 1) {
    				 queue.add(new SimpleEntry<Integer,Integer>(i,j)); 
    			 }
    		 }
    	 }
    	 Entry<Integer,Integer> entry;
    	 int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    	 while(!queue.isEmpty()) {
    		   entry =  queue.poll();
    		   int row = entry.getKey();
    		   int col = entry.getValue();
    		   for(int[]dir: directions) {
    			    int r = dir[0] + row;
    			    int c = dir[1] + col;
    			    if(r>=points.length || r < 0 || c>=points[r].length || c<=0) 
    			    {
    			    	continue;
    			    }
    			    
    			    if(points[r][c] == 3) 
    			    {
    			        queue.add(new SimpleEntry<Integer,Integer>(r,c));
    			    	points[r][c] = -3;
    			    }   
    			    else if(points[r][c] == 2) 
    			    {
					    return true;			    	
					} 			    
    		   }
    	 }
    	 
    	 return false;
     }
	
	public static void main(String[] arg) {
		int[][] points = {{ 0, 3, 2 }, 
						  { 3, 3, 0 }, 
						  { 1, 3, 0 }}; 
		boolean result = pathExists(points);
		System.out.println("Path exists: "+result);
	}
}
