package algorithm06_20.trees;

/**
 *Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

Example 1:

Input: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
Output: 
Merged tree:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7
 

Note: The merging process must start from the root nodes of both trees.

 https://leetcode.com/problems/merge-two-binary-trees/
 **/
public class MergeTwoBinaryTrees {
	 public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
	        TreeNode result = null;
	        if(t1 != null || t2 != null){
	          int v1 = (t1 !=null)? t1.val: 0;
	          int v2 = (t2 !=null)? t2.val: 0;
	          result = new TreeNode(v1 + v2);
	          mergeTrees(t1,t2,result);
	        }
	        return result;
	    }
	    
	    private void mergeTrees(TreeNode t1, TreeNode t2, TreeNode result){
	        if(t1 != null || t2 != null)
	        {
	         int sum = 0;
	         if(t1 != null && t1.left != null){
	            result.left = new TreeNode(t1.left.val);       
	         }  
	        
	         if(t1 != null && t1.right != null){
	            result.right = new TreeNode(t1.right.val);
	         } 
	            
	         if(t2 != null && t2.left != null){
	            sum = ((result.left != null)? result.left.val : 0) + t2.left.val;
	            result.left = new TreeNode(sum);
	         }  
	        
	         if(t2 != null && t2.right != null){
	            sum = ((result.right != null)? result.right.val : 0) + t2.right.val;
	            result.right = new TreeNode(sum);
	         } 
	        
	         mergeTrees((t1 == null)? null: t1.left,
	                    (t2 == null)? null: t2.left,
	                    result.left);
	         mergeTrees((t1 == null)? null: t1.right,
	                    (t2 == null)? null: t2.right,
	                    result.right);
	        }
	    }
}
