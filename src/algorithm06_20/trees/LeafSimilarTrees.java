package algorithm06_20.trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/***
 * 
 * Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.



For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

 

Constraints:

Both of the given trees will have between 1 and 200 nodes.
Both of the given trees will have values between 0 and 200

[3,5,1,6,2,9,8,null,null,7,4]
[3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]

output : true
https://leetcode.com/problems/leaf-similar-trees/
 * */
public class LeafSimilarTrees {
	 public boolean leafSimilar(TreeNode root1, TreeNode root2) {
	        List<Integer> res1= findLeftValues2(root1);
	        List<Integer> res2= findLeftValues2(root2);
	        if(res1.size() != res2.size()){
	            return false;
	        }
	       
	        for(int i = 0 ; i< res1.size();i++){
	           if(res1.get(i) != res2.get(i)){
	               return false;
	           }
	        }
	        return true;
	    }
	    
	    //Approach (1). Using a stack
	    private List<Integer>  findLeftValues(TreeNode root){
	        Stack<TreeNode> stack = new Stack<TreeNode>();
	        Set<TreeNode> visits = new HashSet<TreeNode>();
	        stack.add(root);
	        List<Integer> result = new ArrayList<Integer>();
	        while(!stack.isEmpty()){
	            TreeNode node = stack.pop();
	            if(node.left == null && node.right == null){
	                result.add(node.val);
	            }
	            
	            if(node.left != null){
	               stack.add(node.left); 
	            }
	            
	            if(node.right != null){
	               stack.add(node.right); 
	            }
	        }
	        return result;
	    }
	    
	    //Approach (2) Recursive
	    private List<Integer>  findLeftValues2(TreeNode root){
	        List<Integer> result = new ArrayList<Integer>();
	        findLeftValuesRec(root, result);
	        return result;
	    }
	    
	   private void findLeftValuesRec(TreeNode node, List<Integer> list){
	        if(node != null){
	           if(node.left == null && node.right == null){
	              list.add(node.val);  
	           }  
	           findLeftValuesRec(node.left,list);
	           findLeftValuesRec(node.right,list); 
	        }
	    }
}
