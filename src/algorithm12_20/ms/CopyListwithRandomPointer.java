package algorithm12_20.ms;

import java.util.HashMap;
import java.util.Map;


/**
 * 
 * . Copy List with Random Pointer
Medium

4268

765

Add to List

Share
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.
 

Example 1:


Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

 https://leetcode.com/problems/copy-list-with-random-pointer/
 * 
 **/
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int _val) {
    	this.val = _val;
    }

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
public class CopyListwithRandomPointer {
	 public Node copyRandomList(Node head) {
	       Map<Node,Node> pointerMap = new HashMap<Node, Node>();
	       Node n = head;
	       while(n != null){
	           pointerMap.put(n, new Node(n.val)); 
	           n = n.next;
	       } 
	       n = head;
	       while (n != null) {
	            pointerMap.get(n).random = pointerMap.get(n.random);
	            pointerMap.get(n).next = pointerMap.get(n.next);
	            n = n.next;
	        }
	        
	     return pointerMap.get(head);
	    }
}
