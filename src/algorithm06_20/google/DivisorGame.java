package algorithm06_20.google;

/**
 * 
 *  
 *  Alice and Bob take turns playing a game, with Alice starting first.

Initially, there is a number N on the chalkboard.  On each player's turn, that player makes a move consisting of:

Choosing any x with 0 < x < N and N % x == 0.
Replacing the number N on the chalkboard with N - x.
Also, if a player cannot make a move, they lose the game.

Return True if and only if Alice wins the game, assuming both players play optimally.

 

Example 1:

Input: 2
Output: true
Explanation: Alice chooses 1, and Bob has no more moves.
Example 2:

Input: 3
Output: false
Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves. 

https://leetcode.com/problems/divisor-game/
 */
public class DivisorGame {
	public boolean divisorGame(int N) {
	       int aliceMoves = 0;
	       int bobMoves = 0;
	       int i = 0;
	       int x = 1;
	       while(x> 0 && x < N){
	           if (i%2 == 0){  
	               aliceMoves++;  
	           }
	           else{
	            bobMoves++;   
	           }
	           N -= x;
	           i++;
	       } 
	        
	        return aliceMoves > bobMoves;
	    }
}
