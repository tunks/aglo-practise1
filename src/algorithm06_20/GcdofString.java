package algorithm06_20;

/***
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
 */
public class GcdofString {
	 public static String gcdOfStrings(String str1, String str2) {
	        int i = 0;
	        int len1 = str1.length();
	        int len2 = str2.length();
	        int strLen = len2;
	        
	        int j = 0;
	        String gcd = "";
	        while (strLen >0 && j < len1){
	            gcd = str2.substring(i,strLen);
	            int offset = j + strLen;
	            String subStr = str1.substring(j,(offset< len1)? offset: len1);
	            if(gcd.equals(subStr)){
	               j+= strLen;
	            }
	            else{
	              j = 0;
	              strLen--;
	              gcd = "";
	            }
	        }
	        return gcd;
	   }
	 
	 
	 public static void main(String[] args) {
		 String str1 = "ABCABC";
		 String str2 = "ABC";
		 String result = gcdOfStrings(str1, str2);
		 //result = str1.substring(3,6);
		 System.out.println("Result: "+result);
	 }
}
