package algorithm12_20.ms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]

https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * */
public class BinaryTreeZigzagLevelOrderTraversal {
	   /***
    if(level%2) --left to right 
    
    1     | 1
  2   3   |
4       5
*/
   public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
   {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
        {
         return result;  
       }
       Queue<TreeNode> queue = new LinkedList<TreeNode>();
       queue.add(root);
       int level = 0;
       TreeNode node;
       List<Integer> list;
       //use stack for non-even nodes
       Stack<Integer> stack = new Stack<Integer>();
       while(!queue.isEmpty()){
           int size = queue.size();
           list = new ArrayList<Integer>();
           while(size>0)
           {
               node = queue.poll();
               if(node.left != null)
                {
                   queue.add(node.left); 
                 } 
                 if(node.right !=null){
                    queue.add(node.right);   
                 }  
                 if(level %2 == 0)
                 {
                   list.add(node.val);
                 }
                else{
                  stack.push(node.val);   
                }
                size--;
           }
           if(list.isEmpty()){
              while(!stack.isEmpty()){
                list.add(stack.pop());   
              }  
           }
           if(!list.isEmpty()){
              result.add(list); 
           }
           level++;
       }
       return result;
   }
}
