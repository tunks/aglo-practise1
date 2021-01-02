package algorithm12_20.ms;

/***
 * 
 * Validate Binary Search Tree
Medium

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees. 

https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {
	  public boolean isValidBST(TreeNode root) {
	       return isValidBST(root,null,null); 
	    }
	    
	    private boolean isValidBST(TreeNode root,  TreeNode minNode,  TreeNode maxNode)
	    {
	        if(root != null)
	        {
	            TreeNode left = root.left;
	            TreeNode right = root.right;
	            if(left != null && !(left.val<=root.val)){
	                return false;  
	            }
	            
	            if(right != null && !(right.val>=root.val)){
	                return false;  
	            }
	            
	            if((maxNode != null && root.val>= maxNode.val) || 
	               (minNode != null && root.val<=minNode.val)){
	               return false; 
	            }
	            return isValidBST(root.left, minNode, root) 
	                  && isValidBST(root.right,root,maxNode);
	        }
	        else{
	            return true;
	        }
	    }
}
