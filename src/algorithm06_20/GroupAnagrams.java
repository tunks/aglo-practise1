package algorithm06_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 
 * Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.

https://leetcode.com/problems/group-anagrams/
 * */
public class GroupAnagrams {
	  public List<List<String>> groupAnagrams(String[] strs) 
	    {
	        String key;
	        Map<String,List<String>> map = new HashMap<String,List<String>>();
	        for(String str: strs){
	            key = getCharArrKey(str);
	            List<String> list = map.getOrDefault(key, new ArrayList<String>());
	            list.add(str);
	            map.put(key,list);
	        }
	        
	        List<List<String>> groups = new ArrayList<List<String>>();
	        for(List<String> ls: map.values()){
	           groups.add(ls); 
	        }
	        return groups;
	    }
	    
	    private String getCharArrKey(String str){
	        int[] charArr = new int[26];
	        for(char ch: str.toCharArray()){
	            charArr[ch-'a']++;
	        }
	        return Arrays.toString(charArr);
	    }

}
