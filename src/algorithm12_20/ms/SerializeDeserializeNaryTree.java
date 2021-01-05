package algorithm12_20.ms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * Serialize and Deserialize N-ary Tree
Hard

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize an N-ary tree. An N-ary tree is a rooted tree in which each node has no more than N children. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that an N-ary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following 3-ary tree



as [1 [3[5 6] 2 4]]. Note that this is just an example, you do not necessarily need to follow this format.

Or you can follow LeetCode's level order traversal serialization format, where each group of children is separated by the null value.



For example, the above tree may be serialized as [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14].

You do not necessarily need to follow the above suggested formats, there are many more different formats that work so please be creative and come up with different approaches yourself. 

https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/
 * 
 ***/
public class SerializeDeserializeNaryTree {
	// Definition for a Node.
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};
	    // Encodes a tree to a single string.
	    private static final String SEPARATOR = ",";
	    public String serialize(Node root) {
	        //[1:[2:[],3:[]]]
	         StringBuilder builder = new StringBuilder();
	         serializeTree(root,builder);
	         String serializedStr = builder.toString();
	         return serializedStr;
	    }
		
	    // Decodes your encoded data to tree.
	    public Node deserialize(String data) {
	        //split the data by comma
	        Queue<String> queue = new LinkedList<String>(Arrays.asList(data.split(SEPARATOR)));
	        Node root = deserializeTreeString(queue);
	       return root; 
	    }
	    
	    private void serializeTree(Node root, StringBuilder builder){
	         if(root == null)
	         {
	             return; 
	         }
	        //1. Stop the root value and child size, seperate by ","
	        //2. append the children by recursive calls of serializeTree()
	         builder.append(root.val)
	                .append(SEPARATOR)
	                .append(root.children.size())
	                .append(SEPARATOR);
	         for(Node child: root.children)
	         {
	           serializeTree(child,builder); 
	         }
	         
	    }
	    
	    private Node deserializeTreeString(Queue<String> queue){
	        //if queue is empty or current peek is empty() , return null
	        if(queue.isEmpty() || queue.peek().equals(""))
	        {
	          return null;    
	        }
	        int value = Integer.parseInt(queue.poll());
	        int childSize = Integer.parseInt(queue.poll());
	        Node child = null;
	        Node root = new Node(value, new ArrayList<Node>());
	        //create the root node , iterate over the size of the child and add to root
	        while(childSize>0)
	        {
	            child = deserializeTreeString(queue);
	            if(child != null){
	              root.children.add(child);  
	            }
	            childSize--;
	        }
	        //return children
	        return root;
	    }
}
