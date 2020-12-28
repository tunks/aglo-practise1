package algorithm12_20.ms;

/****
 *
 * Longest Common Prefix
Easy

3401

2049

Add to List

Share
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

0 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lower-case English letters.

https://leetcode.com/problems/longest-common-prefix/
 * 
 */
public class LongestCommonPrefix {
	 public String longestCommonPrefix(String[] strs) 
	    {
	        if(strs.length == 0)
	        {
	            return "";
	        }
	         String firstStr = strs[0];
	         char ch;
	         StringBuilder builder = new StringBuilder();
	         for(int i = 0; i< firstStr.length(); i++){//O(S * (n-1)) //Sum of all characters
	             ch = firstStr.charAt(i);
	             for(int j = 1; j< strs.length; j++){
	                 if(i< strs[j].length())
	                 {
	                    if(ch != strs[j].charAt(i))
	                    {
	                       // terminate = true;
	                        //break;
	                        return firstStr.substring(0,i);
	                    }
	                     
	                 }
	                 else{
	                     return firstStr.substring(0,i);
	                   // terminate = true;   
	                 }
	             }
	             // if(terminate)
	             // {
	             //   return builder.toString();   
	             // }
	             // else{
	             //    builder.append(ch);
	             // }
	         }
	        return firstStr;//builder.toString();
	    }
 }
