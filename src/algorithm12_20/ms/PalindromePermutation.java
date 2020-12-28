package algorithm12_20.ms;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Palindrome Permutation
Easy

455

55

Add to List

Share
Given a string, determine if a permutation of the string could form a palindrome.

Example 1:

Input: "code"
Output: false
Example 2:

Input: "aab"
Output: true
Example 3:

Input: "carerac"
Output: true 
 **/
public class PalindromePermutation {
	 public boolean canPermutePalindrome(String s) {
	        //hash map //
	        //atmost 1 key count( not divisible by 2) , 
	        // all the rest all keys are divisible by 2
	        Map<Character,Integer> map = new HashMap<Character,Integer>();   //use array[26] for alphabets --constant
	        char ch;
	        for(int i=0; i< s.length(); i++)
	        {
	            ch = s.charAt(i);
	            map.put(ch, map.getOrDefault(ch,0) + 1);
	        }
	        int notEven =0;
	        for(int val: map.values()){
	            if(val %2 !=0){
	                notEven++;
	            }
	            if(notEven>1)
	            {
	                return false;
	            }
	        }
	        return true;
	    }
}
