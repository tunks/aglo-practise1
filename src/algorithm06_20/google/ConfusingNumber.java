package algorithm06_20.google;

/**
 * 
 * Given a number N, return true if and only if it is a confusing number, which satisfies the following condition:

We can rotate digits by 180 degrees to form new digits. When 0, 1, 6, 8, 9 are rotated 180 degrees, they become 0, 1, 9, 8, 6 respectively. When 2, 3, 4, 5 and 7 are rotated 180 degrees, they become invalid. 
A confusing number is a number that when rotated 180 degrees becomes a different number with each digit valid. 
 */
public class ConfusingNumber {
	  public boolean confusingNumber(int N) {      
	        /*
	          69%10=9      confuse = 0; 
	          69/10=6       {9} confuse = 10*(0) + reverse(9)->6; = 6
	         
	          6%10=6        {6} confuse = 10*(6) + reverse(6)->9 = 69 
	          6/10=0
	          
	          
	          60%10 = 0
	          60/10 = 6
	          
	          6%10=6
	          6/10=0
	          
	          -------
	          600%10=0
	          600/10=60
	          
	          60%10=0
	          60/10=6
	          
	          6%10=6
	          6/10=0  
	        */
	        int num = N;
	        int confusingNum = 0;
	        do{
	            int digit = num%10;
	            num = num/10;
	            int reverse = reverse(digit);
	            if(reverse == -1){
	               return false;
	            }
	            confusingNum = confusingNum * 10 + reverse;
	            
	        }while(num>0);
	        
	        return (confusingNum != N);
	    }
	    
	    private int reverse(int digit){
	         switch(digit){
	             case 6:
	                 return 9;
	             case 9:
	                 return 6;
	             case 0:
	             case 1:
	             case 8:
	                 return  digit;
	             default:
	                 return -1;       
	         }
	    }
}
