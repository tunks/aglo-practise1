package algorithm12_20.ms;

import java.util.ArrayList;
import java.util.List;

/***
 * Given a singly linked list

    L: L0 → L1 → … → Ln-1 → Ln,
reorder it to:

    L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
You must do this in-place without altering the nodes’ values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3} 
 */
public class ReorderList {
	 class ListNode {
		      public int val;
		      public ListNode next;
		     ListNode(int x) { val = x; next = null; }
	 }
	public ListNode reorderList(ListNode A) {
        if(A == null)
        {
            return A;
        }
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node = A;
        while(node != null){
            list.add(node);
            node = node.next;
        }
        
        int i =0;
        int j = list.size() -1;
        ListNode head = list.get(i);
        ListNode tail = null;
        if(head !=null && j> i)
        {
           head.next = list.get(j);
           tail = head.next;
           tail.next = null;
        }
        

        while(i<j){
            tail.next = list.get(i);
            tail.next.next = list.get(j);
            tail = tail.next.next;
            tail.next =null;
            i++;
            j--;
        }
        
        if(tail != null &&  i<=j && i< list.size()){
           tail.next = list.get(i);
           tail.next.next = null;
        }
        return head;
    }
}
