package algorithm11_20.google.leetcode;

import java.util.Stack;

/*
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example 1:

Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.
Example 2:

Input: matrix = []
Output: 0
Example 3:

Input: matrix = [["0"]]
Output: 0
Example 4:

Input: matrix = [["1"]]
Output: 1
Example 5:

Input: matrix = [["0","0"]]
Output: 0
 

Constraints:

rows == matrix.length
cols == matrix.length
0 <= row, cols <= 200
matrix[i][j] is '0' or '1'.
 
 https://leetcode.com/problems/maximal-rectangle/
 */
public class MaximalRectangle {
	  public int maximalRectangle(char[][] matrix) {
	        if(matrix.length == 0 || matrix[0].length == 0){
	           return 0;
	        }
	        int[] dp = new int[matrix[0].length];
	        int maxArea =0;
	        for(int i = 0; i< matrix.length; i++){
	            for(int j = 0; j < matrix[i].length; j++){
	                dp[j] = (matrix[i][j] == '1')? dp[j] + 1: 0;
	            }
	            maxArea = Math.max(maxRectangle(dp), maxArea);
	        }
	        return maxArea;
	    }
	    
	    private int maxRectangle(int[] heights){
	        Stack<Integer> stack = new Stack<Integer>();
	        int area = 0;
	        int maxArea = 0;
	        int i =0;
	        int index =0;
	        while(i < heights.length){
	            if(stack.isEmpty() || heights[stack.peek()] <= heights[i]){
	                stack.push(i);
	                i++;
	            }
	            else{
	                index =  stack.pop();
	                area = heights[index] * (stack.isEmpty()? i : ( i -1 - stack.peek()));
	                maxArea = Math.max(maxArea, area);
	            }
	        }
	        
	        while(!stack.isEmpty()){
	             index =  stack.pop();
	             area = heights[index] * (stack.isEmpty()? i : ( i -1 - stack.peek()));
	             maxArea = Math.max(maxArea, area);  
	        }
	        return maxArea;
	    }
}
