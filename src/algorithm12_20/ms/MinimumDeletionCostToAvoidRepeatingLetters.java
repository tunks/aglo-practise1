package algorithm12_20.ms;

/**
 * Minimum Deletion Cost to Avoid Repeating Letters
Medium

Given a string s and an array of integers cost where cost[i] is the cost of deleting the ith character in s.

Return the minimum cost of deletions such that there are no two identical letters next to each other.

Notice that you will delete the chosen characters at the same time, in other words, after deleting a character, the costs of deleting other characters will not change.

 

Example 1:

Input: s = "abaac", cost = [1,2,3,4,5]
Output: 3
Explanation: Delete the letter "a" with cost 3 to get "abac" (String without two identical letters next to each other).
Example 2:

Input: s = "abc", cost = [1,2,3]
Output: 0
Explanation: You don't need to delete any character because there are no identical letters next to each other.
Example 3:

Input: s = "aabaa", cost = [1,2,3,4,1]
Output: 2
Explanation: Delete the first and the last character, getting the string ("aba").

https://leetcode.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/
 * */
public class MinimumDeletionCostToAvoidRepeatingLetters {
	 public int minCost(String s, int[] cost) {
	        if(s.length() == 0 || s.length() ==1)
	        {
	          return 0;  
	        }
	        int len = 1;
	        int count =1;
	        int result = 0;
	        int sum = cost[0];
	        int repeatedMax = cost[0];
	        char prev = s.charAt(0);
	        char ch;
	        for(int i = 1; i< s.length(); i++){
	             ch = s.charAt(i);
	             if(prev == ch)
	             {
	               len++;  
	             } 
	            else{
	                if(len > 1)
	                {
	                   result += sum - repeatedMax; 
	                }
	                //reset
	                repeatedMax =0;
	                count = 0;
	                len = 0;
	                sum = 0;
	            }
	           prev = ch;
	           repeatedMax = Math.max(repeatedMax,cost[i]);
	           sum += cost[i]; 
	           count++;
	           len++;
	        }
	        
	        if(len > 1)
	        {
	           result += sum - repeatedMax; 
	        }
	        return result; 
	    }
}
