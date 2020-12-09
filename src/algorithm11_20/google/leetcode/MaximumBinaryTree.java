package algorithm11_20.google.leetcode;

import algorithm06_20.trees.TreeNode;

/**
 * 
 * https://leetcode.com/problems/maximum-binary-tree/
 *  654. Maximum Binary Tree
Medium

2145

254

Add to List

Share
Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
Note:
The size of the given array will be in the range [1,1000]
 * 
 */
public class MaximumBinaryTree {
	 public TreeNode constructMaximumBinaryTree(int[] nums) {
	        TreeNode node = findMaxIndex(nums,0,nums.length - 1);
	        return node;
	    }
	    
	    private TreeNode findMaxIndex(int[] nums, int start,int end){
	        if(start<=end){
	            int maxIndex = findMaximumIndex(nums,start,end); //O(n)->log)n
	            TreeNode left = findMaxIndex(nums, start, maxIndex-1);
	            TreeNode right = findMaxIndex(nums, maxIndex + 1,end);            
	            TreeNode node = new TreeNode(nums[maxIndex]);
	            node.left = left;
	            node.right = right;
	            return node;
	        }
	        return null;    
	    }   
	    
	    private int findMaximumIndex(int[] nums, int start,int end){
	        int max = Integer.MIN_VALUE;
	        int maxIndex = 0;
	        for(int i = start; i<=end;i++){
	           if(nums[i] > max)
	           {
	              maxIndex = i;
	              max = nums[i];
	           }
	        }
	        return maxIndex;
	    }
}
