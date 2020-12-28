package algorithm12_20.ms;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

https://leetcode.com/problems/spiral-matrix/
 * */
public class SpiralMatrix {
	 public List<Integer> spiralOrder(int[][] matrix) {
	        List<Integer> result = new ArrayList<Integer>();
	        if(matrix.length == 0)
	        {
	            return result;
	        }
	        int nRows = matrix.length;
	        int nCols = matrix[0].length;
	        int topRow =0;
	        int bottomRow = nRows - 1;
	        int leftCol = 0;
	        int rightCol = nCols-1;
	        
	        while(topRow<=bottomRow && leftCol<=rightCol)
	        {
	            //toprow
	            for(int c = leftCol; c <= rightCol; c++ ){
	                result.add(matrix[topRow][c]);
	            }
	            topRow++;
	            
	            //right col
	            for(int r = topRow; r <=bottomRow; r++ ){
	                result.add(matrix[r][rightCol]);
	            }
	            rightCol--;
	            
	           // if(topRow< bottomRow && leftCol< rightCol){
	           
	             //bottomrow
	            if(topRow<= bottomRow)
	            {
	                for(int c = rightCol; c >=leftCol; c-- ){
	                    result.add(matrix[bottomRow][c]);
	                }
	                bottomRow--;
	            }
	            
	              //left col
	            if(leftCol <= rightCol)
	            {
	                for(int r = bottomRow; r >=topRow; r-- ){
	                    result.add(matrix[r][leftCol]);
	                }
	                leftCol++; 
	            }
	            
	        }
	        /*[[1, 2,  3, 4]
	           [5, 6,  7, 8],
	           [9, 10, 11,12]
	          */
	        return result;
	    }
}
