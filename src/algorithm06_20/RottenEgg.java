package algorithm06_20;

import java.util.*;

/*
 * 
 * In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

 
 * */
public class RottenEgg {
   class Node {
        int i;
        int j;
        public Node(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    
    public int orangesRotting(int[][] grid) {
        Queue<Node> queue = new LinkedList<Node>();
        int rows = grid.length;
        int cols = grid[0].length;
        int freshOranges = 0;
        for(int i = 0; i< rows; i++){
            for (int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                  freshOranges ++;   
                }
                else if(grid[i][j] == 2){
                  queue.offer(new Node(i,j));
                }
            }
            
        }
               

        if(freshOranges == 0){
            return 0;
        }
        
        int hours = -1;
        int size = 0;
        Node node;
        int[][] directions = {{1,0}, {0,1},{-1,0}, {0,-1}};
        while(!queue.isEmpty()){
            size = queue.size();
            hours++;
            for(int i = 0; i< size; i++){
                node = queue.poll();
                for (int d[] : directions){
                    int r = node.i + d[0];
                    int c = node.j + d[1];
                    if(r < 0 || r >= rows || c<0 || c>= cols){
                        continue;
                    }
                    
                    if(grid[r][c] == 1){
                        grid[r][c] = 2;
                        queue.offer(new Node(r,c));
                        freshOranges--;
                    }
                }
            }
        }
        return (freshOranges == 0)? hours : -1;
    }
}