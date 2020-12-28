package algorithm12_20.ms;

import java.util.ArrayList;
import java.util.Stack;

/***
 * 
 * Max Rectangle in Binary Matrix
 * */
public class MaximalRectangle {
	 public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
	        int[] heights = new  int[A.get(0).size()];
	        int maxArea = 0;
	        for(int i = 0; i< A.size(); i++){
	            for(int j =0; j< A.get(0).size(); j++){
	               heights[j] =(A.get(i).get(j) == 1)?  heights[j] + 1: 0;
	            }
	            
	            maxArea = Math.max(maxArea, maxRectangle(heights));
	        }
	        return maxArea;
	    }
	    
	    private int maxRectangle(int[] heights)
	    {
	       int maxArea = 0;
	       int area =0;
	       Stack<Integer> stack = new Stack<Integer>();
	       int i =0;
	       int index =0;
	       while(i < heights.length){
	           if(stack.isEmpty() || heights[stack.peek()]<= heights[i]){
	              stack.push(i);
	              i++;
	           }
	           else{
	              index = stack.pop();
	              area =  heights[index] * (stack.isEmpty()? i: i - 1 - stack.peek());   
	           }
	           maxArea = Math.max(area,maxArea);
	       }
	       
	       while(!stack.isEmpty()){
	           index = stack.pop();
	           area =  heights[index] * (stack.isEmpty()? i: i - 1 - stack.peek());   
	           maxArea = Math.max(area,maxArea); 
	       }
	       return maxArea;
	    }
}
