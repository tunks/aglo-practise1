package algorithm06_20;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:

Input: S = "aab"
Output: "aba"
Example 2:

Input: S = "aaab"
Output: ""
Note:

S will consist of lowercase letters and have length in range [1, 500].
 
 https://leetcode.com/problems/reorganize-string/
 
 https://www.youtube.com/watch?v=zaM_GLLvysw
 * */
public class ReorganizeString {
	public String reorganizeString(String S) {
        Map<Character,Integer> charMap = new HashMap<Character,Integer>();
        for(char ch: S.toCharArray()){
            charMap.put(ch, charMap.getOrDefault(ch,0) + 1);
        }
        
        //Max heap:  b is greater than a
        PriorityQueue<Character> heap = new PriorityQueue<Character>((a,b)-> {
                                            return charMap.get(b) - charMap.get(a);});
        
        heap.addAll(charMap.keySet());
        StringBuilder builder = new StringBuilder();
        while(heap.size() > 1){
           char current = heap.poll();
           char next = heap.poll();
           builder.append(current)
                  .append(next);
           charMap.put(current, charMap.get(current) -1);
           charMap.put(next, charMap.get(next) -1);

           if(charMap.get(current) > 0){
              heap.add(current);  
           }
            
            if(charMap.get(next) > 0){
              heap.add(next);  
           }
        }
        
        if(!heap.isEmpty()){
            char last = heap.poll();
            if(charMap.get(last) > 1){
               return "";  
            }
            builder.append(last);
        }
        return builder.toString();
    }
}
