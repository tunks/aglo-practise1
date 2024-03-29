package algorithm12_20.ms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 
 *Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false 

https://leetcode.com/problems/word-break/
 **/
public class WordBreak {
	 public boolean wordBreak(String s, List<String> wordDict) {
	       Set<String> wordSet = new HashSet<String>(wordDict);
	       Queue<Integer> queue = new LinkedList<Integer>();
	       queue.add(0);
	       Set<Integer> visits = new HashSet<Integer>();
	       while(!queue.isEmpty()){
	            int position = queue.poll();
	            if(!visits.contains(position)){
	                for(int i = position; i<=s.length();i++){
	                    if(wordSet.contains(s.substring(position, i)))
	                    {
	                       queue.add(i); 
	                       if(i == s.length()){
	                          return true; 
	                       } 
	                    }  
	                }
	                visits.add(position);
	            }
	       }
	       
	       return false;
	    }
}
