package algorithm12_20.jp;

import algorithm06_20.trees.TreeNode;

/***
 * 572. Subtree of Another Tree
Easy

2853

135

Add to List

Share
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
 

Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.

 https://leetcode.com/problems/subtree-of-another-tree/
 **/
public class SubtreeofAnotherTree {
	  public boolean isSubtree(TreeNode s, TreeNode t) {
	        return isSubtree2(s,t);
	    }
	    
	    //Approach 1 - Using preOrder string
	    /*private boolean isSubtree1(TreeNode s, TreeNode t){
	        String str1 = preOrderString(s);
	        String str2 = preOrderString(t);
	        return str1.contains(str2);
	    }
	    
	    private String preOrderString(TreeNode node){
	        StringBuilder builder = new StringBuilder();
	        if(node == null)
	        {
	           return "null"; 
	        }
	        
	        builder.append("("+preOrderString(node.left))
	               .append(node.val)
	               .append(preOrderString(node.right) +")");  
	    
	        return builder.toString();
	    }
	    */
	    //Approach 2 - Using comparative 
	    private boolean isSubtree2(TreeNode s, TreeNode t){
	        return (s !=null && 
	                ( compareNodes(s,t) 
	                  || isSubtree2(s.left,t) 
	                  || isSubtree2(s.right,t) )
	               );
	    }
	    
	    //using node comparation
	    private boolean compareNodes(TreeNode s, TreeNode t){
	        if(s == null && t == null){
	           return true;
	        }
	        if(s == null || t == null){
	           return false;
	        }
	        
	        return (s.val == t.val && 
	                compareNodes(s.left,t.left) && compareNodes(s.right,t.right) );
	    }
}
