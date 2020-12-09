package algorithm06_20.trees;

/***
 * Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1 


https://leetcode.com/problems/invert-binary-tree/
 * 
 **/
public class InvertBinaryTree {
   public TreeNode invertTree(TreeNode root) {
         TreeNode invertTree = null;
        if(root != null){
           invertTree  = new TreeNode(root.val);  
           invertNewTree(root, invertTree);
        }
        return invertTree;
       
    }
   /**
    * Recursive approach ...
    * 1. Create an invert tree, and 
    * 2. Copy the left of the root tree to  the right node of the inverTree
    * 3. Copy the right of the root tree to  the left node of the inverTree
    * */
    private void invertNewTree(TreeNode root,TreeNode invertTree ){
         if(root != null && invertTree != null){
            invertTree.left = (root.right != null)? new TreeNode(root.right.val): null;
            invertTree.right = (root.left != null)? new TreeNode(root.left.val): null;
            invertNewTree(root.left,invertTree.right);
            invertNewTree(root.right,invertTree.left);
         }
         
    }
}
