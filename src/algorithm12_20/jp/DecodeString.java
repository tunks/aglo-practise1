package algorithm12_20.jp;

import java.util.Stack;

/**
 * 
 * 
 * https://leetcode.com/problems/decode-string/
 * 
 *Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
Example 4:

Input: s = "abc3[cd]xyz"
Output: "abccdcdcdxyz"
 

Constraints:

1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300] 
 */
public class DecodeString {
	 public String decodeString(String s) {
         Stack<Character> charStack = new Stack<Character>();       
         int i = 0;
         char ch;
         while(i < s.length())
         {
             ch = s.charAt(i); 
             //if character is ']'
             if(ch == ']'){
                 ch = charStack.pop();
                 StringBuilder builder = new StringBuilder();
                 //pop characters in stack and insert to string builder
                 //terminate when character is '['
                 while(ch != '['){
                    builder.insert(0,ch);
                    ch = charStack.pop(); 
                 }      
                 //check the digits from 1 - 300 
                 //pop the digit character in stack 
                 int count = 0;
                 int unit = 1;
                 while(!charStack.isEmpty() && Character.isDigit(charStack.peek()))
                 {
                     ch = charStack.pop();
                     count = (ch - '0') *unit + count;
                     unit *=10;
                 }
             
                 String decodedStr = builder.toString();
                 //decode the string by number of counts 
                 if(count > 0)
                 {
                   for(int k = 1; k< count;k++){
                     builder.append(decodedStr); 
                   }
                   decodedStr = builder.toString();
                 }
                 //insert the characters to the stack
                 for(int k = 0; k < decodedStr.length();k++){
                     charStack.push(decodedStr.charAt(k));
                 }  
             }
             else{
                 //insert all other characters 
                charStack.push(ch); 
             }
             i++;
         }
        
        StringBuilder result = new StringBuilder();
        while(!charStack.isEmpty()){
            result.insert(0, charStack.pop());
        }
        
        //O
        return result.toString();
    }
}
