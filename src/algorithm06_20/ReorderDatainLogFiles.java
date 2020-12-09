package algorithm06_20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javafx.util.Pair;

/**
 * You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.

Return the final order of the logs.

 

Example 1:

Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]

https://leetcode.com/problems/reorder-data-in-log-files/
 * */
public class ReorderDatainLogFiles {
	  public String[] reorderLogFiles(String[] logs) {
	        
	        List<Pair<Integer,String[]>> letterLogs = new ArrayList<Pair<Integer,String[]>>();
	        List<String> digitLogs = new ArrayList<String>();
	        int index = 0;
	        String[] items;
	        for(String log: logs){ 
	           items =  log.split("\\s+",2); 
	           if(Character.isDigit(items[1].charAt(0))){
	               digitLogs.add(log);
	           }
	           else{
	              letterLogs.add(new Pair<>(index, items)); 
	           } 
	           index++;
	        }
	        
	        Collections.sort(letterLogs, new Comparator<Pair<Integer,String[]>>(){
	            public int compare(Pair<Integer,String[]> p1, Pair<Integer,String[]> p2){
	                 int num = p1.getValue()[1].compareTo(p2.getValue()[1]);
	                 if(num ==0){
	                     return p1.getValue()[0].compareTo(p2.getValue()[1]);
	                  }
	                return num;
	            }
	        });
	        
	        String[] result = new String[logs.length];
	        Pair<Integer,String[]> p;
	        for(int i = 0; i< letterLogs.size(); i++){
	            p = letterLogs.get(i);
	            result[i] = logs[p.getKey()];
	        }
	        
	        int start = letterLogs.size();
	        for(int i = 0; i< digitLogs.size(); i++){
	            result[start + i] = digitLogs.get(i);
	        }
	        return result;
	    }
}
