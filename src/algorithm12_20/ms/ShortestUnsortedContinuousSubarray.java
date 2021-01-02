package algorithm12_20.ms;

import java.util.Arrays;

/**
 * 
 *  Shortest Unsorted Continuous Subarray
Medium

Share
Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.

 

Example 1:

Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Example 2:

Input: nums = [1,2,3,4]
Output: 0
Example 3:

Input: nums = [
 * */
public class ShortestUnsortedContinuousSubarray {
	   public int findUnsortedSubarray(int[] nums) {
	        int i=0;
	        int leftMin = nums.length;
	        int rightMax =0;
	        int[] tmpNums = Arrays.copyOf(nums, nums.length);
	        Arrays.sort(tmpNums);
	        while(i<tmpNums.length){
	            if(tmpNums[i] != nums[i]){
	              leftMin = Math.min(leftMin, i);  
	              rightMax = Math.max(rightMax, i);  
	            }
	            i++;
	        }
	        
	        return (rightMax-leftMin  >=0)? rightMax - leftMin +1 : 0 ;
	    }
}
