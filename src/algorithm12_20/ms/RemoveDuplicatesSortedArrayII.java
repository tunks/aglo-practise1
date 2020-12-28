package algorithm12_20.ms;

import java.util.ArrayList;

/***
 * 
 * Remove Duplicates from Sorted Array II
 * Remove Duplicates from Sorted Array

Given a sorted array, remove the duplicates in place such that each element can appear atmost twice and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

Note that even though we want you to return the new length, make sure to change the original array as well in place

For example,
Given input array A = [1,1,1,2],

Your function should return length = 3, and A is now [1,1,2]
 * */
public class RemoveDuplicatesSortedArrayII {
	 public int removeDuplicates(ArrayList<Integer> a) 
	    {
		    if(a.isEmpty())
		    {
		      return a.size();  
		    }
		    
		    int count = 0;
		    int prev = a.get(a.size()-1);
		    int i = a.size()-2;
		    
		    while(i>=0){
		         int curr = a.get(i);
		         if(curr != prev)
		         {
		            count =0; 
		         }
		         else{
		             count++;
		         }
		         prev = curr;
		         if(count>=2)
		         {
		             a.remove(i);
		         }
		         i--;
		
		    }
		    return a.size();
	    }
}
