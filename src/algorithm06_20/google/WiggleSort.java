package algorithm06_20.google;

/**
 * 
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

Example:

Input: nums = [3,5,2,1,6,4]
Output: One possible answer is [3,5,1,6,2,4]
 * */
public class WiggleSort {

	 public void wiggleSort(int[] nums) {
	        int i =0;
	        int j = 0;
	        while(i < nums.length){
	            if((i-1) %2 == 0){       
	               if(nums[i-1] > nums[i]){
	                  swap(nums,i,i-1);
	               } 
	                
	                if((i < nums.length - 1) 
	                 && nums[i+1] > nums[i] ){
	                    swap(nums,i,i+1);
	               }
	            }
	            i++;
	        }
	    }
	    
	    private void swap(int[] nums, int i, int j){
	           int tmp = nums[i];
	           nums[i] = nums[j];
	           nums[j] = tmp; 
	    }
}
