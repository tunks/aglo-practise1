package algorithm12_20.ms;

/**
 * 
 * Word Search
 * Given an m x n board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where "adjacent" cells are horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false

 https://leetcode.com/problems/word-search/
 **/
public class WordSearch {
	  public boolean exist(char[][] board, String word) {
	        for(int i =0; i< board.length; i++){
	            for(int j =0; j< board[0].length; j++){
	                if(wordExists(board,i,j,word,0)){
	                   return true;  
	                }
	            }
	        }
	        return false;
	    }
	    
	    private boolean wordExists(char[][] board, int row, int col, String word, int index){
	        if(index>= word.length()){
	            return true; 
	         }
	        else if(row<0 || row>=board.length || col<0 || col>=board[0].length
	               || board[row][col] != word.charAt(index))
	        {
	           return false;
	        }
	        else {
	            int[][] directions = {{0, 1}, {1,0}, {-1,0},{0,-1}};
	            board[row][col] = ' ';
	            boolean result = false;
	            for(int[] d: directions){
	                result = wordExists(board,row + d[0], col + d[1],word,index+1);
	                if(result)
	                {
	                  break;  
	                }
	            }
	            board[row][col] = word.charAt(index);
	            return result;
	        }
	    }
}


/*
 * Time Complexity: O(N⋅3^L)
 ) where NN is the number of cells in the board and LL is the length of the word to be matched.

For the backtracking function, initially we could have at most 4 directions to explore, but further the choices are reduced into 3 (since we won't go back to where we come from). 
As a result, the execution trace after the first step could be visualized as a 3-ary tree, each of the branches represent a potential exploration in the corresponding direction. Therefore, in the worst case, the total number of invocation would be the number of nodes in a full 3-nary tree, which is about 3^L3 
L
 .

We iterate through the board for backtracking, i.e. there could be NN times invocation for the backtracking function in the worst case.

As a result, overall the time complexity of the algorithm would be  O(N⋅3^L)

Space Complexity: O[L] where LL is the length of the word to be matched.

The main consumption of the memory lies in the recursion call of the backtracking function. The maximum length of the call stack would be the length of the word. Therefore, the space complexity of the algorithm is \mathcal{O}(L)O(L)
 * */
