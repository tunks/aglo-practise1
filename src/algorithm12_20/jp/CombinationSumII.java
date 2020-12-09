package algorithm12_20.jp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 *40. Combination Sum II
 *
 * https://leetcode.com/problems/combination-sum-ii/
Medium

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 

Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30 
 **/
public class CombinationSumII {
	 public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	        Arrays.sort(candidates);
	        List<List<Integer>> sumList = new ArrayList<List<Integer>>();
	        //1.Backtracking algorithm
	        //2. Set global sum list parameters
	        combinationSum(candidates,target,0,sumList, new ArrayList<Integer>());
	        return sumList;
	    }
	    
	    private void combinationSum(int[] candidates, int target, int start,
	                               List<List<Integer>> sumList, List<Integer> list){
	        
	        //If target is 0 and sumList does not contain the current List...then add it
	        if(target == 0 && !sumList.contains(list))
	        {
	           sumList.add(list);
	           return;
	        }
	        //return if the target is less than zero 
	        //or start is greater or eqs candidate length
	        if( target< 0 ||start>=candidates.length)
	        {
	            return;
	        }
	        
	        if(candidates[start]> target)
	        {
	            return;
	        }
	        //iterate thou from start index, 
	        // and add combinations less than or equals the target
	        for(int i = start; i< candidates.length; i++){
	            if(candidates[i]> target)
	                continue;
	            List<Integer> items = new ArrayList<Integer>(list);
	            items.add(candidates[i]);
	            combinationSum(candidates, target-candidates[i], i+1,sumList,items);
	        }
	    }
}
