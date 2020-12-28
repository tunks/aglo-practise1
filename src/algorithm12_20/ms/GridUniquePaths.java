package algorithm12_20.ms;

/***
 * 
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked ‘Finish’ in the diagram below).

How many possible unique paths are there?

Note: A and B will be such that the resulting answer fits in a 32 bit signed integer.

Example :

Input : A = 2, B = 2
Output : 2

2 possible routes : (0, 0) -> (0, 1) -> (1, 1) 
              OR  : (0, 0) -> (1, 0) -> (1, 1) 
              
https://www.interviewbit.com/problems/grid-unique-paths/
 **/
public class GridUniquePaths {
	 public int uniquePaths(int A, int B) {
	        int[][] dp = new int[A][B];
	        //set top row to 1
	        for(int i =0; i< dp.length;i++){
	            dp[i][0] = 1;
	        }
	        //set left colum
	        for(int i =0; i< dp[0].length;i++){
	            dp[0][i] = 1;
	        }
	        
	        for(int i = 1 ; i< dp.length; i++)
	        {
	           for(int j = 1; j<dp[0].length; j++){
	               dp[i][j] =  dp[i-1][j] + dp[i][j-1];
	           }    
	        }
	        return dp[A-1][B-1];
	    }
}
