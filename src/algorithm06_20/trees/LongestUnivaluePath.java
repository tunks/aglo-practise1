package algorithm06_20.trees;

/**
 * 
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

The length of path between two nodes is represented by the number of edges between them.


Example 1:

Input:

              5
             / \
            4   5
           / \   \
          1   1   5
Output: 2

 
Example 2:

Input:

              1
             / \
            4   5
           / \   \
          4   4   5
Output: 2

Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.

https://leetcode.com/problems/longest-univalue-path/
 * */
public class LongestUnivaluePath {
	 class NodeCount{
	        int value;
	        int count=0;    
	        public NodeCount(){
	            
	        }
	        public NodeCount(int value, int count){
	            this.value = value;
	            this.count = count;
	        }
	        
	        public String toString(){
	            return "value: "+value +" , count: "+count;
	        }
	    }
	    
	    public int longestUnivaluePath(TreeNode root) {
	        if(root != null){
	          NodeCount maxnode = new NodeCount();
	          countLongestUnivaluePath(root, maxnode);
	          return maxnode.count;
	        }
	        return 0;
	    }
	    
	    
	    private NodeCount countLongestUnivaluePath(TreeNode root, NodeCount maxnode)
	    {
	        if(root != null){
	            NodeCount leftCount = countLongestUnivaluePath(root.left, maxnode);
	            NodeCount rightCount = countLongestUnivaluePath(root.right, maxnode);
	            int left = 0, right = 0;
	            if(root.left != null && root.left.val == root.val)
	            {
	               left = leftCount.count + 1;
	            }       
	            
	            if(root.right != null &&  root.right.val == root.val)
	            {
	                right = rightCount.count + 1;  
	            }
	            
	           int count = left + right;
	            if(count > maxnode.count){
	                maxnode.value = root.val;
	                maxnode.count = count;
	            }
	            return new NodeCount(root.val, Math.max(left,right));
	        }
	        return new NodeCount(); 
	    }
	    /**
	        1
	      4     5
	   4    4  5
	    **/
	    
	     /**
	        5
	      4      5
	   1    1  5
	    **/
}
