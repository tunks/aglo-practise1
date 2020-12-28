package algorithm12_20.jp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/***
 * 
 *  Letter Combinations of a Phone Number
Medium

4847

463

Add to List

Share
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"] 

https://leetcode.com/problems/letter-combinations-of-a-phone-number/

 * 
 */
public class LetterCombinationsPhoneNumber {
	  private static Map<Character, Set<String>> digitMap;
	    static {
	      digitMap = new HashMap<Character,Set<String>>();
	        
	     digitMap.put('2', 
	                     new HashSet<String>(Arrays.asList(new String[]{"a","b","c"})));
	      digitMap.put('3', 
	                     new HashSet<String>(Arrays.asList(new String[]{"d","e","f"})));
	     digitMap.put('4', 
	                     new HashSet<String>(Arrays.asList(new String[]{"g","h","i"})));
	      digitMap.put('5', 
	                     new HashSet<String>(Arrays.asList(new String[]{"j","k","l"})));
	     digitMap.put('6', 
	                     new HashSet<String>(Arrays.asList(new String[]{"m","n","o"})));
	     digitMap.put('7', 
	                     new HashSet<String>(Arrays.asList(new String[]{"p","q","r", "s"})));
	      digitMap.put('8', 
	                     new HashSet<String>(Arrays.asList(new String[]{"t","u","v"})));
	      digitMap.put('9', 
	                     new HashSet<String>(Arrays.asList(new String[]{"w","x","y","z"})));
	    }
	    public List<String> letterCombinations(String digits) {
	        List<String> list = new ArrayList<String>();
	        combination(digits,0, list, new ArrayList<String>());
	        return list;
	    }
	    
	    
	    private  void combination(String digits, int index, 
	                              List<String> list, List<String> current){
	        
	        if( index>= digits.length())
	        {
	            if(!current.isEmpty())
	            {           
	                list.add(String.join("", current));
	            }
	            return;
	        }

	        Set<String> letters =  digitMap.get(digits.charAt(index));
	        for(String s: letters){
	            List<String> item = new ArrayList<String>(current);
	            item.add(s);
	            combination(digits,index+1, list, item);
	        }
	    }
	      
}
