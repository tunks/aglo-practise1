package algorithm12_20.ms;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Restore IP Addresses
Medium

1570

542

Add to List

Share
Given a string s containing only digits, return all possible valid IP addresses that can be obtained from s. You can return them in any order.

A valid IP address consists of exactly four integers, each integer is between 0 and 255, separated by single dots and cannot have leading zeros. For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses. 

 

Example 1:

Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]
Example 2:

Input: s = "0000"
Output: ["0.0.0.0"]
Example 3:

Input: s = "1111"
Output: ["1.1.1.1"]
Example 4:

Input: s = "010010"
Output: ["0.10.0.10","0.100.1.0"]
Example 5:

Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 

Constraints:

0 <= s.length <= 3000
s consists of digits only.
 
 **/
public class RestoreIPAddresses {
	  private static int[] digits = {1,2,3};
	    public List<String> restoreIpAddresses(String s) {
	        //min: 4, min: 9  
	        List<String> results = new ArrayList<String>();
	        generateIPAddresses(s,0, results, new ArrayList<String>());
	       return results;
	    }
	    
	    private void generateIPAddresses(String s, int index,List<String> results,
	                                     List<String> current)
	    {
	        if(current.size() > 4)
	        {
	           return; 
	        }
	        if(s.length() == 0)
	        {
	            return;
	        }
	        if(index == s.length())
	        {
	            String ipAdress = (current.size() == 4)? String.join(".",current): "";
	            if(!ipAdress.isEmpty() && !results.contains(ipAdress))
	            {
	              results.add(ipAdress); 
	            } 
	            return;
	        }

	        if(index >s.length()){
	           return; 
	        }
	     for(int i =0 ;i< digits.length; i++)
	     {
	          int endIndex = index + digits[i];
	          if(endIndex >s.length()){
	             return;
	           }
	          endIndex = (endIndex >= s.length())? s.length() : endIndex; 
	          String part = s.substring(index,endIndex);
	          if(isValidIp(part)){
	            List<String> items = new ArrayList(current); 
	            items.add(part);
	            generateIPAddresses(s, index + digits[i], results, items);
	          }
	         //O(3 + n^n)
	     }
	      
	   }
	    
	   private boolean isValidIp(String part)
	   {
	       if(part.charAt(0) == '0' &&  part.length() > 1)
	       {
	          return false;   
	       }
	      char ch;
	      int number = 0;
	      for(int i =0; i< part.length(); i++){
	           ch = part.charAt(i);
	           if(Character.isDigit(ch)){
	              int value = (int)(ch - '0');
	              number = (number*10) + value;
	              if(number >255)
	              {
	                return false;  
	              }
	           }
	           else{
	              return false; 
	           }
	      }
	      return true; 
	   }
}
