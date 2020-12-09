package algorithm06_20.google;

import java.util.ArrayList;
import java.util.List;

import algorithm06_20.trees.TreeNode;

/**
 * 
 *  Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 * 
 */
public class MinimumAbsoluteDifferenceBST {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> numbers = new ArrayList<Integer>();
        inOrderTraversal(root, numbers);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i< numbers.size() - 1;i++){
           int diff = Math.abs(numbers.get(i) - numbers.get(i+1));
           min = Math.min(min, diff);  
        }
        return min;
    }
    
    private void inOrderTraversal(TreeNode root, List<Integer> numbers){
        if(root != null){
           inOrderTraversal(root.left,numbers);
           numbers.add(root.val);
           inOrderTraversal(root.right,numbers);
        }   
    }
}
