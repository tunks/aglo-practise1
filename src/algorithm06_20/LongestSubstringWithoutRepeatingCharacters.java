package algorithm06_20;

import java.util.HashMap;

/**
 * Longest Substring Without Repeating Characters 
 * 
 * Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 * */
public class LongestSubstringWithoutRepeatingCharacters {

	 public static int lengthOfLongestSubstring(String s) {
	        if(s.length() == 0 || s.length() == 1){
	            return s.length();
	        }
	        char ch;
	        int maxLength = 0;
	        int prevIndex = 0;
	        int count = 0;
	        HashMap<Character,Integer> charIndexes = new HashMap<Character,Integer>();
	        for(int i = 0; i< s.length(); i++){
	            ch = s.charAt(i);
	            if(charIndexes.containsKey(ch)){
	               prevIndex = Math.max(prevIndex,charIndexes.get(ch));
	               count = 0;
	            }
	            count++;
	            charIndexes.put(ch,i);
	            maxLength = Math.max((count> (i - prevIndex))? count: i - prevIndex, maxLength);  
	        }
	        return maxLength;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//a is 97
		String str = "au";
		int result = lengthOfLongestSubstring(str);
		System.out.println("Result===: "+result);
	}

}


//"abcabcbb"