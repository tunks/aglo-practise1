package algorithm12_20.ms;

import java.util.Arrays;

/**
 * Candy  Hard

Share
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Example 1:

Input: [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
             The third child gets 1 candy because it satisfies the above two conditions. 
 */
public class Candy {
	  public int candy(int[] ratings) {
	        int[] left = new int[ratings.length];
	        int[] right = new int[ratings.length];
	        
	        Arrays.fill(left,1);
	        Arrays.fill(right,1);
	        
	        for(int i = 1; i< left.length; i++){
	            if(ratings[i] > ratings[i-1]){
	                left[i] = left[i-1] + 1;
	            }
	        }
	        
	        for(int i = right.length-2; i>=0; i--){
	            if(ratings[i] > ratings[i+1]){
	              right[i] = right[i+1] + 1;
	            }
	        }
	        
	        int result = 0;
	        for(int i = 0; i<ratings.length; i++){
	            result += Math.max(left[i], right[i]);
	        }
	        
	        return result; 
	    }
}
