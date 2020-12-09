package algorithm11_20.google.leetcode;

import java.util.Stack;

/***
 * 
 * 
 * Flatten a Multilevel Doubly Linked List
Medium

1880

179

Add to List

Share
You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.

Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.

 

Example 1:

Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
Output: [1,2,3,7,8,11,12,9,10,4,5,6]
Explanation:

The multilevel linked list in the input is as follows:

https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/

 * */
public class FlattenMultilevelDoublyLinkedList {
	class Node {
	    public int val;
	    public Node prev;
	    public Node next;
	    public Node child;
	};
	 public Node flatten(Node head) {
	       return flattenNode(head);
	    }
	    
	    
	    private Node flattenNode(Node head){
	        //1. Approach 1 - recursive
	        /*if(head != null){
	           Node newHead = head; 
	           Node node = newHead; 
	           Node previous = null; 
	           while(node != null){
	              if(node.child != null)
	              {
	                  Node childHead = flatten(node.child);
	                  Node childTail = childHead;
	                  while(childTail != null && childTail.next != null)
	                  {
	                    childTail = childTail.next;  
	                  }
	                  childTail.next  = node.next;
	                  node.next = childHead;
	               }
	              node.prev = previous;
	              previous = node;
	              node.child = null;
	              node = node.next;
	               
	           }
	           return newHead;
	        }
	        return null;
	        */
	        //Approach 2. Using stack
	        if(head == null){
	            return head;
	        }
	        Stack<Node> stack = new Stack<Node>();
	        //create a dummy head;
	        Node newHead = new Node();
	        //set the prev to dummy head
	        Node prev= newHead;
	        Node curr;
	        stack.push(head);
	        while(!stack.isEmpty())
	        {
	            //get current
	           curr = stack.pop();
	        //set previous next to current
	           prev.next = curr;
	           //set current.privous  to previous
	           curr.prev = prev;
	           if(curr.next != null)
	           {
	              stack.push(curr.next); 
	           }
	            
	           if(curr.child != null)
	           {
	              stack.push(curr.child);  
	              curr.child = null;
	           } 
	            //set previous to current
	           prev = curr;
	        }
	        //set dummy head previous to null
	        newHead.next.prev = null;
	        return newHead.next;  
	    }
	    
}
