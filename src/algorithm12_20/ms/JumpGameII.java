package algorithm12_20.ms;

/**
 * 
 * Jump Game II
Hard

3464

Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2
 

Constraints:

1 <= nums.length <= 3 * 104
0 <= nums[i] <= 105

 * */
public class JumpGameII {
	 
	 public int jump(int[] nums) {
	        if(nums.length < 2)
	        {
	            return 0;
	        }
	        
	    
	        int count = 1;
	        int maxPosition = nums[0];
	        int maxSteps = nums[0];
	        for(int i = 1; i<nums.length; i++){
	            if(maxSteps < i){
	                count++;
	                maxSteps =maxPosition;    
	            }
	            
	            maxPosition = Math.max(maxPosition,nums[i]+i);
	        }
	        return count;
	        
	        
	        /*int count = 0;
	        int lastMaxJump = 0;
	        int maxJump = 0;
	        for(int i = 0; i<nums.length; i++){
	            if(lastMaxJump < i){
	                count++;
	                lastMaxJump = maxJump;    
	            }
	            maxJump = Math.max(maxJump,nums[i]+i);  
	        }
	        return count;
	        */
	    }
}
