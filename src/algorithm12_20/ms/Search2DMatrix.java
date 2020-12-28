package algorithm12_20.ms;

/**
 *Search a 2D Matrix
Medium

2627

185

Add to List

Share
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
 

Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
Output: true
Example 2:

 https://leetcode.com/problems/search-a-2d-matrix/
 **/
public class Search2DMatrix {
	 public boolean searchMatrix(int[][] matrix, int target) {
	        if(matrix.length == 0){
	          return false;
	        }
	        /*3 *4 == 12
	            
	      12/2 =6 
	       6/3 = 2;
	        6%4 = 2
	        */
	        int nRows = matrix.length;
	        int nCols = matrix[0].length;
	        int start =0;
	        int end = nRows * nCols -1;
	        int mid=0;
	        while(start<=end){
	           mid= start + (end-start)/2;
	           int value = matrix[mid/nCols][mid % nCols];
	           if(target == value)
	           {
	               return true;
	           }
	           if(target < value){
	               end=mid-1;
	           }
	           else{
	             start = mid +1;  
	           }
	        }
	        
	        return false;
	    }
}
