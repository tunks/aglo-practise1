package algorithm11_20.google.leetcode;

import java.util.Stack;

/**
 * 
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.
 
https://leetcode.com/problems/largest-rectangle-in-histogram/

Example:

Input: [2,1,5,6,2,3]
 * */
public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        int area =0;
        int maxArea = 0;
       //1. brute force approach
//         for(int i = 0; i< heights.length; i++){
//             area = heights[i];
//             int width = 1;
//             for( int j = i+1; j < heights.length;j++){
//                 if(heights[i] > heights[j]){
//                     break;
//                 }
//                 width++;
//             }
            
//              for(int j = i-1; j >=0;j--){
//                 if(heights[i] > heights[j]){
//                     break;
//                 }
//                 width++;
//             }
//             area = heights[i] * width;
//             maxArea = Math.max(area,maxArea);
//         }
       
       //2. Optimal approach
       Stack<Integer> stack = new Stack<Integer>();
       int i = 0;
       int k =0;
       while(i < heights.length){
           if(stack.isEmpty() || heights[stack.peek()] <= heights[i])
           {
              stack.push(i);
              i++;
           }
           else{
               k = stack.pop();
               area = heights[k] * (stack.isEmpty()?i : i - 1 - stack.peek()) ;
               maxArea = Math.max(maxArea, area);
           }
         
       }
       
       
       while(!stack.isEmpty()){
           k = stack.pop();
           area = heights[k] * (stack.isEmpty()?i : i - 1 - stack.peek()) ;
           maxArea = Math.max(maxArea, area);
       }
       return maxArea;
    }
        
}
