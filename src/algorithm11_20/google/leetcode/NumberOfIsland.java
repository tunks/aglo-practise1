package algorithm11_20.google.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleEntry;
import java.util.Queue;

public class NumberOfIsland {
	public int numberOfIslands(ArrayList<ArrayList<Character>> grid) {
	    List<Entry<Integer,Integer>> entries = new ArrayList<Entry<Integer,Integer>>();
        //1. insert all '1' points to the entries
        for(int i = 0; i < grid.size(); i++){
           for(int j = 0; j< grid.get(i).size(); j++)
           {
              if(grid.get(i).get(j) == '1' ){
                 entries.add(new SimpleEntry<Integer,Integer>(i,j));
              }
           }  
       }
        
        
      //2. set the constant 4 directions
      int[][] directions = {{1,0}, {0,1},{-1,0},{0,-1}};
      int count = 0;
      //3. Iterate through the entries
      //4. maintain a queue visit list
      Queue<Entry<Integer,Integer>> visits 
      = new LinkedList<Entry<Integer,Integer>>();
      for(Entry<Integer,Integer> entry: entries){
          visits.offer(entry);
          if(grid.get(entry.getKey()).get(entry.getValue()) != '1')
             continue;
          
          while(!visits.isEmpty()){
              Entry<Integer,Integer> en = visits.poll();
              for(int[] dir: directions) 
              {
                  int r = dir[0] + en.getKey();
                  int c = dir[1] + en.getValue();
                  if( r<0 || r>= grid.size() || c<0 || c >= grid.get(r).size())
                     continue;
                  
                  if(grid.get(r).get(c) == '1')
                  {
                      visits.offer(new SimpleEntry<Integer,Integer>(r,c)); 
                      grid.get(r).set(c,'2');
                  } 
              }
          }
          count+=1;
        }
       return count;
	}
}
