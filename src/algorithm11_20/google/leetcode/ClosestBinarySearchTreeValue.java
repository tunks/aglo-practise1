package algorithm11_20.google.leetcode;

import algorithm06_20.trees.TreeNode;

/*
 * 
 * 
 * https://leetcode.com/problems/closest-binary-search-tree-value/
 * 
 *270. Closest Binary Search Tree Value
Easy

876

66

Add to List

Share
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:

Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
Example:

Input: root = [4,2,5,1,3], target = 3.714286

    4
   / \
  2   5
 / \
1   3

Output: 4
 
 **/
public class ClosestBinarySearchTreeValue {
	  public int closestValue(TreeNode root, double target) {
	      return findClosestValue(root, target);
	    }
	    
	    private int findClosestValue(TreeNode root, double target){
	         if(root != null){
	            if(root.left == null &&  root.right == null){
	               return root.val; 
	            }
	            int value;
	            if(target <= root.val){
	               value = findClosestValue(root.left, target);
	            } 
	             else{
	               value = findClosestValue(root.right, target);
	             }   
	             
	             double diff = Math.abs(target- root.val);
	             if(Math.abs(target- value)< diff){
	               return value;  
	             }
	             return root.val;
	             
	         }
	        return -1;
	    }

}
