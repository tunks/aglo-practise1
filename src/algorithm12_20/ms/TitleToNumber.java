package algorithm12_20.ms;

/**
 * 
 * 71. Excel Sheet Column Number
Easy

1456

187

Add to List

Share
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
Example 1:

Input: "A"
Output: 1
Example 2:

Input: "AB"
Output: 28
Example 3:

Input: "ZY"
Output: 701
 

Constraints:

1 <= s.length <= 7
s consists only of uppercase English letters.
s is between "A" and "FXSHRXW".
https://leetcode.com/problems/excel-sheet-column-number/ 
 **/
public class TitleToNumber {
	 public int titleToNumber(String s) 
	    {
	        int result = 0;
	        int n = s.length();
	        for (int i = 0; i < n; i++)
	        {
	            result = result * 26;
	            result += (s.charAt(i) - 'A' + 1);
	        }
	        return result;
	    }
}
