package algorithm12_20.jp;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Happy Number
Easy

2624

466

Add to List

Share
Write an algorithm to determine if a number n is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Return True if n is a happy number, and False if not.

Example: 

Input: 19
Output: true
Explanation: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1 

https://leetcode.com/problems/happy-number/
 */
public class HappyNumber {
	 public boolean isHappy(int n) {
	        Set<Integer> numSet = new HashSet<Integer>();
	        while(n != 1){
	            n = digitSquareSum(n);
	            if(!numSet.contains(n))
	            {
	              numSet.add(n);
	            }
	            else{
	                return false;
	            }          
	        }
	        return true;
	    }
	    
	    private int digitSquareSum(int num){
	        int sum = 0;
	        while(num > 0){
	            int r = num % 10; 
	            num = num/10;
	            sum = sum + ( r *r );
	        }
	        return sum;
	    }
}
