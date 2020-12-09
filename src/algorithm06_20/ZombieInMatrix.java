package algorithm06_20;

import java.util.LinkedList;
import java.util.Queue;

public class ZombieInMatrix {
    /*
     * Given a 2D grid, each cell is either a zombie 1 or a human 0. 
     * Zombies can turn adjacent (up/down/left/right) human beings into zombies every hour.
     *  Find out how many hours does it take to infect all humans?
     *  Input:
[[0, 1, 1, 0, 1],
 [0, 1, 0, 1, 0],
 [0, 0, 0, 0, 1],
 [0, 1, 0, 0, 0]]

Output: 2

Explanation:
At the end of the 1st hour, the status of the grid:
[[1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1],
 [0, 1, 0, 1, 1],
 [1, 1, 1, 0, 1]]

At the end of the 2nd hour, the status of the grid:
[[1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1]]
     * **/
	
	class Node{
		int i;
		int j;
	    
		public Node(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
	
	public int countHours(int[][] grid) {
		Queue<Node> queue = new LinkedList<Node>();
		for(int i = 0; i< grid.length; i++) {
			 for(int j = 0; j < grid[i].length; j++) {
				 if (grid[i][j] == 1) {
					 queue.offer(new Node(i,j)); 
				 }
			 }
		}
		
		//left = -1, right = 1, top = -1, down = 1
	    int[][] directions = {{1,  0}, {-1, 0}, {0,  1}, {0,  -1}};
	    Node node = null;
	    int hours = -1;
	    int qSize = 0;
		while(!queue.isEmpty()) {
			qSize = queue.size();
			for(int i = 0; i < qSize; i++) {
				node = queue.poll();
				for(int d[]: directions) {
					int r =  node.i + d[0];
					int c =  node.j + d[1];
					if(r >= 0 && r < grid.length 
							&& c>=0 && c<grid[r].length 
							&& grid[r][c] == 0) {
						grid[r][c] = 1;
						queue.offer(new Node(r,c));
					}
				}
			}
			
			   hours++;
		}
		
		return hours;
	}
	public static void main(String[] args) {
		int [][] grid = {{0, 1, 1, 0, 1},
		                 {0, 1, 0, 1, 0},
		                 {0, 0, 0, 0, 1},
		                 {0, 1, 0, 0, 0}};
		ZombieInMatrix matrix = new ZombieInMatrix();
		System.out.println("Start Count hours");
		int hours = matrix.countHours(grid);
		System.out.println("Count hours: "+hours);
	}

}
