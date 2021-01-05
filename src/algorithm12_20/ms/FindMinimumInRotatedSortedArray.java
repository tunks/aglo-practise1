package algorithm12_20.ms;

/***
 * 
 * Find Minimum in Rotated Sorted Array
Medium

Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums, return the minimum element of this array.

 

Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
Example 2:

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
Example 3:

Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 
 
 https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimumInRotatedSortedArray {
	 public int findMin(int[] nums) {
	        int len = nums.length;
	        if(nums.length == 1)
	        {
	           return nums[0]; 
	        }
	        //not rotated
	        if(nums[len -1] > nums[0])
	        {
	           return nums[0];
	        }
	        
	        

	       int minNumber = findMin(nums,0,nums.length -1);
	       return minNumber; 
	    }
	    
	    private int findMin(int[] nums, int start, int end){
	    	   if(start<= end){  
	               if(end-start == 1){
	                  return Math.min(nums[start],nums[end]); 
	               }
	               int mid = start + (end - start)/2;
	               if (nums[mid] < nums[end])
	               {
	                  end = mid;  
	               }
	               else{
	                   start = mid;
	               }
	               return findMin(nums,start, end);
	           }
	           return -1;
	    }
}
