package algorithm06_20.bloomberg;

import java.util.Stack;

import javafx.util.Pair;

/**
 * 
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
Example 2:

[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.
Note: The length of each dimension in the given grid does not exceed 50.

https://leetcode.com/problems/max-area-of-island/
 * */
public class MaxAreaofIsland {
	 public int maxAreaOfIsland(int[][] grid) {
	        Stack<Pair<Integer,Integer>> stack = new Stack<Pair<Integer,Integer>>();
	        int[][] direction = {{1,0}, {0,1}, {-1,0}, {0,-1}};
	       
	        int maxArea = 0;
	        for(int i = 0; i < grid.length; i++)
	        {
	            for(int j = 0; j< grid[i].length; j++){
	                 if(grid[i][j] == 1){
	                    stack.push(new Pair<>(i,j));
	                 }
	            }
	            
	            Pair<Integer,Integer> pair;
	            int count =  0;
	            while(!stack.isEmpty()){
	              for(int move = 1; move <=  stack.size(); move++){
	                  pair = stack.pop();
	                  if(grid[pair.getKey()][pair.getValue()]  == 1){
	                     count = 1;   
	                  }
	                  
	                  for(int[] d : direction){
	                       int r = d[0] + pair.getKey();
	                       int c = d[1] + pair.getValue();
	                       if(r <0 || r >= grid.length || c< 0 || c >= grid[i].length){
	                          continue;
	                       }
	                       
	                      if(grid[r][c] == 1){
	                         stack.push(new Pair<>(r,c));
	                         grid[r][c] = 2; 
	                         count ++;
	                      } 
	                    }
	                    grid[pair.getKey()][pair.getValue()] = 2;
	                    maxArea = Math.max(count,maxArea);
	                  }  
	         }
	        }
	                     
	 
	        return maxArea;
	    }
}
