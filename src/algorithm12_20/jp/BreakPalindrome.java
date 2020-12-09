package algorithm12_20.jp;

/**
 * 
 * Break a Palindrome
Medium

205

207

Add to List

Share
Given a palindromic string palindrome, replace exactly one character by any lowercase English letter so that the string becomes the lexicographically smallest possible string that isn't a palindrome.

After doing so, return the final string.  If there is no way to do so, return the empty string.

 

Example 1:

Input: palindrome = "abccba"
Output: "aaccba"
Example 2:

Input: palindrome = "a"
Output: "" 

https://leetcode.com/problems/break-a-palindrome/
 */
public class BreakPalindrome {
	   public String breakPalindrome(String palindrome) {
	        if(palindrome.length() == 1){
	            return "";
	        }
	       char [] strChars = palindrome.toCharArray();
	       //check the first character that is not 'a' and set to 'a' and return the string
	       for(int i =0; i< strChars.length/2; i++){
	           if(strChars[i] !='a'){
	              strChars[i] = 'a';             
	              return new StringBuilder().append(strChars).toString();
	           }
	       }
	       //if all characters to middle of the string is 'a', then set the last character to 'b'
	       strChars[strChars.length-1] = 'b';
	       return new StringBuilder().append(strChars).toString();
	    }
}
