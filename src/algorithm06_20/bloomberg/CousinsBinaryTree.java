package algorithm06_20.bloomberg;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 

Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:



Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 

Constraints:

The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100
 * */
public class CousinsBinaryTree {
	 class NodeLevel{
	        int level;
	        int parentVal;
	        
	        public NodeLevel(int level, int parentVal){
	            this.level = level;
	            this.parentVal= parentVal;
	        }
	    }
	    
	    public boolean isCousins(TreeNode root, int x, int y) {
	        //approach 1 --recursive level count
	        //return isCovis1(root,x,y);
	        //approach 2 BSF
	        return isCovisBsf1(root,x,y); 
	    }
	    
	    private boolean isCovis1(TreeNode root, int x, int y){
	          if(root != null){
	            Map<Integer,NodeLevel> map = new HashMap<Integer,NodeLevel>();
	            tranverseCousins(root.left,root.val,map, 0);
	            tranverseCousins(root.right,root.val,map, 0);
	            
	            if(map.containsKey(x) && map.containsKey(y)){
	              return (map.get(x).level == map.get(y).level &&
	                      map.get(x).parentVal != map.get(y).parentVal);
	                      
	            }
	        }
	        return false;
	    }
	    
	     private boolean isCovisBsf1(TreeNode root, int x, int y){
	         Queue<TreeNode> queue = new LinkedList<TreeNode>();
	         TreeNode node;
	         Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	         queue.add(root);
	         while(!queue.isEmpty()){
	              int size = queue.size();
	              int xIndex = -1;
	              int yIndex = -1;
	             
	              for(int i = 0; i< size; i++){
	                  node = queue.poll();
	                  if(node.left != null){
	                     queue.add(node.left);  
	                     map.put(node.left.val,node.val);
	                  }
	                  if(node.right != null){
	                     queue.add(node.right);  
	                     map.put(node.right.val,node.val);
	                  }
	                  
	                  if(node.val == x)
	                  {
	                     xIndex = x;  
	                  }
	                  
	                  if(node.val == y)
	                  {
	                     yIndex = y; 
	                  }
	              }
	                            
	            if((xIndex > -1 && yIndex > -1) && 
	                ( map.getOrDefault(x,-1) != map.getOrDefault(y,-1)) )
	                  {
	                    return true;    
	                  }
	         }
	        return false;
	    }
	    
	    
	    private void tranverseCousins(TreeNode node, int parent, Map<Integer,NodeLevel> map,
	                                 int level){
	        if(node!= null){
	           map.put(node.val, new NodeLevel(level,parent));  
	           tranverseCousins(node.left,node.val, map, level+1);
	           tranverseCousins(node.right,node.val, map, level+1);
	        }
	    }
	    
}
