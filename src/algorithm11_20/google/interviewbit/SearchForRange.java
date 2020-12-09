package algorithm11_20.google.interviewbit;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted array of integers A(0 based index) of size N, find the starting and ending position of a given integar B in array A.

Your algorithm’s runtime complexity must be in the order of O(log n).

Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].


https://www.interviewbit.com/problems/search-for-a-range/

Input Format

The first argument given is the integer array A.
The second argument given is the integer B.
Output Format

 Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].
Constraints

1 <= N <= 10^6
1 <= A[i], B <= 10^9
For Example

Input 1:
    A = [5, 7, 7, 8, 8, 10]
    B = 8
Output 1:
    [3, 4]
Explanation 1:
    First occurence of 8 in A is at index 3
    Second occurence of 8 in A is at index 4
    ans = [3, 4]

Input 2:
    A = [5, 17, 100, 111]
    B = 3
Output 2:
    [-1, -1]

 * */
public class SearchForRange {
	    public ArrayList<Integer> searchRange(final List<Integer> A, int B) {
	         int[] result =  binarySearch(A,B,0, A.size());
	         ArrayList<Integer>  list = new ArrayList<Integer>();
	         
	         for(int num: result){
	             list.add(num);
	         }
	         return list;
	    }
	    
	    private int[] binarySearch(List<Integer> A, int B, int start, int end){
	         int[] result = new int[]{-1,-1};
	         if(start <= end){
	           int mid = start + (end - start)/2;
	           if(B < A.get(mid) ){
	              return binarySearch(A,B, start,mid-1);
	           }
	           else if(B > A.get(mid)){
	               return binarySearch(A,B, mid+1,end);
	           }
	           else{
	              result = new int[]{mid, mid};
	              if((mid-1) >= 0  && A.get(mid-1) == B)
	              {
	                result[0] = binarySearch(A,B, start,mid-1)[0];   
	              }
	              
	              if( (mid + 1) < A.size()  && A.get(mid+1) == B)
	              {
	                 result[1] = binarySearch(A,B, mid+1,end)[1]; 
	              }
	              return result;
	           }
	         }
	         return result;
	    }
}
