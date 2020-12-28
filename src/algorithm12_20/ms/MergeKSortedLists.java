package algorithm12_20.ms;

import java.util.PriorityQueue;

import algorithm12_20.ms.LinkedListReverseNodesKGroup.ListNode;

/***
 * 
 *Merge k Sorted Lists
Hard

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.


Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
 

Constraints:

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length won't exceed 10^4. 
 **/
public class MergeKSortedLists {
	 public ListNode mergeKLists(ListNode[] lists) 
	    {
	       PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((a,b)->a.val - b.val);
	       for(ListNode l1: lists){
	           if(l1 != null)
	           {
	             queue.offer(l1);
	           }
	       }
	       
	       ListNode listHead=null;
	       ListNode listTail =null;
	       ListNode current =null;
	       
	        while(!queue.isEmpty()){
	             current = queue.poll();
	             if(listHead == null)
	             {
	               listHead = current;   
	               listTail =  listHead; 
	             }
	            else{
	              listTail.next = current;
	              listTail = listTail.next;
	            }
	            if(current.next != null)
	            {
	              queue.offer(current.next);
	            }
	        }
	    
	       return listHead; 
	    }
}
