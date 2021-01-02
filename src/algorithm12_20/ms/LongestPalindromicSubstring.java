package algorithm12_20.ms;

/**
 * 
 * Longest Palindromic Substring

Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a" 
 */
public class LongestPalindromicSubstring {
	  public String longestPalindrome(String s) {
	       int maxLen = 0;
	       int len = 0;
	       int start  =0;
	       int end = 0;
	       for(int i =0; i< s.length(); i++){
	           int len1 = palindroneLength(s,i,i);
	           int len2 = palindroneLength(s,i,i+1);
	           len = Math.max(len1,len2);
	           if(len > maxLen){
	              start = i - (len-1)/2; 
	              end = i + (len/2);
	              maxLen = len;
	           }
	       }
	        
	       return s.substring(start,end+1);
	    }
	    
	    private int palindroneLength(String s, int i, int j){
	       while(i < s.length() &&  j>=0 && j<s.length() && s.charAt(i)== s.charAt(j)){
	           i++;
	           j--;
	       } 
	       return i - j - 1; 
	    }
}
