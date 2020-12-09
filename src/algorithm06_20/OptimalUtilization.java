package algorithm06_20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javafx.util.Pair;

/**
 * Given 2 lists a and b. Each element is a pair of integers where the first integer represents the unique id and the second integer represents a value. Your task is to find an element from a and an element form b such that the sum of their values is less or equal to target and as close to target as possible. Return a list of ids of selected elements. If no pair is possible, return an empty list.

Example 1:

Input:
a = [[1, 2], [2, 4], [3, 6]]
b = [[1, 2]]
target = 7

Output: [[2, 1]]

Explanation:
There are only three combinations [1, 1], [2, 1], and [3, 1], which have a total sum of 4, 6 and 8, respectively.
Since 6 is the largest sum that does not exceed 7, [2, 1] is the optimal pair.
Example 2:

Input:
a = [[1, 3], [2, 5], [3, 7], [4, 10]]
b = [[1, 2], [2, 3], [3, 4], [4, 5]]
target = 10

Output: [[2, 4], [3, 2]]

Explanation:
There are two pairs possible. Element with id = 2 from the list `a` has a value 5, and element with id = 4 from the list `b` also has a value 5.
Combined, they add up to 10. Similarily, element with id = 3 from `a` has a value 7, and element with id = 2 from `b` has a value 3.
These also add up to 10. Therefore, the optimal pairs are [2, 4] and [3, 2].
Example 3:

Input:
a = [[1, 8], [2, 7], [3, 14]]
b = [[1, 5], [2, 10], [3, 14]]
target = 20

Output: [[3, 1]]
Example 4:

Input:
a = [[1, 8], [2, 15], [3, 9]]
b = [[1, 8], [2, 11], [3, 12]]
target = 20

Output: [[1, 3], [3, 2]]
 * */

public class OptimalUtilization {

	public List<int[]> optimize(int[][]a, int[][] b, int target){
		 int closetMax = 0;
		 List<Pair<Integer,int[]>> res = new ArrayList<Pair<Integer,int[]>>();
		 for(int i = 0; i < a.length; i++) {
			 int j = 0;
			 int max = 0; 
			 while(j < b.length) {
				 int sum = b[j][1] + a[i][1];
				 if (sum >= max && sum <= target) {
					 max = sum;
					 int[] items = {a[i][0], b[j][0]};
					 res.add(new Pair<>(sum, items));
				 }
				 j++;
			 }
			 
			 if(max >= closetMax) {
				closetMax = max;
			 }	
		 }
		 
		 Pair<Integer,int[]> pair;
		 List<int[]> resArray = new ArrayList<int[]>();		 
		 for( int i = 0; i< res.size(); i++) {
			  pair = res.get(i);
			  if (pair.getKey() == closetMax) {
				  resArray.add(pair.getValue());
			  }
		 }
		 return resArray;
	}
	
	public static void main(String [] args) {
//		int[][]a = {{1, 2}, {2, 4}, {3, 6}};
//		int[][]b = {{1, 2}};
//	    int target = 7;
		
		int[][] a = {{1, 3}, {2, 5}, {3, 7}, {4, 10}};
		int[][] b = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
		int	target = 10;
		OptimalUtilization optimized = new OptimalUtilization();
		List<int[]> result = optimized.optimize(a, b, target);
		for(int[] r: result) {
		   System.out.println("[ "+r[0]+", "+r[1] + "]");
		}
	}
	
}
