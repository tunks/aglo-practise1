package algorithm12_20.ms;

/**
 * 
 * Sqrt(x)
Easy

1686

2159

Add to List

Share
Given a non-negative integer x, compute and return the square root of x.

Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

 

Example 1:

Input: x = 4
Output: 2
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned 
 */
public class Sqrt {
	 public int mySqrt(int x) {
	        if( x == 0 || x == 1)
	        {
	            return x;
	        }
	        if(x == 2){
	           return 1; 
	        }
	        long result = 0;
	        for(long i = 1; i*i <=x; i++)
	        {
	            result++;
	        }
	        return(int) result;
	    }
}
