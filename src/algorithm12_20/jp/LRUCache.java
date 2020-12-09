package algorithm12_20.jp;

import java.util.LinkedHashMap;

/***
 * 
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
Follow up:
Could you do get and put in O(1) time complexity?

 

Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
 

Constraints:

1 <= capacity <= 3000
0 <= key <= 3000
0 <= value <= 104
At most 3 * 104 calls will be made to get and put. 
 */
public class LRUCache {
	  private LinkedHashMap<Integer,Integer> linkedMap;
	    private int capacity;
	    public LRUCache(int capacity) {
	        this.capacity = capacity;
	        linkedMap = new LinkedHashMap<Integer,Integer>();
	    }
	    
	    public int get(int key) {
	        int value = -1;
	        //check if key exists and remove it, 
	        //then insert it the link to the last position
	        if(linkedMap.containsKey(key)){
	           value = linkedMap.remove(key); 
	           linkedMap.put(key,value);
	        }
	        return value;
	    }
	    
	    public void put(int key, int value) {
	         //check if key exists and remove it, 
	        //then insert it the link to the last position
	        if(linkedMap.containsKey(key))
	        {
	            linkedMap.remove(key);
	        }
	        else if(linkedMap.size() == capacity)
	        { 
	            //if key does not exits and size is capacity, then remove the key
	          int firstKey = getFirstKey(); 
	           if(firstKey != -1)
	           {
	              linkedMap.remove(firstKey);
	           }
	            
	        }
	        linkedMap.put(key,value);
	    }
	    
	    //get the first key in the hash key set
	    private int getFirstKey()
	    {
	        for(int key: linkedMap.keySet())
	        {
	              return key;
	        }
	        return -1;
	    }
}
