package algorithm12_20.ms;

/**
 * Excel Sheet Column Title
Easy

1490

279

Add to List

Share
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
Example 1:

Input: 1
Output: "A"
Example 2:

Input: 28
Output: "AB"
Example 3:

Input: 701
Output: "ZY"

https://leetcode.com/problems/excel-sheet-column-title/
 */
public class ExcelSheetColumnTitle {
	 public String convertToTitle(int n) {
         StringBuilder builder = new StringBuilder();
         int value = 0;
         char ch;
         while(n>0){
             if(n <=26){
                 builder.insert(0,(char)(n -1 +'A'));
                 break;
             }
             value = n%26;
             n = ((n-1)/26) ;
             ch = (value == 0)? 'Z': (char)(value -1 +'A'); 
             builder.insert(0,ch);       
         }
      
      return builder.toString();
  }  
}
