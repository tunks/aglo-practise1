package algorithm12_20.ms;

/***
 * 
 * Palindromic Substrings

Share
Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:

Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
 

Example 2:

Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * */
public class PalindromicSubstrings {
	 public int countSubstrings(String s) {
	        int ans = 0;

	        for (int i = 0; i < s.length(); ++i) {
	            // odd-length palindromes, single character center
	            ans += countPalindromesAroundCenter(s, i, i);

	            // even-length palindromes, consecutive characters center
	            ans += countPalindromesAroundCenter(s, i, i + 1);
	        }

	        return ans;
	    }

	    private int countPalindromesAroundCenter(String ss, int lo, int hi) {
	        int ans = 0;

	        while (lo >= 0 && hi < ss.length()) {
	            if (ss.charAt(lo) != ss.charAt(hi))
	                break;   
	            lo--;
	            hi++;

	            ans++;
	        }

	        return ans;
	    }

}
