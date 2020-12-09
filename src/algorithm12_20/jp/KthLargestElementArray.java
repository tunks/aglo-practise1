package algorithm12_20.jp;

import java.util.PriorityQueue;

public class KthLargestElementArray {
	public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
         for(int n: nums){
             if(heap.isEmpty()){
                heap.add(n); 
             }
             else{
                 if(heap.size() < k ){
                    heap.add(n); 
                 }
                 else if(heap.size() >= k && heap.peek() < n)
                 {
                    heap.poll();
                    heap.add(n);
                 }
             }
         }
        
        return heap.poll();
    }
}
