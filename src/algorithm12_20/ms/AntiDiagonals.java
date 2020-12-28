package algorithm12_20.ms;

import java.util.ArrayList;

/**
 * 
 * Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.

Example:

		
Input: 	

1 2 3
4 5 6
7 8 9

Return the following :

[ 
  [1],
  [2, 4],
  [3, 5, 7],
  [6, 8],
  [9]
] 
https://www.geeksforgeeks.org/return-an-array-of-anti-diagonals-of-given-nn-square-matrix/
 **/
public class AntiDiagonals {
	public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        if(A.isEmpty()){
           return new ArrayList<ArrayList<Integer>>();    
        }
        
       int len = 2 * A.size() - 1;
       ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
       for(int i = 0; i< len; i++){
           result.add(new ArrayList<Integer>());
       }
       
       for(int i = 0; i < A.size(); i++){
           for(int j = 0; j < A.get(i).size(); j++){
               result.get(i+j).add(A.get(i).get(j));
           }
       }
       /* Queue<Entry<Integer,Integer>> queue = new LinkedList<Entry<Integer,Integer>>();
        queue.add(new SimpleEntry<Integer,Integer>(0,0));
    
        Entry<Integer,Integer> entry;
        int[][] directions = {{0,1},{1,0}};
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        Set<Entry<Integer,Integer>> visits = new HashSet<Entry<Integer,Integer>>();
        
        while(!queue.isEmpty()){
            int size =  queue.size();
            list = new ArrayList<Integer>(); 
            while(size>0){
                entry = queue.poll();
                int row = entry.getKey();
                int col = entry.getValue();
                for(int[] d: directions){
                    int r = row + d[0];
                    int c = col + d[1];
                    if(r>=0 && r< A.size() && c>=0 && c< A.get(r).size())
                    {
                      
                      Entry<Integer,Integer> en  = new SimpleEntry<Integer,Integer>(r,c);
                      if(!visits.contains(en))
                      {
                         queue.add(en);   
                         visits.add(en);
                      }
                    }
                } 
                
                list.add(A.get(row).get(col));
                
                size--;    
            }
            if(!list.isEmpty())
            {
               result.add(list);
            }
            
        }
        */
        
        return result;
    }
}
