package algorithm06_20;

/**
 * 1) Given two words, find if second word is the round rotation of first word.
For example: abc, cab
return 1
since cab is round rotation of abc

Example2: ab, aa
return -1
since aa is not round rotation for aa
 * */
public class TextRotation {

	public int checkRotation(String word1, String word2) {
		if(word1.length() != word2.length()) {
		  return -1;
		}
		
		char[] charArr1 = word1.toCharArray();
		char[] charArr2 = word2.toCharArray();
		int i= 0;
		int j=0;
		int k=0;
		int match = 0;
		while(j< charArr2.length) {
			if(charArr1[i] == charArr2[j]) {
			  i++;
			  match++;
			}
			else {
			  i = 0;
			  match = 0;
			}
			j++;
		}
		
		while(i < charArr1.length) {
			if(charArr1[i] == charArr2[k]) {
			  k++;
			  match++;
			}
			i++;
		}
		

		return (match == charArr2.length)? 1 : -1;
	}
	
	public static void main(String[] args) {
		/**
		 *  Given a string s1 and a string s2, write a snippet to say whether s2 is a rotation of s1?
(eg given s1 = ABCD and s2 = CDAB, return true, given s1 = ABCD, and s2 = ACBD , return false)


Algorithm: areRotations(str1, str2)

    1. Create a temp string and store concatenation of str1 to
       str1 in temp.
                          temp = str1.str1
    2. If str2 is a substring of temp then str1 and str2 are 
       rotations of each other.

    Example:                 
                     str1 = "ABACD"
                     str2 = "CDABA"

     temp = str1.str1 = "ABACDABACD"
     Since str2 is a substring of temp, str1 and str2 are 
     rotations of each other.

		 * */
		TextRotation rot = new TextRotation();
		String word1 = "abc"; //abcabc
		String word2 = "cab";
//		String word1 = "abb";
//		String word2 = "abb";
		int result = rot.checkRotation(word1, word2);
		String msg = String.format("Check rotation, %s, %s , result: %s", word1,word2, result);
		System.out.println(msg);
		
	}

}
