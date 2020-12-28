package algorithm12_20.jp;
/***
 * 
 * 31. Next Permutation
Medium

4402

1548

Add to List

Share
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
Example 4:

Input: nums = [1]
Output: [1]
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100

 https://leetcode.com/problems/next-permutation/
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        //1. Get the first i when nums[i] < nums[i+1]
         int i = nums.length -2;
         while(i >= 0 && nums[i + 1] <= nums[i]){
             i--;
         }
         //2. Get the first j when nums[i] < nums[j]
         if(i >= 0){
             int j =  nums.length -1;
             while(j >= 0 && nums[j] <= nums[i]){
                 j--;
             }
             //3. reverse i and j locations
             swap(nums,i,j);
         }
                     //4. reverse i+1 and the end          
        reverse(nums,i+1,nums.length -1);  
        
        //O(n)
    }
    private void swap(int[] nums , int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    private void reverse(int[] nums, int i, int j){
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
}
