package algorithm12_20.ms;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 
 *Find Median from Data Stream
Hard

3485

63

Add to List

Share
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
 

Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
 

Follow up:

If all integer numbers from the stream are between 0 and 100, how would you optimize it?
If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it? 
 **/
public class FindMedianfromDataStream {
	 private PriorityQueue<Integer> lowHeap;
	    private PriorityQueue<Integer> highHeap; 
	    /** initialize your data structure here. */
	    public FindMedianfromDataStream() {
	        lowHeap = new PriorityQueue<Integer>(); 
	        highHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
	    }
	    
	    public void addNum(int num) {
	        lowHeap.offer(num);
	        
	        highHeap.offer(lowHeap.poll());
	        
	        if(lowHeap.size()< highHeap.size()){
	           lowHeap.offer(highHeap.poll()); 
	        }
	    }
	    
	    public double findMedian() {
	        PriorityQueue<Integer> l = lowHeap;
	        PriorityQueue<Integer> h = highHeap;
	        if(lowHeap.isEmpty() && highHeap.isEmpty()){
	            return 0.0;
	        }
	        return (lowHeap.size()> highHeap.size())? lowHeap.peek(): 
	                (lowHeap.peek() + highHeap.peek()) * 0.5;
	    }
}
