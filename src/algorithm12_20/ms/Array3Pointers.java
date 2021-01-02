package algorithm12_20.ms;

import java.util.List;

/**
 * 
 * You are given 3 arrays A, B and C. All 3 of the arrays are sorted.

Find i, j, k such that :
max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))

**abs(x) is absolute value of x and is implemented in the following manner : **

      if (x < 0) return -x;
      else return x;
Example :

Input : 
        A : [1, 4, 10]
        B : [2, 15, 20]
        C : [10, 12]

Output : 5 
         With 10 from A, 15 from B and 10 from C.  
 **/
public class Array3Pointers {
	  public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C)
	    {
	        int i = 0;
	        int j = 0;
	        int k = 0;
	        int result = Integer.MAX_VALUE;
	        while(i< A.size() && j <B.size() && k < C.size())
	        {
	           int tmp1 = Math.max(Math.abs(A.get(i)-B.get(j)), Math.abs(B.get(j)- C.get(k)));  
	           int tmp2 = Math.max(Math.abs(A.get(i)-C.get(k)), tmp1);  
	           if(tmp2 < result){
	             result = tmp2;
	           }
	           

	           if(A.get(i) <= B.get(j) && A.get(i)<=C.get(k))
	           {
	               i++;
	           }
	           else if(B.get(j) <= A.get(i) && B.get(j)<=C.get(k))
	           {
	               j++;
	           }
	           else{
	               k++;
	           }
	        }
	        
	        return result;
	    }
}
