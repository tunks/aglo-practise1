package algorithm12_20.ms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
	   private Random random = new Random();
	    private Map<Integer,Integer> valueMap = new HashMap<Integer,Integer>();
	    private List<Integer> indexList = new ArrayList<Integer>();

	    /** Initialize your data structure here. */
	    public RandomizedSet() {
	        
	    }
	    
	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    public boolean insert(int val) {
	        if(!valueMap.containsKey(val))
	        {
	            int index = indexList.size();
	            indexList.add(index,val);
	            valueMap.put(val,index);
	            return true;
	        }
	        return false;
	    }
	    
	    /** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	        if(valueMap.containsKey(val))
	        {
	            //get the index of the last elment in the last
	             int size = indexList.size();
	             int lastValue = indexList.get(size-1); 
	             int index = valueMap.get(val);  
	             indexList.set(index,lastValue);
	             valueMap.put(lastValue,index);
	             indexList.remove(size-1);
	             valueMap.remove(val);
	             return true;   
	        }
	        return false;     
	    }
	    
	    /** Get a random element from the set. */
	    public int getRandom() {
	        return getRandomNumber();
	    }
	    
	    private int getRandomNumber()
	    {
	        int index = random.nextInt(indexList.size());
	        return indexList.get(index);
	    }
}
