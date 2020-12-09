package algorithm11_20.dailycodingproblem;


/**
 *
 * This question was asked by Zillow.
 * You are given a 2-d matrix where each cell represents number of coins in that cell. 
 * Assuming we start at matrix[0][0], and can only move right or down, 
 *  find the maximum number of coins you can collect by the bottom right corner.

	For example, in this matrix
	
	0 3 1 1
	2 0 0 4
	1 5 3 1
	The most we can collect is 0 + 2 + 1 + 5 + 3 + 1 = 12 coins.
 */
public class MatrixMaximumNumberCoins {

	public int maximumNumber(int[][] coins) 
	{
	   int rows = coins.length;
	   int cols = coins[0].length;
	   int[][] dp = new int[rows][cols];
	   for(int i =0; i< rows; i++) {
		   for(int j = 0; j< coins[i].length;j++) {
			  if(i == 0) {
				 dp[i][j] = coins[i][j] + ((j > 0)? dp[i][j - 1]: 0);
			  } 
			  else {
			      dp[i][j] = ((coins[i][j] + dp[i-1][j]) >= coins[i][j])? coins[i][j] + dp[i-1][j]: coins[i][j];
				  if(j> 0 && (coins[i][j] + dp[i][j-1]) >= dp[i][j]) 
				  {
					 dp[i][j] = coins[i][j] + dp[i][j-1];
				  }
			  }
		   }
	   }
	   return dp[rows-1][cols-1];	
	}
	
	public static void main(String[] args) {
//		int[][]coins = {{0, 3, 1, 1},
//				         {2, 0, 0, 4},
//				         {1, 5, 3, 1}};
		
		int[][]coins = {{0, 3, 1, 5},
				        {2, 20, 0, 4},
				        {1, 5, 3, 1}};
		
		MatrixMaximumNumberCoins maxCoins = new MatrixMaximumNumberCoins();
		int sum = maxCoins.maximumNumber(coins);
		System.out.println("Max sum: "+sum);
	}

}
