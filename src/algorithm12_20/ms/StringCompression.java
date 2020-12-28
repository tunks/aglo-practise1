package algorithm12_20.ms;

/**
 * 
 * String Compression
Medium

Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.

 
Follow up:
Could you solve it using only O(1) extra space?

 

Example 1:

Input: chars = ["a","a","b","b","c","c","c"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
Example 2:

Input: chars = ["a"]
Output: Return 1, and the first character of the input array should be: ["a"]
Explanation: The only group is "a", which remains uncompressed since it's a single character.
Example 3:

Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
Example 4:

Input: chars = ["a","a","a","b","b","a","a"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","3","b","2","a","2"].
Explanation: The groups are "aaa", "bb", and "aa". This compresses to "a3b2a2". Note that each group is independent even if two groups have the same character. 
 */
public class StringCompression {
	public int compress(char[] chars) {
	        if(chars.length == 0 || chars.length ==1)
	        {
	          return chars.length;    
	        }
	        
	        //Approach 1-  Using stringBuilder - extra space
	        /*
	        char ch = chars[0];
	        int count = 1;
	        int len = 0;
	        int i =1;
	        int j =0;
	        StringBuilder builder = new StringBuilder();
	        while(i< chars.length)
	        {
	            if(chars[i-1] != chars[i])
	            {
	               builder.append(chars[i-1]);
	               if(count > 1)
	               {
	                   builder.append(count);
	               }
	               count = 1;
	               j++; 
	            }
	            else{
	              count++;  
	            }  
	            i++;
	        }
	        
	        builder.append(chars[i-1]);
	        if(count > 1)
	        {
	           builder.append(count);
	        }
	        String cpStr =  builder.toString();
	        for(int k = 0; k< cpStr.length(); k++){
	            chars[k] = cpStr.charAt(k);
	        }
	        return cpStr.length();      
	        **/
	        
	        //Approach 2 - No extra space
	        char ch = chars[0];
	        int count = 1;
	        int len = 0;
	        int i =1;
	        int j =0;
	        StringBuilder builder = new StringBuilder();
	        int current = 0;
	        while(i< chars.length)
	        {
	            if(ch != chars[i])
	            {
	                chars[j++] = ch;
	                ch = chars[i]; 
	                j = appendCharacterCount(chars, count, j);
	                count = 1;
	            }
	            else{
	              count++;  
	            }  
	            i++;
	        }
	        
	        chars[j++] = chars[i-1];
	        return appendCharacterCount(chars, count, j);
	    }
	    
	    private int appendCharacterCount(char chars[], int count, int j)
	    {
	        if(count == 1)
	        {
	            return j;
	        }
	        else if(count<10)
	        {
	           chars[j++] = (char)(count + '0');
	        }
	        else{
	            int number = count;
	            while(number > 0)
	            {
	               number = count/10;
	               count = count % 10;  
	               int digit = (number>0)? number : count;
	               chars[j++] = (char)(digit + '0');
	             }
	        }
	        return j;
	    }
}
