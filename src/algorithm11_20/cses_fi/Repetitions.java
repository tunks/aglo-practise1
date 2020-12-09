package algorithm11_20.cses_fi;

/***
 * https://cses.fi/problemset/task/1069
 * 
 * 
   You are given a DNA sequence: a string consisting of characters A, C, G, and T. Your task is to find the longest repetition in the sequence. This is a maximum-length substring containing only one type of character.

	Input
	
	The only input line contains a string of n characters.
	
	Output
	
	Print one integer: the length of the longest repetition.
	
	Constraints
	
	    1≤n≤106
	
	
	Example
	
	Input:
	ATTCGGGA
	
	Output:
	3
 */
public class Repetitions {
	int[] charIndexes = new int[128];
	
	
	public int longestRepetition(String text) {
		int maxCount = 0;
		int count = 0;
		int ch;
		int marker = 1;
		for(int i  = 0; i < text.length(); i++) {
			ch = text.charAt(i) - '0';
			if(charIndexes[ch] == marker) 
			{
			   marker++;
			   count = 0;
			}	
			 charIndexes[ch] = marker;
			 count++;
			 maxCount = Math.max(count, maxCount);		
		}
		
		return maxCount;
	}
	public static void main(String[] args) {
		Repetitions repetition = new Repetitions();
		//String text = "ATTCGGGA".toLowerCase();
		String text = "ATTCGGGATCHHABCDEF";//.toLowerCase();

		int count = repetition.longestRepetition(text);
		System.out.println("count: "+count);
	}

}
