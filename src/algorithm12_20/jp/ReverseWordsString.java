package algorithm12_20.jp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * Reverse Words in a String
Medium

1371

3081

Add to List

Share
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

 

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
Example 4:

Input: s = "  Bob    Loves  Alice   "
Output: "Alice Loves Bob"
Example 5:

Input: s = "Alice does not even like bob"
Output: "bob like even not does Alice"
 

Constraints:

1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.
 

Follow up:


Could you solve it in-place with O(1) extra space?

https://leetcode.com/problems/reverse-words-in-a-string/
 * */
public class ReverseWordsString {
	//hello world == > dlrow olleh
	//                   _hello 
	public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        String tmp;
        int len = words.length;
        for(int i = 0; i< len/2; i++){
             tmp = words[i];
             words[i] = words[len-1-i];
             words[len-1 -i] = tmp;
        }
        return String.join(" ",words);
    }
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter input: ");
        String s = br.readLine();
        s= s.substring(0,1).toUpperCase()+s.substring(1,s.length());
        System.out.println(s);

    }
  
}
