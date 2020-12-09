package algorithm06_20;

import java.util.Stack;

public class AmazonAssessment1 {
  public static int blockSum(int num, String[] blocks) {
	  int totalScore = 0;
	  int value = 0;
	  Stack<Integer> scores = new Stack<Integer>();
	  for(int i = 0; i< num; i++) {
		   if(blocks[i].equalsIgnoreCase("+")) {
			   if(!scores.isEmpty()) {
				   if(scores.size() > 1) {
				     value = scores.pop() +  scores.pop();
				   }
				   else {
					  value = scores.pop(); 
				   }
				   totalScore += value;
				   scores.push(value);
			   }
		   }
		   else if(blocks[i].equalsIgnoreCase("X")) {
			    if(!scores.isEmpty()) {
				   value = scores.pop();
				   totalScore += 2 * value;		
				   scores.push(value);
			   }
		   }
		   else if(blocks[i].equalsIgnoreCase("Z")) {
			   if(!scores.isEmpty()) {
				   value = scores.pop();
				   totalScore = totalScore- value;
			   }
		   }
		   else {
			   value = Integer.valueOf(blocks[i]);
			   scores.add(value);
			   totalScore += value;
		   }
	  } 
	
	  return totalScore;
  }
  
  
  public static void main(String[] args) {
	   int num = 8;
	   String[] blocks = {"5","-2","4","Z", "X", "9", "+", "+"};
	   //i =0: v=5, t = 5, s = 5
	   //i =1, v=-2, t = 5 + (-2)= 3, s = 5,-2
	   //i =2, v=4, t = 3 + 4 = 7, s = 5,-2,4
	   //i =3, v=Z, t= 7+(-4) = 3, s = 5,-2
	   //i =4, v=X, t= 3 +(2 * -2) = -1, s =5,-2  
	   //i =5, v=9, t= -1 + 9 = 8, s = 5,-2,9
	   //i =6, v=+, t = 8 +(9-2)= 13, s = 5,  -2,9 
	   //i =7, v=+, t = 13 +(8-2)= 23, s = 5,-2,9

	   //-------------------------------
	   //i =0: v=5, t = 5, s = 5
	   //i =1, v=-2, t = 5 + (-2)= 3, s = 5,-2
	   //i =2, v=4, t = 3 + 4 = 7, s = 5,-2,4
	   //i =3, v=Z, t= 7+(-4) = 3, s = 5,-2
	   //i =4, v=X, t= 3 +(2 * -2) = -1, s =5,-2
	   //i =5, v=9, t= -1 + 9 = 8, s = 5,-2, 8
	   //i =6, v=+, t = 8 +(8-2)= 13, s = 5,-2,8
	   //i =7, v=+, t = 18 +(8-2)= 23, s = 5,-2,8
	  
	   
	   //27
	  int result = blockSum(num,blocks);
	  System.out.println("Results: "+result);
  }
}
