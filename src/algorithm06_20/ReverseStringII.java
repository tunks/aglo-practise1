package algorithm06_20;

/***
 * 
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]
 * */
public class ReverseStringII {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j =0;
        int revIndex = 0;
        boolean reverse = false;
       
        while(i < chars.length){
            if(i%k == 0){
                reverse = !reverse;
                j = ((i + k) >= chars.length)? chars.length - 1: i + k -1;
            }
          
            if(reverse && i< j && j < chars.length){
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
                j--;
            }
            
            i++;
        }
       return new StringBuilder().append(chars).toString();
   }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
