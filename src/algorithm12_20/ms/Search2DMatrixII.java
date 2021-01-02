package algorithm12_20.ms;

/**
 *Search a 2D Matrix II
Medium

Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
 

Example 1:


Input: matrix = [[1,4,7,11,15],
                  [2,5,8,12,19],
                  [3,6,9,16,22],
                  [10,13,14,17,24],
                  [18,21,23,26,30]], target = 5
Output: true
Example 2:


Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= n, m <= 300
-109 <= matix[i][j] <= 109
All the integers in each row are sorted in ascending order.
All the integers in each column are sorted in ascending order.
-109 <= target <= 109

https://leetcode.com/problems/search-a-2d-matrix-ii/
 
 **/
public class Search2DMatrixII {
	class Solution {
	    public boolean searchMatrix(int[][] matrix, int target) {
	        if(matrix.length == 0){
	           return false;
	        }
	        
	        int row= matrix.length -1;
	        int col = 0;
	        while(row>=0 && col<matrix[0].length){
	            if(matrix[row][col] == target){
	               return true; 
	            }
	            if(matrix[row][col]>target){
	                row--;
	            }
	            else{
	                col++;
	            }
	           
	        }
	        //O(n+m)
	        return false;
	    }
	    /*
	     //Get the min diagonal and iterate over row and col
	       
	    Using binary search -- O(nlogn)
	    private boolean binarySearch(int[][] matrix, int target, int start, boolean vertical) {
	        int lo = start;
	        int hi = vertical ? matrix[0].length-1 : matrix.length-1;

	        while (hi >= lo) {
	            int mid = (lo + hi)/2;
	            if (vertical) { // searching a column
	                if (matrix[start][mid] < target) {
	                    lo = mid + 1;
	                } else if (matrix[start][mid] > target) {
	                    hi = mid - 1;
	                } else {
	                    return true;
	                }
	            } else { // searching a row
	                if (matrix[mid][start] < target) {
	                    lo = mid + 1;
	                } else if (matrix[mid][start] > target) {
	                    hi = mid - 1;
	                } else {
	                    return true;
	                }
	            }
	        }

	        return false;
	    }

	    public boolean searchMatrix(int[][] matrix, int target) {
	        // an empty matrix obviously does not contain `target`
	        if (matrix == null || matrix.length == 0) {
	            return false;
	        }

	        // iterate over matrix diagonals
	        int shorterDim = Math.min(matrix.length, matrix[0].length);
	        for (int i = 0; i < shorterDim; i++) {
	            boolean verticalFound = binarySearch(matrix, target, i, true);
	            boolean horizontalFound = binarySearch(matrix, target, i, false);
	            if (verticalFound || horizontalFound) {
	                return true;
	            }
	        }
	        
	        return false; 
	    }
	    */
	}
}
