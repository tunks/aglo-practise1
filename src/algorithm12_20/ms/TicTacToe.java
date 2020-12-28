package algorithm12_20.ms;

/*
 * 
 * Design Tic-Tac-Toe
Medium

926

66

Add to List

Share
Assume the following rules are for the tic-tac-toe game on an n x n board between two players:

A move is guaranteed to be valid and is placed on an empty block.
Once a winning condition is reached, no more moves are allowed.
A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
Implement the TicTacToe class:

TicTacToe(int n) Initializes the object the size of the board n.
int move(int row, int col, int player) Indicates that player with id player plays at the cell (row, col) of the board. The move is guaranteed to be a valid move.
Follow up:
Could you do better than O(n2) per move() operation?

 

Example 1:

Input
["TicTacToe", "move", "move", "move", "move", "move", "move", "move"]
[[3], [0, 0, 1], [0, 2, 2], [2, 2, 1], [1, 1, 2], [2, 0, 1], [1, 0, 2], [2, 1, 1]]
Output
[null, 0, 0, 0, 0, 0, 0, 1]

https://leetcode.com/problems/design-tic-tac-toe/
 * */
public class TicTacToe {
	class TicTacToe {
	    //1. Initialize the cols and rows
	    /****
	    x o o
	    x o o
	    x o o
	    
	    o o x
	    x x o 
	    x o o
	    **/
	    private int[] cols;
	    private int[] rows;
	    private int diagonal = 0; //diagonal
	    private int revDiagonal = 0; //reverse diagonal
	    private int size = 0;
	    public TicTacToe(int n) {
	        size = n;
	        cols = new int[n];
	        rows = new int[n];
	    }
	    
	    /** Player {player} makes a move at ({row}, {col}).
	        @param row The row of the board.
	        @param col The column of the board.
	        @param player The player, can be either 1 or 2.
	        @return The current winning condition, can be either:
	                0: No one wins.
	                1: Player 1 wins.
	                2: Player 2 wins. */
	    public int move(int row, int col, int player) 
	    {
	        //2. set the player move to 1 or -1
	        int move = (player == 1)? 1: -1;
	        //3. add the move the current row count
	        rows[row]+= move;
	        //4. add the move the current column count
	        cols[col]+= move;
	        //5. set the diagonal count if row and cols are equals
	        if(row == col){
	           diagonal +=move; 
	        }
	        //6. set the reverse diagram count 
	        if((size - row - 1) == col){
	           revDiagonal +=move;  
	        }
	        //check the current row or column is filled ()
	        if(Math.abs(rows[row]) == size || Math.abs(cols[col]) == size 
	           || Math.abs(diagonal) == size ||  Math.abs(revDiagonal) == size)
	        {
	            return player;
	        }
	            
	         return 0;
	    }
	}

	/**
	 * Your TicTacToe object will be instantiated and called as such:
	 * TicTacToe obj = new TicTacToe(n);
	 * int param_1 = obj.move(row,col,player);
	 */
}
