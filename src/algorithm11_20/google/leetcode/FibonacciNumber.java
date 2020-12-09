package algorithm11_20.google.leetcode;
/**
 * 
 * 509. Fibonacci Number
Easy
https://leetcode.com/problems/fibonacci-number/
857

206

Add to List

Share
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), for N > 1.
Given N, calculate F(N).

 

Example 1:

Input: 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
Example 2:

Input: 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
Example 3:

Input: 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 

Note:

0 ≤ N ≤ 30.
 * */
public class FibonacciNumber {
	 public int fib(int N) {
	        if(N == 1 || N ==2)
	        {
	           return 1; 
	        }
	        int sum =0;
	        //1,1,2,3,5,8,13
	        int v1 = 1;
	        int v2 = 1;
	        for(int i = 3; i<=N;i++){
	            sum = v1 + v2;
	            v1 = v2;
	            v2 = sum;
	        }
	        
	        return sum;
	    }
}
