package algorithm12_20.ms;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIII {
	public boolean canReach(int[] arr, int start) {
        //start the index 
       //BFS
       Queue<Integer> queue = new LinkedList<Integer>();
       queue.add(start);
       int index = 0;
       while(!queue.isEmpty())
       {
           index = queue.poll();
           //check if arr value == 0 , return true;
           if(arr[index] == 0)
           {
               return true;
           }
           //skipped visited index positions
           if(arr[index]< -1){
               continue;
           }
           //add to the queue
           if(index + arr[index] < arr.length)
           {
             queue.add(index + arr[index]);   
           }
           if(index-arr[index]>=0){
              queue.add(index - arr[index]);  
           }
           //marked positions that are visited
           arr[index] = -arr[index];
       }
       return false;
   }
	
	/*
	 * DFS
	 *  public boolean canReach(int[] arr, int start) {
	        if (start >= 0 && start < arr.length && arr[start] >= 0) {
	            if (arr[start] == 0) {
	                return true;
	            }
	            arr[start] = -arr[start];
	            return canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
	        }
	        return false;
	    }
	 */
}
