package algorithm12_20.ms;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *  Sort Characters By Frequency
Medium

2003

139

Add to List

Share
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 */
public class SortCharactersByFrequency {
	public String frequencySort(String s) {
	       Map<Character,Integer> map = new HashMap<Character,Integer>();
	       char ch;
	       for(int i = 0; i< s.length();i++){
	          ch = s.charAt(i);
	          map.put(ch, map.getOrDefault(ch,0)+1); 
	       } 
	       PriorityQueue<Character> queue = new PriorityQueue<Character>((a,b)-> {
	          return map.get(b) - map.get(a);
	       });
	       for(char k: map.keySet()){
	          queue.add(k); 
	       } 
	       
	       int i =0;
	       int current =0; 
	       ch = ' ';
	       StringBuilder builder = new StringBuilder();
	       while(i< s.length()){
	           if(current == 0 && !queue.isEmpty())
	           {
	              ch = queue.poll();
	              current = map.remove(ch);  
	           }
	           
	           if(current>0){
	              builder.append(ch); 
	              current--;
	           }
	           else{
	               break;
	           }
	           i++;
	       } 
	        
	        return builder.toString();
	    }
}
