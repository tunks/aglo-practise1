package algorithm12_20.jp;

/**
 * 
 * https://leetcode.com/problems/dungeon-game/ 
 */
public class DungeonGame {
	  public int calculateMinimumHP(int[][] dungeon) 
	    { 
	        int rows = dungeon.length - 1;
	        int cols = dungeon[0].length - 1;
	        int[][] dp = dungeon;
	        //DP top down approach
	        //set the Princess max health value => 1 or (1-current if negative value) 
	        dungeon[rows][cols] = Math.max(1, 1- dungeon[rows][cols]);
	       
	        //set the right most row
	         //Compute the health values the rows in the right most column 
	         //from the Princess
	        for(int r = rows-1; r >=0; r--){
	            dungeon[r][cols] = Math.max(1,dungeon[r+1][cols]-dungeon[r][cols]);
	        }
	        //Compute the health values the rows in the right most column 
	        //from the Princess
	        for(int c = cols-1; c >=0; c--){
	            dungeon[rows][c] = Math.max(1,dungeon[rows][c+1]-dungeon[rows][c]);
	        }
	        
	        //Compute the each  values the rows -- compare the minumum of the enights
	        //right or botom and substract from current 
	        for(int r = rows-1; r >=0; r--){
	             for(int c = cols-1; c >=0; c--)
	             {
	                int minValue = Math.min(dungeon[r+1][c],dungeon[r][c+1]);
	                dungeon[r][c] = Math.max(1,minValue - dungeon[r][c]); 
	             }
	        }   
	        return dungeon[0][0];
	    }
}
