package algorithm12_20.ms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Delete Node in a BST
Medium

Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Follow up: Can you solve it with time complexity O(height of tree)?

 

Example 1:


Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

Example 2:

Input: root = [5,3,6,2,4,null,7], key = 0
Output: [5,3,6,2,4,null,7]
Explanation: The tree does not contain a node with value = 0.
Example 3:

Input: root = [], key = 0
Output: [] 

https://leetcode.com/problems/delete-node-in-a-bst/
 */
public class DeleteNodeBST {
	 public TreeNode deleteNode(TreeNode root, int key) {
	        if(root == null)
	        {
	          return null;    
	        }
	        
	        if(root.val == key)
	        {
	          return deleteRootNode(root);
	        }
	       //Use BSF
	       Queue<TreeNode> queue = new LinkedList<TreeNode>();
	       queue.add(root);
	       TreeNode node = null;
	       TreeNode parent = null;
	       boolean isFound = false;
	       while(!queue.isEmpty()){
	          node = queue.poll();
	          if(node.val == key)
	          {
	             isFound = true;
	             break;
	          } 
	          else if(key < node.val && node.left != null){
	                queue.add(node.left); 
	          }
	          else if(key >= node.val && node.right != null){
	                queue.add(node.right); 
	          }
	          parent = node;
	       }
	       
	        //delete the child node
	       if(isFound && parent != null ){
	          deleteNode(parent,node); 
	       } 
	       return root;
	    }
	    //Delete root node
	    private TreeNode deleteRootNode(TreeNode root){
	        TreeNode right = root.right;
	        TreeNode left =  root.left;
	        if(left == null || right == null)
	        {
	           return (left != null)? left: right;  
	        }
	        else{
	          TreeNode newRoot = left;
	          TreeNode current = newRoot;
	          while(current.right != null){
	             current = current.right;  
	          }  
	            ///point farthest right of the left node and to the root right side
	          current.right = right;
	          return newRoot;
	        }
	    }
	    
	    private void deleteNode(TreeNode parent, TreeNode node){
	        TreeNode right = node.right;
	        TreeNode left = node.left;
	        TreeNode current = null;
	        if(parent.val > node.val){
	           parent.left = right;
	           current = parent;
	           while(current.left != null){
	             current = current.left ;   
	           }  
	           current.left = left;
	        }
	        else{
	           parent.right = left;
	           current = parent;
	           while(current.right != null){
	             current = current.right ;   
	           }  
	           current.right = right;
	        }
	    }    
}
