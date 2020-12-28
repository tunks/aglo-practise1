package algorithm12_20.ms;

/**
 * 
 *  Trapping Rain Water
Hard

9163

140

Add to List

Share
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9 
 */
public class TrappingRainWater {
	//Two pointers
	public int trap(int[] height) {
    
        int maxArea = 0;
        int l = 0;
        int lMax = 0;
        int r = height.length-1;
        int rMax = 0;
        while ( l < r ) {
        	//1. If current left is less than the right ,
        	//then check the maximum of the current left and the left maximum
        	//get the new area = lMax - current left
        	//add the new area to the maxArea
            if (height[l] < height[r]) {        
                lMax = Math.max(lMax, height[l]);
                maxArea += lMax - height[l];
                l++;
            }
            else {     
              	//2. If current left is equals or greater than the right ,
            	//then check the maximum of the current right and the right maximum
            	//get the new area = rMax - current right
            	//add the new area to the maxArea
                rMax = Math.max(rMax, height[r]);
                maxArea += rMax - height[r];
                r--;
            }
        }
    
        return maxArea;
    }
}
