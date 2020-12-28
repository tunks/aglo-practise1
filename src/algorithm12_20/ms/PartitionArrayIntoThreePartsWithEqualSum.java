package algorithm12_20.ms;

/**
 * 
 *1013. Partition Array Into Three Parts With Equal Sum
Easy

559

76

Add to List

Share
Given an array A of integers, return true if and only if we can partition the array into three non-empty parts with equal sums.

Formally, we can partition the array if we can find indexes i+1 < j with (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])

 

Example 1:

Input: A = [0,2,1,-6,6,-7,9,1,2,0,1]
Output: true
Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
Example 2:

Input: A = [0,2,1,-6,6,7,9,-1,2,0,1]
Output: false
Example 3:

Input: A = [3,3,6,5,-2,2,5,1,-9,4]
Output: true
Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4

 https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
 **/
public class PartitionArrayIntoThreePartsWithEqualSum {
	public boolean canThreePartsEqualSum(int[] A) {
		//calculate total sum
        int totalSum = 0;
        for(int num: A){
            totalSum += num;
        }
        //get the average --divide by 3
        int avg = totalSum/3;
        int currentSum = 0;
        int partitions = 0;
        //then count number of partitions
        //increase partition count by 1, when current sum equals average
        //returns true if partition equals 3
        for(int i =0; i< A.length; i++){
            currentSum += A[i];
            if(currentSum == avg)
            {
               partitions++;
               currentSum = 0; 
            } 
            if(partitions==3)
            {
                return true;
            }
        }
        
        return partitions == 3;   
    }
}
