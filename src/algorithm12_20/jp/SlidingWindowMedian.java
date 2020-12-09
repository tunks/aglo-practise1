package algorithm12_20.jp;

import java.util.Arrays;

public class SlidingWindowMedian {
	 public double[] medianSlidingWindow(int[] nums, int k) 
	    {
	        int i =0;
	        int len = nums.length;
	        int[] window = new int[k];
	        List<Double> mediums = new ArrayList<Double>();
	        double medium = 0.0;
	        //O(n * klogk) , space (K) in 
	        while(  i<= (len-k))
	        {
	            window = getWindow(nums,i, i+k, k);
	            if(k % 2 == 0){
	                if(k > 2){
	                  medium = ((double)window[k/2] + (double)window[k/2-1])/2.0 ;    
	                }
	                else{
	                  medium = ((double)window[k-1] + (double)window[k-2])/2.0 ; 
	                }
	                                
	            }
	            else{
	               medium = (double)window[k/2] ; 
	            }
	            
	            //medium = getMedium(nums,i, i+k, k);
	            mediums.add(medium);
	            i++;
	        }
	        
	       double[] results = new double[mediums.size()];
	        for(int j = 0; j < mediums.size(); j++){
	            results[j] = mediums.get(j);
	        }
	        return results;
	    }

	    private int[] getWindow(int[] nums, int start, int end, int k)
	    {
	        
	        int[] window = new int[k];
	        int j =0;
	        for(int i = start; i< end; i++){
	            window[j] = nums[i];
	            j++;
	        }
	        Arrays.sort(window);
	        return window;
	    }
}
