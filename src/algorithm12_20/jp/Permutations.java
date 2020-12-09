package algorithm12_20.jp;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 * 
 *  Permutations
Medium

https://leetcode.com/problems/permutations/
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
 * **/
public class Permutations {
	 public List<List<Integer>> permute(int[] nums) {
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        permutate(nums,0,result, new ArrayList<Integer>());
	        return result;
	    }
	    
	    private void permutate(int[] nums, int start, 
	                           List<List<Integer>> result, List<Integer> list)
	    {
	        if(start>=nums.length || list.size()>nums.length)
	        {
	            return;
	        }
	        
	        if(list.size() == nums.length)
	        {
	            result.add(new ArrayList<Integer>(list));
	            return;
	        }
	        for(int i = 0; i< nums.length; i++){
	            if(!list.contains(nums[i])){
	              List<Integer> items = new ArrayList<Integer>(list);
	              items.add(nums[i]);
	              permutate(nums,i, result, items);
	            }   
	        }
	        
	        //space O(n!) and time is O(n*n!) // (n -> array copy) + (n! -> permutation)
	    }
}
