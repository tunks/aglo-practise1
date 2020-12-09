package algorithm12_20.jp;

/**
 * 
 * You are given an integer array nums sorted in ascending order, and an integer target.

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
 */
public class SearchinRotatedSortedArray {
	  public int search(int[] nums, int target) {
	         return search(nums,0, nums.length-1, target);
	    }
	    
	    private int search(int [] nums, int start, int end, int target){
	        int mid = start + (end - start)/2;
	        if(start > end){
	           return -1;
	        }
	        if(nums[mid] == target){
	           return mid;
	        }
	        else {
	            int result = search(nums, mid+1, end, target);
	            if(result ==-1){
	               return search(nums, start, mid-1, target);
	            }
	            return result;
	            
	        }
	    }
}
