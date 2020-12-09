package algorithm12_20.jp;
/**
 * 
 * https://leetcode.com/problems/palindrome-number/
 * 
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Follow up: Could you solve it without converting the integer to a string?

 

Example 1:

Input: x = 121
Output: true
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Example 4:

Input: x = -101
Output: false
 

Constraints:

-231 <= x <= 231 - 1
 * */
public class PalindromeNumber {
	   public boolean isPalindrome(int x) {
	         int num = x;
	         int reverse = 0;
	         while(num > 0){
	            int r = num %10;
	            num = num /10;
	            reverse = reverse * 10 + r; 
	         }
	        return reverse == x;
	    }
}
