package algorithm12_20.ms;

import java.util.ArrayList;

/*
 * 
 *  Given three sorted arrays A, B and Cof not necessarily same sizes.

Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively.
i.e. minimize | max(a,b,c) - min(a,b,c) |.

Example :

Input:

A : [ 1, 4, 5, 8, 10 ]
B : [ 6, 9, 15 ]
C : [ 2, 3, 6, 6 ]
Output:

1
Explanation: We get the minimum difference for a=5, b=6, c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1
 */

public class MinimizeAbsoluteDifference {
	 public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) 
	 {
	        int i =0;
	        int j =0;
	        int k =0;
	        int minAbs = Integer.MAX_VALUE;
	        while(i< A.size() && j < B.size() && k < C.size()){
	          int min=Math.min(A.get(i),Math.min(B.get(j),C.get(k)));
	          int max=Math.max(A.get(i),Math.max(B.get(j),C.get(k)));
	           int abs=Math.abs(max-min);
	           minAbs=Math.min(abs,minAbs);
	        
	           if(min==A.get(i))
	            {
	                i++;
	            }
	            else if(min==B.get(j))
	            {
	                j++;
	            }
	            else
	            {
	                k++;
	            }
	        }
	        
	        return minAbs;
	    }
}
