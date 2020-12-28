package algorithm12_20.ms;

/*
 * 1576. Replace All ?'s to Avoid Consecutive Repeating Characters
Easy

115

80

Add to List

Share
Given a string s containing only lower case English letters and the '?' character, convert all the '?' characters into lower case letters such that the final string does not contain any consecutive repeating characters. You cannot modify the non '?' characters.

It is guaranteed that there are no consecutive repeating characters in the given string except for '?'.

Return the final string after all the conversions (possibly zero) have been made. If there is more than one solution, return any of them. It can be shown that an answer is always possible with the given constraints.

 

Example 1:

Input: s = "?zs"
Output: "azs"
Explanation: There are 25 solutions for this problem. From "azs" to "yzs", all are valid. Only "z" is an invalid modification as the string will consist of consecutive repeating characters in "zzs".
Example 2:

Input: s = "ubv?w"
Output: "ubvaw"
Explanation: There are 24 solutions for this problem. Only "v" and "w" are invalid modifications as the strings will consist of consecutive repeating characters in "ubvvw" and "ubvww".
Example 3:

Input: s = "j?qg??b"
Output: "jaqgacb"
Example 4:

Input: s = "??yw?ipkj?"
Output: "acywaipkja"

https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
 * */
public class ReplaceAllAvoidConsecutiveRepeatingCharacters {
	 public String modifyString(String s) 
	    {
	        char prev = ' ';
	        char next = ' ';
	        char ch;
	        char[] results = new char[s.length()];
	        for(int i = 0; i< s.length(); i++){
	            ch = s.charAt(i);
	            if(ch == '?')
	            {
	              next =(i< s.length()-1)? s.charAt(i+1): ' ';
	              results[i] = getNextChar(prev,next);
	            }
	            else{
	             results[i] = ch;   
	            }
	            prev = results[i];
	        }
	        return new String(results);
	    }
	    
	    private char getNextChar(char prev, char next){
	          //Input: s = "?zs"
	           // i=0, prev ='', next='z' (i<s.length-1)? i+1: ''
	           //for(i=0; i<26;i++)
	        //    if(ch != prev && ch != next) return ch;
	                             
	                          //nextIndex
	        char ch = ' ';
	        for(int i =0; i< 26;i++){
	             ch = (char)(i + 'a');
	            if(ch != prev && ch != next){
	               return ch; 
	            }
	             
	        }
	        return ch;
	    }
}
