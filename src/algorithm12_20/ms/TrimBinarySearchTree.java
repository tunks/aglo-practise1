package algorithm12_20.ms;

/**
 * Given the root of a binary search tree and the lowest and highest boundaries as low and high, trim the tree so that all its elements lies in [low, high]. Trimming the tree should not change the relative structure of the elements that will remain in the tree (i.e., any node's descendant should remain a descendant). It can be proven that there is a unique answer.

Return the root of the trimmed binary search tree. Note that the root may change depending on the given bounds.

Input: root = [3,0,4,null,2,null,null,1], low = 1, high = 3
Output: [3,2,null,1]
Example 3:

Input: root = [1], low = 1, high = 2
Output: [1]
Example 4:

Input: root = [1,null,2], low = 1, high = 3
Output: [1,null,2]
Example 5:

Input: root = [1,null,2], low = 2, high = 4
Output: [2]

 * */
public class TrimBinarySearchTree {
	 public TreeNode trimBST(TreeNode root, int L, int R) {
	        TreeNode tree = trimTree(root,L,R);
	        return tree;
	    }
	    
	    private TreeNode trimTree(TreeNode root, int L, int R){
	         TreeNode node = null;
	         if(root != null){
	            TreeNode leftNode = trimTree(root.left,L,R);
	            TreeNode rightNode = trimTree(root.right,L,R);
	            node = isValid(root.val, L, R)? new TreeNode(root.val): null;
	            if( leftNode != null)
	            {
	                if(node != null){
	                   node.left = leftNode;  
	                }
	                else{
	                  node = leftNode;
	                }
	            }
	             
	            if(rightNode != null)
	            {
	               if(node != null){
	                   node.right = rightNode;  
	                }
	                else{
	                  node = rightNode;
	                }
	            }
	         }
	        return node;
	    }
	    
	    private boolean isValid(int value, int L, int R){
	        return (value >= L && value <=R);
	    }
}
