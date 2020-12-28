package algorithm12_20.ms;

public class StringToInteger2 {
	 public int myAtoi(String s) {
	       int sign = 1; //1 means positive, -1 negative
	       char ch;
	       int result = 0;
	       int len = 0;
	       for(int i = 0; i< s.length(); i++){
	          ch = s.charAt(i);
	           //check if char is non-space, postive, negative sign, is not char
	          if(Character.isDigit(ch)){
	              int value =  ch - '0';
	              if(result> Integer.MAX_VALUE/10 || (
	                 result >= Integer.MAX_VALUE/10 && value> Integer.MAX_VALUE%10)){
	                 return sign == 1? Integer.MAX_VALUE: Integer.MIN_VALUE; 
	              }
	              result = (result*10) + value; 
	              len++;
	          } 
	          else{
	              if(len == 0 && (ch == '-' || ch == '+')){
	                 sign = (ch == '-')? -1:  sign; 
	                 len++;
	              } 
	              else if(len == 0 && (ch != ' ')){
	                 return 0;  
	              }
	              else if(len > 0){
	                 break; 
	              }
	          }
	       }
	    
	        return sign * result;
	    }
}
