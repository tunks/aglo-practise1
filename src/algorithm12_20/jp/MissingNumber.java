package algorithm12_20.jp;

/**
 * 
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?

 

Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
Example 2:

Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
Example 3:

Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
Example 4:

Input: nums = [0]
Output: 1
Explanation: n = 1 since there is 1 number, so all numbers are in the range [0,1]. 1 is the missing number in the range since it does not appear in nums. 
 * 
 * 
 * https://leetcode.com/problems/missing-number/
 */
public class MissingNumber {
	public int missingNumber(int[] nums) {
        int num = nums.length;
        int sum = 0;
        int total = 0;
        int min = Integer.MAX_VALUE;
        //1. Get the sum of the numbers in the array
        //2. Compute the total sum of numbers from 0 to n
        for(int i =0; i< nums.length; i++){
            sum += nums[i]; 
            total += i + 1;
            min = Math.min(min,nums[i]);
        }
        int diff = total - sum;
        //3. Get the difference , 
         // if the minumum number is 0 and difference is 0, then return 1 + num 
        //  else return diff
        return (diff == 0  &&  min == 0)?  num + 1: diff; 
    }
}
