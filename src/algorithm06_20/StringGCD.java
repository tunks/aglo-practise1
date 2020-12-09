package algorithm06_20;

/**
 * Greatest Common Divisor of Strings
 * 
 * For strings S and T, we say "T divides S" if and only if S = T + ... + T  (T concatenated with itself 1 or more times)

Return the largest string X such that X divides str1 and X divides str2.

 

Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
Example 3:

Input: str1 = "LEET", str2 = "CODE"
Output: ""

https://leetcode.com/problems/greatest-common-divisor-of-strings/
 * */
public class StringGCD {	
   public String getGcdStrings(String str1, String str2) {
        if (str2.length() > str1.length()) return getGcdStrings(str2, str1);
        if (str2.isEmpty()) return str1;
        if (str1.startsWith(str2)) {
            if (str1.isEmpty()) return str2;
            return getGcdStrings(str1.substring(str2.length()), str2);
        }
        return "";
    }
}
