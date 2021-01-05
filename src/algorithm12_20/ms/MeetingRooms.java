package algorithm12_20.ms;

import java.util.Arrays;

/*
 * 
 * Meeting Rooms

Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.

 

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: false
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: true
 

Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti < endi <= 106
https://leetcode.com/problems/meeting-rooms/
**/


public class MeetingRooms {
	 public boolean canAttendMeetings(int[][] intervals) 
	    {
	        Arrays.sort(intervals,(a,b)->{
	            return a[0] - b[0];
	        });
	        int i=0;
	        int j=1;
	        while(i<intervals.length &&j< intervals.length){
	           if(isOverLapped(intervals, i,j))
	           {
	               return false;
	           }
	            i++;
	           j++;
	        }
	      return true; 
	    }
	    
	    private boolean isOverLapped(int[][] intervals, int i, int j){
	        if(intervals[i][0] <intervals[j][0]  && intervals[i][1]<=intervals[j][0])
	        {
	            return false;
	        }
	        return true;
	    }
}
