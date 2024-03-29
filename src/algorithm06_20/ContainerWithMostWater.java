package algorithm06_20;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

 Input: [1,8,6,2,5,4,8,3,7]
Output: 49

https://leetcode.com/problems/container-with-most-water/
 * */
public class ContainerWithMostWater {
	 public int maxArea(int[] height) {
	     
	        int i =0;
	        int j = height.length -1;
	        int width = 0;
	        int area = 0;
	        int maxArea = 0;
	        while(i < j){
	            width = j - i;
	            if(height[i] <=height[j]){
	               area = width * height[i];
	               i++;
	            }
	            else{
	               area = width * height[j];
	                j--;
	            }
	            maxArea = Math.max(maxArea,area);
	        }
	        
	        return maxArea;
	    }
}
