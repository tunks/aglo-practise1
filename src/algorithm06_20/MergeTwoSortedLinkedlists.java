package algorithm06_20;

/*
 * Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

https://leetcode.com/problems/merge-two-sorted-lists/
 * **/
public class MergeTwoSortedLinkedlists {
	  class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next;  }
      }
	  
	  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        ListNode n1 = l1;
	        ListNode n2 = l2;
	        ListNode n3 = null;
	        ListNode result = null;
	        
	        int val = -1;
	        boolean hasValue = (n1 != null || n2 != null);
	        while(hasValue){
	           hasValue = (n1 != null || n2 != null);
	           if(n1 != null && n2 != null){
	              if (n1.val <= n2.val){
	                  val = n1.val;
	                  n1 = n1.next; 
	              }
	              else{
	                val = n2.val;
	                n2 = n2.next;
	              }
	            } 
	            else if(n1 != null && n2 == null){
	                val = n1.val;
	                n1 = n1.next;
	            }
	            else if(n2 != null && n1 == null){
	                val = n2.val;
	                n2 = n2.next;
	            }
	            
	            if(hasValue){
	               if( result == null){
	                   n3 = new  ListNode(val);
	                   result = n3;
	               } 
	               else{
	                  ListNode tmp = new  ListNode(val);
	                  n3.next = tmp;
	                  n3 = tmp;
	               } 
	            }
	        }
	        return result;
	    }
	    
}
