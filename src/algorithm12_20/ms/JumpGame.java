package algorithm12_20.ms;

/**
 * 
 * Jump Game
Medium

5348

374

Add to List

Share
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 

Constraints:

1 <= nums.length <= 3 * 10^4
0 <= nums[i][j] <= 10^5

https://leetcode.com/problems/jump-game/

 * */
public class JumpGame {
	public boolean canJump(int[] nums) {
	       int[] positions = new int[nums.length];
	       //initialize positions to 0 --unknown 
	       //1 for good and 2 for bad
	       for(int i =0; i< nums.length; i++){
	          positions[i] = 0; 
	       }
	       //Approach 1- Backtracking + memozied Approach
	        //return minimumJumps(nums,0, positions);
	       
	       //Approach 2 - DP bottom up 
	        positions[nums.length -1] = 1; 
	        for(int i = nums.length-2; i>=0; i--){
	            int numOfJumps =  Math.min(i+nums[i], nums.length-1);
	            for(int p = i+1; p <= numOfJumps; p++)
	            {
	                 if(positions[p] ==1)
	                 {
	                    positions[i] =1;
	                    break;
	                 }      
	            }
	        }
	        return positions[0] == 1;
	    }
	    
	    private boolean minimumJumps(int[] nums, int curIndex, int[] positions)
	    {
	          if(curIndex >= nums.length){
	             return false;
	          }
	          
	          //Check if position index is unknow
	          if(positions[curIndex] != 0)
	           {
	              //return true is position is good;
	              return positions[curIndex] == 1; 
	           } 
	          
	          if(curIndex == nums.length-1)
	           {
	             positions[curIndex] = 1;
	             return true;    
	           }
	          
	           int numOfJumps = Math.min(curIndex + nums[curIndex], nums.length-1);
	           for(int i = curIndex+1; i<=numOfJumps;i++)
	           {
	              if( minimumJumps(nums,i, positions))
	              {
	                positions[curIndex] = 1;
	                return true;    
	              }
	           } 
	        positions[curIndex] = 2;  
	        return false;
	    }
}
