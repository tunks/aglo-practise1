package algorithm06_20;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/partition-labels/
 * 
 * A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

 

Example 1:

Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 

Note:

S will have length in range [1, 500].
S will consist of lowercase English letters ('a' to 'z') only.
 * */
public class PartitionLabels {
	
	 public List<Integer> partitionLabels(String S) {
	        if(S.length()<=0 || S==null)
	    		return new ArrayList<Integer>();
	        
	    	List<Integer> res= new ArrayList<Integer>();
	    	int max=0;
	    	int start=0;	
	    	for(int i=0; i<S.length(); i++)
	    	{
	    		max=Math.max(max, S.lastIndexOf(S.charAt(i)));
	    		if(i==max)
	    		{
	    			res.add(i-start+1);
	    			start=i+1;
	    		}
	    	}
	    	return res;
	    }

}
