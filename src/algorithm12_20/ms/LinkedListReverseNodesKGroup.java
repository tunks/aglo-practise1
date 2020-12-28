package algorithm12_20.ms;

import java.util.Stack;

/*
 * 
 *  Reverse Nodes in k-Group
Hard

3034

383

Add to List

Share
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

Follow up:

Could you solve the problem in O(1) extra memory space?
You may not alter the values in the list's nodes, only nodes itself may be changed.

https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class LinkedListReverseNodesKGroup {
	  class ListNode {
		     int val;
		      ListNode next;
		     ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	  
	  public ListNode reverseKGroup(ListNode head, int k) {
	      //return reverseGroupWithStack(head,k);  
	        return reverseGroupWithNoExtraSpace(head,k);
	    }
	    
	    private ListNode reverseGroupWithNoExtraSpace(ListNode head, int k){
	        ListNode node = head;
	        ListNode newHead = null;
	        ListNode newTail = null;
	        ListNode groupHead = null;
	        ListNode groupTail = null;
	        ListNode currentNode = null;
	        int count = 0;
	        while(node != null)
	        {
	            if(groupHead == null){
	               groupHead = new ListNode(node.val); 
	               groupTail = groupHead; 
	            }
	            else{
	              ListNode newNode = new ListNode(node.val);
	              newNode.next = groupHead;
	              groupHead = newNode;   
	            }
	            
	            count +=1;
	            if(count == k ){
	                if(newHead == null){
	                   newHead = groupHead;
	                   newTail = groupTail;
	                }
	                else{
	                  newTail.next = groupHead;
	                  newTail = groupTail;
	                }
	                groupHead = null;
	                groupTail = null;
	                count = 0;
	                currentNode = node.next;
	            }
	            
	            node = node.next;
	        }
	        
	        if( newTail != null){
	            newTail.next = currentNode;
	        }
	        return newHead;
	    }
	    private ListNode reverseGroupWithStack(ListNode head, int k){
	     Stack<ListNode> stack = new  Stack<ListNode>();   
	      ListNode node = head;
	      ListNode newHead = null;
	      ListNode current = null;
	      ListNode nextGroup = null;

	       
	      while(node != null){
	           stack.push(new ListNode(node.val));
	           if(stack.size() == k){
	               while(!stack.isEmpty()){
	                 if(newHead == null){
	                    newHead = stack.pop();
	                    current = newHead; 
	                 }
	                 else{
	                    current.next = stack.pop();
	                    current =  current.next;
	                 }
	               }
	             nextGroup =node.next;
	           }
	          node = node.next;
	      }  
	       
	      node = nextGroup;
	      while(node != null){
	          current.next = new ListNode(node.val);
	          current =  current.next;
	          node = node.next;
	      }  
	      return newHead;  
	    }
}
