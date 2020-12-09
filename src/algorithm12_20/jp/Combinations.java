package algorithm12_20.jp;

import java.util.ArrayList;
import java.util.List;

/***
 * 
 *Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

You may return the answer in any order.

 

Example 1:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
Example 2:

Input: n = 1, k = 1
Output: [[1]]
 

Constraints:

1 <= n <= 20
1 <= k <= n

 https://leetcode.com/problems/combinations/
 **/
public class Combinations {
	 public List<List<Integer>> combine(int n, int k) {
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        combinations(n,k,1,result, new ArrayList<Integer>());
	        return result;
	    }
	    
	    private void combinations(int n, int k, int start, 
	                              List<List<Integer>> result, List<Integer> list){
	        if(list.size() == k)
	        {
	          result.add(list);
	          return;
	        }
	        if(list.size()> k)
	        {
	            return;
	        }
	        
	        for(int i = start; i<=n; i++){
	            List<Integer> item = new ArrayList<Integer>(list);
	            item.add(i);
	            if(item.size() <=k)
	            {
	               combinations(n,k, i+1, result, item);
	            }
	        }
	    }
}
