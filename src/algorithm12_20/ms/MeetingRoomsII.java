package algorithm12_20.ms;

import java.util.Arrays;

/**
 * 
 * 
 * Meeting Rooms II
Medium

3189

52

Add to List

Share
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
 * */
public class MeetingRoomsII {
	 public int minMeetingRooms(int[][] intervals) {
	        int[] startTimes = new int[intervals.length];
	        int[] endTimes = new int[intervals.length];
	        //[[0, 30],[5, 10],[15, 20]] 
	        //1. i, startTimes = [0,5,20], i=0, j=0,i++ 
	        //2. j, endTimes = [10,20,30]  i=1,j=0, i++
	        //   i=2,j=0,i++,
	        for(int i = 0; i < intervals.length; i++) {
	            startTimes[i] = intervals[i][0];
	            endTimes[i] = intervals[i][1];
	        }
	        
	        Arrays.sort(startTimes);
	        Arrays.sort(endTimes);
	        
	        int count = 0;
	        int i = 0;
	        int j = 0;
	        
	        while(i < intervals.length && j < intervals.length) {
	            //increase count if endTimes is greater than startTimes, 
	            if(endTimes[j] > startTimes[i]) {
	                count++;
	            } else {
	                j++;
	            }
	            i++;
	        }
	        
	        return count;
	    }
}
