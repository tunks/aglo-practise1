package algorithm11_20.amazon.interviewbit;

/**
 * 
 * https://www.interviewbit.com/problems/square-root-of-integer/
 * Given an integar A.

Compute and return the square root of A.

If A is not a perfect square, return floor(sqrt(A)).

DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY



Input Format

The first and only argument given is the integer A.
Output Format

Return floor(sqrt(A))
Constraints

1 <= A <= 10^9
For Example

Input 1:
    A = 11
Output 1:
    3

Input 2:
    A = 9
Output 2:
    3
 * */
public class Sqrt {
	  public int sqrt(int A) {
		        if(A == 0 || A == 1){
		          return A;
		        }
		        if(A ==2){
		          return 1;
		        }
	
		        long ans = -1;
		        for(long i = 0; i*i <= A; i++){ ans++;}
		        return (int)ans;
	    }
}
