package algorithm12_20.ms;

import java.util.Arrays;

/*
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 

Constraints:

3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4
https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2967/
 * */

public class Closet3Sum {
	  public int threeSumClosest(int[] nums, int target) {
	        if(nums.length == 0){
	            return 0;
	        }
	        
	        Arrays.sort(nums);
	        int diff = Integer.MAX_VALUE;
	        int closetNumber = 0;
	        for(int i =0 ;i< nums.length -2;i++){
	            int j=i+1;
	            int k = nums.length -1;
	            while(j< k){
	                int sum = nums[i] + nums[j] + nums[k];
	                if(sum == target){
	                   j++;
	                   k--;
	                }
	                else if(sum > target){
	                   k--;
	                }
	                else{
	                   j++;
	                }
	               
	                if(diff >= Math.abs( sum - target)){
	                   diff = Math.abs( sum - target);
	                   closetNumber = sum;
	                }
	            }
	        }
	        return closetNumber;
	    }
}
