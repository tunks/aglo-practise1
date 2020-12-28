package algorithm12_20.ms;
/**
 * 
 * Angle Between Hands of a Clock
 * 
 * Given two numbers, hour and minutes. Return the smaller angle (in degrees) formed between the hour and the minute hand.

Input: hour = 12, minutes = 30
Output: 165


Input: hour = 3, minutes = 30
Output: 75


Input: hour = 12, minutes = 0
Output: 0

https://leetcode.com/problems/angle-between-hands-of-a-clock/
 * */
public class AngleBetweenHandsofClock {
	   public double angleClock(int hour, int minutes) {
	        //1. minutes hand:
	        //   60 minutes --> 360 degeers
	        //   1 min -> 360/60 = 6 degrees 
	        
	         //2. Hour hand
	           // 12 hours --> 360 degrees
	           //  1 hours --> 360/12 = 
	             //convert hour to minute = 360/(12*60) degrees = 0.5 degree
	          if(hour<0 || minutes< 0 || minutes>60){
	             return 0; 
	          }
	        
	        if(minutes == 60)
	        {
	           minutes = 0;
	           hour++;
	        }
	        if(hour >12){
	           hour = Math.abs(12-hour);
	        }
	        if(hour == 12){
	           hour = 0;  
	        }
	        
	         double hourHand = 0.5 *(hour*60 + minutes); //change the hours to minutes
	         double minuteHand =  6.0 *minutes;  
	         double angle = Math.abs(hourHand-minuteHand);
	         return Math.min(360.0-angle, angle);
	    }
}
