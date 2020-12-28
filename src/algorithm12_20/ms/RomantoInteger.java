package algorithm12_20.ms;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Roman to Integer
Easy

2771

3832

Add to List

Share
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

 

Example 1:

Input: s = "III"
Output: 3
Example 2:

Input: s = "IV"
Output: 4
Example 3:

Input: s = "IX"
Output: 9
Example 4:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 5:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 
 https://leetcode.com/problems/roman-to-integer/
 */
public class RomantoInteger {
	 private static Map<Character,Integer> map;
	    static{
	        map = new HashMap<Character,Integer>();
	        map.put('I', 1);
	        map.put('V', 5);
	        map.put('X', 10);
	        map.put('L', 50);
	        map.put('C', 100);
	        map.put('D', 500);
	        map.put('M', 1000);
	    }
	    public int romanToInt(String s) {
	        if(s.isEmpty()){
	            return 0;
	        }
	        //XII, 
	            //start from j=len-2, and prev = c
	        //count
	        int len = s.length();
	        int i = len- 2;
	        char prev = s.charAt(len-1);
	        int prevCount = 1;
	        char current;
	        int result = 0;
	        while(i>=0){
	            current = s.charAt(i);
	             //check current and previous are not same, 
	            //then rest the prevCount and pre
	            if(current !=  prev){
	               
	                int value = computeEdgeCases(current,prev,prevCount);
	                if(value == 0) 
	                {
	                   result += compute(prev,prevCount); 
	                   prevCount = 0;
	                }
	                else{
	                   result += value + compute(prev,prevCount-1); 
	                   prevCount = -1;  
	                }
	                
	            }
	            prev = current;
	            prevCount++;
	            i--;
	        }
	        result += compute(prev,prevCount);
	        return result;
	    }
	    
	    private int compute(char ch, int count){
	        int value = map.get(ch); 
	        return count * value; 
	    }

	    private int computeEdgeCases(char current, char prev, int prevCount)
	    {
	        //edge cases
	        /*
	          prev = V, cur = I, substract, V-I = (5-1) =4
	          prev = X, cur = I, substract, X-I = (10-1) = 9
	          prev = X, cur = L, substract, L-X = (50-10) = 40
	          prev = X, cur = C, substract, C-X = (100-10) = 90
	          prev = C, cur = D, substract, D-C = (500-100) = 400
	          prev = C, cur = M, substract, M-C = (1000-100) = 900
	         */
	       if(prevCount ==0)
	       {
	           return 0;
	       }
	       if( (current == 'I' && (prev == 'V' || prev  == 'X')) ||
	           (current == 'X' && (prev == 'L' || prev  == 'C')) ||
	           (current == 'C' && (prev == 'D' || prev  == 'M')) )
	       {
	              return map.get(prev) - map.get(current);   
	       }
	       return 0;
	    }
}
