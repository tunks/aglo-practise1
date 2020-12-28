package algorithm12_20.ms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Battleships in a Board
Medium

860

557

Add to List

Share
Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:
You receive a valid board, made of only battleships or empty slots.
Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
Example:
X..X
...X
...X
In the above board there are 2 battleships.
Invalid Example:
...X
XXXX
...X
This is an invalid board that you will not receive - as battleships will always have a cell separating between them.
Follow up:
Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board?

https://leetcode.com/problems/battleships-in-a-board/ 
 **/
public class BattleshipsBoard {
	 class Cell{
	        public int row;
	        public int col;
	        public Cell(int row, int col){
	            this.row = row;
	            this.col = col;
	        }
	         
	         @Override
	         public String toString(){
	             return "Cell(r: "+row + ", c: "+col +")";
	         }
	    }
	    
	    public int countBattleships(char[][] board) {
	         return countBattleshipsSinglePass(board);
	    }
	    
	    private int countBattleshipsQueue(char[][] board){
	        Queue<Cell> queue = new LinkedList<Cell>();
	        
	        for(int i = 0; i < board.length; i++){
	            for(int j = 0; j < board[i].length; j++){
	                 if(board[i][j] == 'X'){
	                    queue.offer(new Cell(i,j));  
	                 } 
	            }
	        }
	        if(queue.size() == 0 ||  queue.size() == 1){
	           return queue.size(); 
	        }
	        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
	        Cell curr;
	        boolean[][] visits = new boolean[board.length][board[0].length];
	        int count =0;
	        Queue<Cell> ships = new LinkedList<Cell>();
	        while(!queue.isEmpty()){
	            curr = queue.poll();
	            if(visits[curr.row][curr.col])
	            {
	                continue;
	            }
	            ships.offer(curr);
	            visits[curr.row][curr.col] = true;
	            while(!ships.isEmpty()){    
	               Cell cell = ships.poll();
	               for(int[] d: directions){
	                    int r = cell.row + d[0];
	                    int c = cell.col + d[1];
	                    if(c<0 || r<0 || r>=board.length || c>=board[0].length){
	                        continue;
	                    }
	                    if(board[r][c] == 'X' && !visits[r][c]){
	                       visits[r][c]= true;
	                       ships.add(new Cell(r,c)); 
	                    }
	                }
	            }

	            count++;
	            
	        }
	        return count;
	    }
	    
	    public int countBattleshipsSinglePass(char[][] board) {
	        int res = 0;
	        for(int i = 0;i<board.length;i++){
	            for(int j = 0;j<board[0].length;j++){
	                if(board[i][j] == 'X'){
	                    if((i>0 && board[i-1][j] =='X') || (j>0 && board[i][j-1] == 'X'))
	                    {
	                        continue;
	                    }
	                    res++;
	                }
	            }
	        }
	        return res;
	    }
	    
	    /**
	    class Solution {
	    public int countBattleships(char[][] board) {
	        int res = 0;
	        for(int i = 0;i<board.length;i++){
	            for(int j = 0;j<board[0].length;j++){
	                if(board[i][j] == 'X'){
	                    if((i-1>=0 && board[i-1][j] =='X') || (j-1>=0 && board[i][j-1] == 'X')){
	                        continue; // Here the reverse condition is checked as is explained (invalid conditon and we ignore)
	                    }
	                    res++;
	                }
	            }
	        }
	        return res;
	    }
	}
	As we are traversing the matrix row by row, only after visiting each j column of each row we move to next row.

	And as it has been mentioned in the problem statement that the battleships are aligned either in horizontal or vertical positions only, our traversal path being left to right helps solving in single pass.

	We traverse each row from left to right, so we know when the first 'X' is encountered in a row, which is pretty much sufficient to count as a single battleship row. We wont be considering the immediate 'X' to the right of the first encountered 'X' when traversing left to right.

	And regarding vertical positions, as we traverse the array naturally from the 0th row to the last row, we apply the same check for top to bottom as well. Any 'X' that comes immediately below the first encountered 'X' vertically is neglected for the count.

	Any other possible arrangement where horizontal and vertical placements coincide is not allowed as mentioned in the problem statement.
	    */
}
