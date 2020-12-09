package algorithm11_20.google.leetcode;

import algorithm06_20.trees.TreeNode;

/**
 * 
 * 114. Flatten Binary Tree to Linked List
Medium

3535

375

Add to List

Share
Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6 
          
  https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTreetoLinkedList {
	public void flatten(TreeNode root) {
        if(root != null){
            flatten(root.left);
            flatten(root.right);
            //1. Bottom up recursive
            //2. Store temporal reference of the left and right nodes 
            TreeNode left = root.left;
            TreeNode right = root.right;
            //3. Reposition the left node to the root's right node
            //4. Set the root.left  to null
            if(left != null){
               root.right = left;
               root.left = null;
            }
            //5. Iterate on the left node to get to the last left node
            while(left != null && left.right != null){
                left = left.right;
            }
            
            //6. Point the last left to the right
             if(left != null){
                left.right = right; 
             }
        }
    }
}
