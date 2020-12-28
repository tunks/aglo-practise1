package algorithm12_20.ms;

import java.util.ArrayList;

/**
 * Remove duplicates from Sorted Array
Given a sorted array, remove the duplicates in place such that each element appears only once and return the new length.

Note that even though we want you to return the new length, make sure to change the original array as well in place

Do not allocate extra space for another array, you must do this in place with constant memory.

 Example:
Given input array A = [1,1,2],
Your function should return length = 2, and A is now [1,2].  
 */
public class RemoveDuplicatesSortedArray {
	 public int removeDuplicates(ArrayList<Integer> a) {
	        //[1,1,2,2,3]
	        //i =0, j =1, 
	         //i=0, j = 2, [1,2,2,2,3] , i =1
	         //i =1, j=4, [1,2,3,2,3]          
	        int i = 0;
	        int j = 1;
	        while(j < a.size())
	        {
	           if(!a.get(i).equals(a.get(j)))
	           {
	              i+=1;
	              a.set(i,a.get(j));
	           } 
	           j++;
	        }
	        
	        while(a.size()> i+1)
	        {
	            a.remove(a.size()-1);
	        }
	        
	        return a.size();
	    }
}
