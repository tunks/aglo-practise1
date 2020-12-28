package algorithm12_20.ms;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 
 * Basic Calculator
Hard

1862

145

Add to List

Share
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:

Input: "1 + 1"
Output: 2
Example 2:

Input: " 2-1 + 2 "
Output: 3
Example 3:

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23

https://leetcode.com/problems/basic-calculator/
 
 */
public class BasicCalculator {
	  private static Set<Character> operators = new HashSet<Character>();
	    static{
	        operators = new HashSet<Character>();
	        operators.add('+'); 
	        operators.add('-');
	    }
	    public int calculate(String s) {
	        Stack<Object> stack = new Stack<Object>();
	        char ch;
	        char prevch =' ';
	        int unit =1;
	        for(int i = s.length()-1; i>=0; i--){
	            ch = s.charAt(i);
	            if(Character.isDigit(ch)){
	                int num = ch - '0';
	                if(Character.isDigit(prevch))
	                {
	                   num = (unit *num) + (int)stack.pop();
	                }
	                stack.push(num);
	                unit*=10;
	            }
	            else {
	                  //add only operators and openning braces
	                  if(operators.contains(ch) || ch == ')')
	                  {
	                     stack.add(ch); 
	                  }
	                  else if(ch == '('){ 
	                      int result = computeExpressions(stack, prevch);
	                      stack.pop();
	                      stack.push(result);
	                  } 
	                  unit = 1;         
	            }        
	            prevch = ch;
	        }
	        
	        return computeExpressions(stack,prevch);
	    }
	    
	    private int computeExpressions(Stack<Object> stack, char prevch)
	    {
	        int result = 0;
	        if(!stack.isEmpty())
	         {
	            //if the current peek of the stack is not an operator then pop the number
	            if(!operators.contains(prevch))
	            {
	              result = (int) stack.pop();  
	            }
	         }
	        
	         while( !stack.isEmpty() && ((char)stack.peek() != ')') )
	         {
	             char operator = (char)stack.pop();
	             int num = (int)stack.pop();
	             result = compute(result, num, operator); 
	        }
	        return result;
	    }
	    
	    
	    private int compute(int a, int b, char operator){
	        switch(operator){
	            case '+':
	              return a + b;
	            case '-':
	              return a - b;
	            default:
	              return 0;
	        }
	    }
}
