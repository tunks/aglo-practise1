package algorithm06_20.bloomberg;

/**
 * Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

Example :

Input:  root = [5,1,5,5,5,null,5]

              5
             / \
            1   5
           / \   \
          5   5   5

Output: 4

https://leetcode.com/problems/count-univalue-subtrees/
https://medium.com/@divyabiyani26/daily-coding-problem-february-23rd-2020-57f97d99e91
 * */
public class CountUnivalueSubtrees {
	/**
	 * Definition for a binary tree node.
	 */
	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }

	  class NodeCount{
	        int count;
	        boolean isValid;
	        public NodeCount(int count, boolean isValid){
	            this.count = count;
	            this.isValid = isValid;
	        }
	    }
	    
	    public int countUnivalSubtrees(TreeNode root) {
	       return countUnival(root).count;
	    }

	    
	    public NodeCount countUnival(TreeNode root) {
	        if(root == null){
	           return new NodeCount(0,false);
	        }  
	        else if(root.left == null && root.right == null){
	            return new NodeCount(1,true);
	        }
	        
	        NodeCount leftCount = countUnival(root.left);
	        NodeCount rightCount = countUnival(root.right);
	        
	        if( (root.left == null || root.left.val == root.val && leftCount.isValid)
	           && (root.right == null || root.right.val == root.val && rightCount.isValid))
	        {
	            return new NodeCount(leftCount.count + rightCount.count + 1,true);
	        }
	        else  if( (root.left != null && root.right != null)
	               && (root.left.val == root.right.val))
	        {
	            return new NodeCount(leftCount.count + rightCount.count,true) ;
	        }
	        
	        return new NodeCount(leftCount.count + rightCount.count,false);
	        
	    }
	    
	    
	    
}
