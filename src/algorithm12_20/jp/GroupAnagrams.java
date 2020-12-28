//package algorithm12_20.jp;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///***
// * 
// * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//
// 
//
//Example 1:
//
//Input: strs = ["eat","tea","tan","ate","nat","bat"]
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
//Example 2:
//
//Input: strs = [""]
//Output: [[""]]
//Example 3:
//
//Input: strs = ["a"]
//Output: [["a"]]
// 
//
//Constraints:
//
//1 <= strs.length <= 104
//0 <= strs[i].length <= 100
//strs[i] consists of lower-case English letters.
//
//**/
//public class GroupAnagrams {
//	 public List<List<String>> groupAnagrams(String[] strs) {
//	        Map<String,List<String>> wordMap = new HashMap<String,List<String>>();
//	        String strLetters;
//	        for(String str: strs){
//	            strLetters = mapStrLetters(str);
//	            wordMap.computeIfAbsent(strLetters,l->new ArrayList<String>())
//	                    .add(str);
//	        }
//	        
//	        List<List<String>> results = new ArrayList<List<String>>();
//	        for(List<String> val: wordMap.values()){
//	            results.add(val);
//	        }
//	        return results;
//	    }
//	    
//	    private String mapStrLetters(String word){
//	        int[] letters = new int[26];
//	        for(int i = 0; i< word.length(); i++){
//	            letters[word.charAt(i) - 'a']++;
//	        }
//	        return Arrays.toString(letters);
//	    }
//}
