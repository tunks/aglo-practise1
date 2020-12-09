package algorithm06_20;

import java.util.*;

import javafx.util.Pair;

/*
 * https://leetcode.com/problems/number-of-islands/
 * 
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * **/
public class NumberofIslands {
    public int numIslands(char[][] grid) {
        Queue<Pair<Integer,Integer>> queue = new LinkedList<Pair<Integer,Integer>>();
        
        for(int i = 0;i < grid.length; i++){
            for(int j =0; j< grid[i].length; j++){
                if(grid[i][j] == '1'){
                   queue.offer(new Pair<>(i,j));
                }
            }
        }
        int count = 0;
        
        int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
       Queue<Pair<Integer,Integer>> island = 
           new LinkedList<Pair<Integer,Integer>>();

        while(!queue.isEmpty()){
            Pair<Integer,Integer> pair = queue.poll();
            island.offer(pair);
            boolean marked = false;
            while(!island.isEmpty()){
                pair = island.poll();
                int nr = pair.getKey();
                int nc = pair.getValue();
                for(int[] d: directions){
                    int r = nr + d[0];
                    int c = nc + d[1];
                    if( r< 0 || r >= grid.length || c < 0 || c >= grid[r].length){
                        continue;
                    }
                    if(grid[r][c] == '1'){
                       grid[r][c] = '2';
                       island.offer(new Pair<>(r,c));
                       marked = true;
                    }
                }
                if(!marked &&  grid[nr][nc] == '1'){
                    marked = true;
                }
            }
            if(marked){
               count ++;
            }
        }
        return count;
    }
}