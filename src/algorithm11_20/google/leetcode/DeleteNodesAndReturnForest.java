package algorithm11_20.google.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import algorithm06_20.bloomberg.TreeNode;

/***
 * 
 * Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest.  You may return the result in any order.

 

Example 1:



Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]
 

Constraints:

The number of nodes in the given tree is at most 1000.
Each node has a distinct value between 1 and 1000.
to_delete.length <= 1000
to_delete contains distinct values between 1 and 1000

https://leetcode.com/problems/delete-nodes-and-return-forest/
 */
public class DeleteNodesAndReturnForest {
	 public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
	        List<TreeNode> nodes = new ArrayList<TreeNode>();
	        if(root == null){
	          return nodes;
	        }
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        Set<Integer> deleteSet = new HashSet<Integer>();
	        for(int num: to_delete){
	            deleteSet.add(num);
	        }
	        if(!deleteSet.contains(root.val))
	        {
	          nodes.add(root);
	        }
	        queue.add(root);
	        TreeNode node;
	        while(!queue.isEmpty()){
	          node = queue.poll();
	          if(node.left != null ){
	             queue.add(node.left); 
	             if(deleteSet.contains(node.left.val)){
	                node.left = null;
	             }
	          }  
	        
	         if(node.right != null){
	             queue.add(node.right);
	             if(deleteSet.contains(node.right.val)){
	                node.right = null;
	             }
	          } 
	            
	         if(deleteSet.contains(node.val)){
	             if(node.left !=  null)
	             {
	                nodes.add(node.left); 
	             }
	             if(node.right !=  null){
	                nodes.add(node.right); 
	             }
	             node.left = null;
	             node.right = null;
	         }
	        }
	        
	         
	        return nodes;
	    }
}
