package algorithm12_20.ms;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Subarray Sum Equals K
Medium

6235

218

Add to List

Share
Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 */
public class SubarraySumEqualsK {
	 public int subarraySum(int[] nums, int k) {
	        int count = 0, currentSum = 0, i = 0;
	        Map<Integer, Integer> map = new HashMap<>();
	        map.put(0, 1);
	        while (i < nums.length) {
	            currentSum += nums[i];
	            if (map.containsKey(currentSum - k)) 
	                count += map.get(currentSum - k);
	            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
	            i++;
	        }
	        
	        return count;
	    }
}
