package algorithm12_20.ms;

import java.util.List;

/**
 * 
 * 
 * 1239. Maximum Length of a Concatenated String with Unique Characters
Medium

631

72

Add to List

Share
Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.

Return the maximum possible length of s.

 

Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
Maximum length is 4.
Example 2:

Input: arr = ["cha","r","act","ers"]
Output: 6
Explanation: Possible solutions are "chaers" and "acters".
Example 3:

Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
Output: 26
 

Constraints:

1 <= arr.length <= 16
1 <= arr[i].length <= 26
arr[i] contains only lower case English letters.

https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 * */
public class MaximumLengthConcatenatedStringUniqueCharacters {
	  public int maxLength(List<String> arr) {
	        int[] max = new int[]{0};
	        positionLength(arr,0,"",max);
	        return max[0];
	    }
	    
	    private void positionLength(List<String> arr, int index, String current, int[] max)
	    {
	        if(!isUnique(current))
	        {
	           return;
	        }
	        
	        max[0] = Math.max(max[0],current.length());
	        for(int i = index; i< arr.size(); i++)
	        {
	            String newStr = combineString(current, arr.get(i)); 
	            positionLength(arr,i+1,newStr, max);
	        }        
	        
	    }
	    
	    private boolean isUnique(String s1)
	    {
	        int[] letters = new int[26];
	        int index = 0;
	        for(int i = 0 ; i< s1.length();i++)
	        {
	           index = s1.charAt(i) - 'a';
	           letters[index] += 1;
	           if(letters[index] >1) 
	           {
	              return false;
	           }
	        }
	        return true;
	    }
	    private String combineString(String current, String str)
	    {
	         return new StringBuilder()
	                   .append(current)
	                   .append(str)
	                   .toString();
	    }
}
