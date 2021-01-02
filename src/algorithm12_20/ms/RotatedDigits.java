package algorithm12_20.ms;

/***
 * Rotated Digits
Easy

https://leetcode.com/problems/rotated-digits/

X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X.  Each digit must be rotated - we cannot choose to leave it alone.

A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other (on this case they are rotated in a different direction, in other words 2 or 5 gets mirrored); 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.

Now given a positive number N, how many numbers X from 1 to N are good?

Example:
Input: 10
Output: 4
Explanation: 
There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
 * */
public class RotatedDigits {
	 public int rotatedDigits(int N) {
	        // Count how many n in [1, N] are good.
	        int ans = 0;
	        for (int n = 1; n <= N; ++n){
	            if (good(n, false)) ans++;
	        }
	        return ans;
	    }

	    // Return true if n is good.
	    // The flag is true iff we have an occurrence of 2, 5, 6, 9.
	    public boolean good(int n, boolean flag) {
	        if (n == 0) return flag;

	        int d = n % 10;
	        if (d == 3 || d == 4 || d == 7) return false;
	        if (d == 0 || d == 1 || d == 8) return good(n / 10, flag);
	        return good(n / 10, true);
	    }
	    
	    /**
	    
	     Time Complexity: O(N \log N)O(NlogN). For each X, we check each digit.

	     Space Complexity: O(\log N)O(logN)
	    **/
}
