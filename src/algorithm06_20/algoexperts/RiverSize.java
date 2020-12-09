package algorithm06_20.algoexperts;

import java.util.*;

/***
 *https://www.algoexpert.io/questions/River%20Sizes 
 */
public class RiverSize {
		static class IndexPair{
			 public int r;
			 public int c;
			 public IndexPair(int r, int c){
				 this.r = r;
				 this.c = c;
			 }
		}
	  public static List<Integer> riverSizes(int[][] matrix) {
			Stack<IndexPair> stack = new Stack<IndexPair>();
			for(int i = 0; i < matrix.length; i++){
				  for(int j =0; j< matrix[i].length; j++){
						  if(matrix[i][j] == 1){
								 stack.push(new IndexPair(i,j));
							}
					}
			}
			
			int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
			int count =0;
			List<Integer> result = new ArrayList<Integer>();
			while(!stack.isEmpty()){
				  IndexPair indexPair = stack.pop();
				  int r = indexPair.r;
					int c = indexPair.c;
				  if(matrix[r][c] == 1)
					{
						if(count > 0){
							 result.add(count);
						}
						count = 1;
						matrix[r][c] = -1;
					}
				
				  for(int[] d: directions){
					   r = indexPair.r + d[0];
					   c = indexPair.c + d[1];
						 if((r>=0 && r < matrix.length) &&
								(c >=0 && c<matrix[r].length) )
						 {
								if(matrix[r][c] == 1){
								   matrix[r][c] = -1;
								   stack.push(new IndexPair(r,c));
								   count++;
							 }
						 }	
				  } 
			}
			
			if(count > 0){
				 result.add(count);
			}
			
	    return result;
	  }

}
