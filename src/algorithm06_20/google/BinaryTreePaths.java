package algorithm06_20.google;

import java.util.ArrayList;
import java.util.List;

import algorithm06_20.trees.TreeNode;

/**
 * Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3

https://leetcode.com/problems/binary-tree-paths/
 * */
public class BinaryTreePaths {
	  public List<String> binaryTreePaths(TreeNode root) {
	         List<String> paths = new ArrayList<String>();
	         if(root != null){
	            traverseTreePaths(root, "", paths);
	         }
	         return paths;
	    }
	    
	    private void traverseTreePaths(TreeNode root, String path,  List<String> paths )
	    {
	         if(root != null)
	         {
	             String separator = path.isEmpty()? "": "->";
	             String nextPath = new StringBuilder()
	                                  .append(path)
	                                  .append(separator)
	                                  .append(root.val)
	                                  .toString();
	            if(root.left == null && root.right == null){
	               paths.add(nextPath); 
	            }
	            traverseTreePaths(root.left, nextPath, paths);
	            traverseTreePaths(root.right, nextPath, paths);
	        }
	    }
}
