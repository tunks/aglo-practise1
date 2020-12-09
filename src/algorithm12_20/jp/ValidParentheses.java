package algorithm12_20.jp;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/***
 * 
 * Valid Parentheses
Easy

6200

253

Add to List

Share
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 https://leetcode.com/problems/valid-parentheses/
 * */
public class ValidParentheses {
	 static Map<Character,Character> charMap  = new HashMap<Character,Character>();
	    static{
	        charMap.put(')','(');
	        charMap.put('}','{');
	        charMap.put(']','[');
	    }
	    public boolean isValid(String s) {
	        
	        Stack<Character> stack = new Stack<Character>();
	        char ch;
	        for(int  i= 0; i < s.length(); i++){
	            ch = s.charAt(i);
	            if( ch == '(' ||  ch == '{' ||  ch == '[' ) 
	            {
	                stack.push(ch);
	            }
	            else if ( !stack.isEmpty() && charMap.get(ch).equals(stack.peek()) )
	            {
	               stack.pop(); 
	            }
	            else{
	                return false;
	            }
	        }
	        return stack.isEmpty();
	    }
}
