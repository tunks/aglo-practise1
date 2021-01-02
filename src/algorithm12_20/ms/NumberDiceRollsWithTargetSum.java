package algorithm12_20.ms;

/***
 * 
 * Number of Dice Rolls With Target Sum
Medium

1035

51

Add to List

Share
You have d dice, and each die has f faces numbered 1, 2, ..., f.

Return the number of possible ways (out of fd total ways) modulo 10^9 + 7 to roll the dice so the sum of the face up numbers equals target.

 

Example 1:

Input: d = 1, f = 6, target = 3
Output: 1
Explanation: 
You throw one die with 6 faces.  There is only one way to get a sum of 3.
Example 2:

Input: d = 2, f = 6, target = 7
Output: 6
Explanation: 
You throw two dice, each with 6 faces.  There are 6 ways to get a sum of 7:
1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
Example 3:

Input: d = 2, f = 5, target = 10
Output: 1
Explanation: 
You throw two dice, each with 5 faces.  There is only one way to get a sum of 10: 5+5.
Example 4:

Input: d = 1, f = 2, target = 3
Output: 0
Explanation: 
You throw one die with 2 faces.  There is no way to get a sum of 3.
Example 5:

Input: d = 30, f = 30, target = 500
Output: 222616187
Explanation: 
The answer must be returned modulo 10^9 + 7.

https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 * */
public class NumberDiceRollsWithTargetSum {
	  public int numRollsToTarget(int d, int f, int target) {
	       long[][] rolls = new long[d+1][target+1];
	       long res = numberOfRolls(d,f,target,rolls);
	       return (int)res;
	    }
	    
	    private long numberOfRolls(int d, int f, int target, long[][] rolls)
	    {
	        if(d==0  && target==0)
	        {
	          rolls[d][target] = 1;
	          return (target == 0)? 1: 0;  
	        }
	         if (d < 0 || target < 0 || target < d || target > f * d){
	             return 0;
	         }
	        
	        if(rolls[d][target] > 0 ){
	           return rolls[d][target]; 
	        }
	        for(int i=1; i<=f; i++)
	        {
	           if(i<=target)
	           {
	              rolls[d][target]+= numberOfRolls(d-1,f, target-i,rolls);
	           }
	        }
	        
	        rolls[d][target] %=  Math.pow(10,9) + 7;
	        return rolls[d][target];
	    }
}
