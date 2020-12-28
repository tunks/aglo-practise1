package algorithm12_20.ms;

/***
 * Search in Rotated Sorted Array
Medium

6559

575

Add to List

Share
You are given an integer array nums sorted in ascending order, and an integer target.

Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

If target is found in the array return its index, otherwise, return -1.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1 

https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchRotatedSortedArray {
	public int search(int[] nums, int target) {
	      return search(nums,target,0,nums.length-1);  
	    }
	    
	    private int search(int[] nums, int target, int start, int end){
	        if(start<=end){
	           int mid = start + (end-start)/2;
	           if(nums[mid] == target){
	              return mid;
	           }
	           else if(nums[start]<=nums[mid]){
	                if(target>=nums[start] && target < nums[mid]){
	                   end = mid-1; 
	                }
	               else{
	                   start = mid +1;
	              }
	           }
	           else{
	              if(target > nums[mid] && target<=nums[end]){
	                 start = mid +1; 
	              } 
	              else{
	                 end = mid-1; 
	              }
	           }
	           return search(nums,target, start, end);
	        }
	        return -1;
	    }
}
