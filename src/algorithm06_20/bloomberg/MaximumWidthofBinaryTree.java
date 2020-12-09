package algorithm06_20.bloomberg;

import java.util.LinkedList;
import java.util.Queue;
import javafx.util.Pair;

/**
 * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

Example 1:

Input: 

           1
         /   \
        3     2
       / \     \  
      5   3     9 

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
Example 2:

Input: 

          1
         /  
        3    
       / \       
      5   3     

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).
Example 3:

Input: 

          1
         / \
        3   2 
       /        
      5      

Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).
Example 4:

Input: 

          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).


Note: Answer will in the range of 32-bit signed integer.

https://leetcode.com/problems/maximum-width-of-binary-tree/
https://leetcode.com/articles/maximum-width-of-binary-tree/
 * */
public class MaximumWidthofBinaryTree {
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
	 public int widthOfBinaryTree(TreeNode root) {
	        Queue<Pair<Integer,TreeNode>> queue = new LinkedList<Pair<Integer,TreeNode>>();
	        int level = 0;
	        queue.add(new Pair<>(level,root));
	        Pair<Integer,TreeNode> currPair = null;
	        int maxWidth = 0;
	        while(!queue.isEmpty()){
	            int size = queue.size();
	             Pair<Integer,TreeNode>  head = queue.peek();
	            while(size > 0){
	                currPair = queue.poll();
	                TreeNode node = currPair.getValue();
	                if(node.left != null){
	                  queue.offer(new Pair(2* currPair.getKey(), node.left));  
	                }
	                
	                if(node.right != null){
	                  queue.offer(new Pair(2* currPair.getKey()+1, node.right));   
	                }
	                size--;
	            }
	        maxWidth = Math.max(maxWidth, currPair.getKey() - head.getKey() + 1);
	        }
	        return maxWidth;
	    }
}
