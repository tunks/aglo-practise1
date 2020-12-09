package algorithm06_20;

import java.util.PriorityQueue;
import java.util.Queue;

public class TopKNumbers {
	//min heap
   private Queue<Integer> heap = new PriorityQueue<Integer>();
    //max heap
    //private Queue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());

    private int size =  10;
    
    public TopKNumbers(int size) {
    	this.size = size;
    	
    }
	
    public void insert(int num) {
    	heap.add(num);
    	if (heap.size() > size) 
    	{
            heap.remove();
    	}
	}
	
    public int findTop() {
    	return heap.peek();
    }
    
    
	public static void main(String[] args) {
		int top = 5;
		TopKNumbers topNums = new TopKNumbers(top);
		int [] nums = new int[] {6,5,4,2, 3, 1, 7,};
		for(int i = 0; i< nums.length; i++) {
			topNums.insert(nums[i]);
		}
		
		int result = topNums.findTop();
		//1,2,3,4,5,6,7
		String msg = String.format("\n\nTop %s number is %s", top, result);
		System.out.println(msg);
	}

}
