package algorithm12_20.jp;

/**
 * Given numBottles full water bottles, you can exchange numExchange empty water bottles for one full water bottle.

The operation of drinking a full water bottle turns it into an empty bottle.

Return the maximum number of water bottles you can drink.

https://leetcode.com/problems/water-bottles/
 * */
public class numWaterBottles {
	 public int numWaterBottles(int numBottles, int numExchange) {
	        int sum = numBottles;
	        while(numBottles >= numExchange)
	        {
	            sum += (numBottles/numExchange);
	            numBottles = (numBottles/numExchange) + (numBottles%numExchange);
	        }
	        return sum;
	    }
}
