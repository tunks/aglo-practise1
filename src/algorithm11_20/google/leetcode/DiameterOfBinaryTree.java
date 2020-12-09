package algorithm11_20.google.leetcode;

import algorithm06_20.trees.TreeNode;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.

 https://leetcode.com/problems/diameter-of-binary-tree/
 * 
 */
public class DiameterOfBinaryTree {
	  public int diameterOfBinaryTree(TreeNode root) {
	       int[] arr = new int[]{0};
	       findDiameter(root,arr);
	       return arr[0];
	    }
	    
	    
	    private int findDiameter(TreeNode root, int[] arr){
	        if(root != null) {
	          int left = findDiameter(root.left, arr);
	          int right = findDiameter(root.right, arr);
	          if( root.left == null && root.right == null)
	          {
	            return 1;     
	          }
	          int maxPath = Math.max(right + left, Math.max(right, left)); 
	          arr[0] = Math.max(arr[0], maxPath); 
	          return Math.max(left,right) + 1;  
	       }   
	       return 0;
	    }
}
