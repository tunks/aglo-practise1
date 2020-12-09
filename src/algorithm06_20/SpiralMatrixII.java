package algorithm06_20;

/**
 * 
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

https://leetcode.com/problems/spiral-matrix-ii/
 * */
public class SpiralMatrixII {
	 public int[][] generateMatrix(int n) {
	       int r = n; 
	       int c = n;
	       int[][] result = new int[n][n];
	        
	        int direct = 1;
	        int topRow = 0, bottomRow = n - 1, rightCol = 0, leftCol = n - 1;
	        int mr, mc;
	        int count = 0;
	        while( count < n *n){
	            //top => left to right direction
	            direct = 1;
	            if(direct == 1){
	               for(int i = rightCol; i <= leftCol; i++  ){
	                  count++;
	                  result[topRow][i] = count;  
	               }
	                 
	               topRow ++;
	            }
	            direct  = 2;
	            //right => top to bottom direction
	            if (direct == 2){
	               for(int i = topRow; i <= bottomRow; i++  ){
	                  count++;
	                  result[i][leftCol] = count;  
	               }
	               leftCol--; 
	            }
	             direct  = 3;
	            //bottom => right to left direction
	            if(direct == 3){
	                for(int i = leftCol; i >=rightCol; i--  ){
	                  count++;
	                  result[bottomRow][i] = count;  
	                }
	                bottomRow --;
	            }
	             direct  = 4;
	            //left => bottom to top direction
	            if(direct == 4){
	                for(int i = bottomRow; i >=topRow; i--  ){
	                    count++;
	                    result[i][rightCol] = count; 
	                }
	                rightCol++;
	            }         
	        }
	        return result;
	    }
}
