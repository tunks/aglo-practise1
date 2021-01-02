package algorithm12_20.ms;

/**
 * 
 * Pow(x, n)
Medium

Implement pow(x, n), which calculates x raised to the power n (i.e. xn).

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 

Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
-104 <= xn <= 104
 
 **/
public class Power {
	 public double myPow(double x, int n) {
	       if(n < 0){
	          x = 1/x;  
	          n = -1 * n;   
	       }
	        return  computePower(x,n); 
	    }
	    
	    private double computePower(double x, int n){
	        if(n == 0){
	           return 1;  
	        }
	        double result = computePower(x,n/2);
	        if(n %2 == 0)
	        {
	           return result * result; 
	        }
	        else{
	          return result * result * x;    
	        } 
	    }
}
