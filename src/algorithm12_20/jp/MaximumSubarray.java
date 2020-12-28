package algorithm12_20.jp;

/**
 * 
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Example 2:

Input: nums = [1]
Output: 1
Example 3:

Input: nums = [0]
Output: 0
Example 4:

Input: nums = [-1]
Output: -1
Example 5:

Input: nums = [-2147483647]
Output: -2147483647

https://leetcode.com/problems/maximum-subarray/
 
 */

class Student{
	public String getName() {
		return "et";
	}
}
class A{
	
}
interface AI1{
	
}
interface AI2{
	
}
class B extends A implements AI1, AI2{
	
}


public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = sum;
        int startIndex = 0;
        int maxIndex = 0;
        for(int i = 1; i< nums.length; i++){
            if (sum + nums[i] < nums[i]){
                sum = nums[i];
                startIndex = i;
                maxIndex = i;
              }
              else{
                 sum += nums[i];
                 maxIndex = i;
              }   
              if(sum > max){
                 max = sum;
              }  
        }
        return max;
    }
	
	public static String encode(String text){
		StringBuilder b =  new StringBuilder();
		for(int i = 0; i<text.length(); i++){
		char c = text.charAt(i);
		c+= c+i;
		System.out.println("c: "+c);
		//c += c+i
		b.append(c);
		}
		return b.reverse().toString();
		//return b.toString();

	}

	
	public static void main(String[] args) {
		Student s = new Student();
		System.out.println("Name: "+s.getName());
		String result = encode("testing1");
		System.out.println("Encoding result: "+result);
	}
}
