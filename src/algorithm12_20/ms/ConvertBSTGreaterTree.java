package algorithm12_20.ms;

/**
 * 
 * Convert BST to Greater Tree 
 * 
 * Convert BST to Greater Tree
Medium

2183

141

Add to List

Share
Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

As a reminder, a binary search tree is a tree that satisfies these constraints:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Note: This question is the same as 1038: 
https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
https://leetcode.com/problems/convert-bst-to-greater-tree/
 **/
public class ConvertBSTGreaterTree {
	 public TreeNode convertBST(TreeNode root) {
	        convertBST(root,0);
	        return root;
	    }
	    
	    private TreeNode convertBST(TreeNode root, int sum){
	       if(root == null)
	       {
	          return null;
	       }
	       TreeNode right = convertBST(root.right,sum);
	       root.val += (right == null)? sum : right.val; 
	        
	       TreeNode left = convertBST(root.left,root.val);
	       return (left == null)?root :left;
	    }
}
