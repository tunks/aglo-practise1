package algorithm11_20.dailycodingproblem;

/**
 * 
 * 

This problem was asked by Google.

Given a sorted list of integers, square the elements and give the output in sorted order.

For example, given [-9, -2, 0, 2, 3], return [0, 4, 4, 9, 81].
 * */
public class SortSquareIntegers {
  public int[] sortSquare(int[] nums) {
	  int[] results = new int[nums.length];
	  int i =0;
	  int j = nums.length - 1;
	  int k = j;
	  int leftValue = 0, rightValue = 0;
	  while(i < j) {
		  leftValue = nums[i] * nums[i];
		  rightValue = nums[j] * nums[j];

		  if( rightValue >= leftValue) {
			  results[k] = rightValue;
			  j--;
		  }
		  else {
			  results[k] = leftValue;
			  i++;
		  }
		  k--;
	  }
	  return results;
  }
  public static void main(String[] arg) {
	  SortSquareIntegers squareInteger = new SortSquareIntegers();
	  int[] num = {-9, -2, -1, 0, 2, 3};
	  int[] result = squareInteger.sortSquare(num);
	  for(int i = 0; i< result.length;i++) {
		  System.out.print(result[i]+" ");
	  }
	  
  }
}
