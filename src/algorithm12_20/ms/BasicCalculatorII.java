package algorithm12_20.ms;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 
 * Basic Calculator II
Medium

Share
Given a string s which represents an expression, evaluate this expression and return its value. 

The integer division should truncate toward zero.

 

Example 1:

Input: s = "3+2*2"
Output: 7
Example 2:

Input: s = " 3/2 "
Output: 1
Example 3:

Input: s = " 3+5 / 2 "
Output: 5 
 **/
public class BasicCalculatorII {
	 private static Set<Character> operators;
	    static{
	        operators = new HashSet<Character>();
	        operators.add('+');
	        operators.add('-');
	        operators.add('*');
	        operators.add('/');
	    }
	    public int calculate(String s) {
	        //BODMAS 
	        int currentNumber = 0;
	        int result = 0;
	        Stack<Integer> stack = new Stack<Integer>();
	        char ch;
	        char operator = ' ';
	        for(int i =0; i< s.length(); i++){
	            ch = s.charAt(i);
	            if(Character.isDigit(ch)){
	               currentNumber = currentNumber*10 + (int)(ch - '0'); 
	            }
	            
	            if(operators.contains(ch) || (i == s.length() -1) )
	            {
	                appendOperator(stack,operator,currentNumber);
	                operator = ch;
	                currentNumber = 0;
	            }
	        }
	        
	        while(!stack.isEmpty()){
	            result+= stack.pop();
	        }
	        return result;
	    }
	    
	    private void appendOperator(Stack<Integer> stack, char operator, int currentNumber)
	    {
	         switch(operator){
	             case '+':
	                stack.push(currentNumber);  
	                break;    
	             case '-':
	                 stack.push(-currentNumber); 
	                break; 
	             case '*':
	                stack.push(stack.pop()*currentNumber);
	                break; 
	             case '/':
	                stack.push(stack.pop()/currentNumber); 
	                break;
	             default:
	                stack.push(currentNumber); 
	           } 
	    }
}
