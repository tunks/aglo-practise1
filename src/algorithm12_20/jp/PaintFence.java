package algorithm12_20.jp;

public class PaintFence {
	 public int numWays(int n, int k) {
	       if (n == 0) {
	            return 0;
	        }
	        //dp bootmom up approint
	        if (n == 1) {
	            return k;
	        }
	        int[] dp = new int[n + 1];
	        // initialize special cases
	        //Paint the post i using a different colour from the post i-1.
	//Paint the post i using the same colour as the post i-1.
	        dp[1] = k;
	        dp[2] = k * k;
	       //dp[i] = (dp[i-1]+dp[i-2])*(k-1).
	        for (int i = 3; i <= n; i++) {
	            //k-1 for options
	             dp[i] = (dp[i - 1] + dp[i - 2]) * (k - 1);
	        }
	        return dp[n];
	    }   
}
