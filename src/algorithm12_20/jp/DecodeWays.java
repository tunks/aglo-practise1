package algorithm12_20.jp;

import java.util.HashMap;
import java.util.Map;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

The answer is guaranteed to fit in a 32-bit integer.

 

Example 1:

Input: s = "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: s = "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
Example 3:

Input: s = "0"
Output: 0
Explanation: There is no character that is mapped to a number starting with '0'. We cannot ignore a zero when we face it while decoding. So, each '0' should be part of "10" --> 'J' or "20" --> 'T'.
Example 4:

Input: s = "1"
Output: 1
 * */
public class DecodeWays {
	 public int numDecodings(String s) {
	        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	        return decodeString(s,0,map);
	    }
	    
	    private int decodeString(String str, int index, Map<Integer,Integer> map){
	        if(index == str.length())
	        {
	            return 1;
	        }
	        
	        if(str.charAt(index) == '0'){
	           return 0;
	        }
	        if(index == str.length() -1){
	            return 1;
	        }
	        
	        if(map.containsKey(index)){
	           return map.get(index); 
	        }
	        int num = decodeString(str, index+1,map);
	        if(Integer.parseInt(str.substring(index, index+2)) <=26){
	           num+=  decodeString(str,index+2,map);
	        }
	        map.put(index,num);
	        return num;    
	    }
}
