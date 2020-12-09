package algorithm06_20.bloomberg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtreeSum {

	//1. recursive
	public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        frequentTreeSum(root,map);
        int max = 0;
        for(int value : map.values()){
            max = Math.max(max,value);
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int key: map.keySet()){
            int value = map.get(key);
            if(value == max){
               list.add(key);
            }
        }
        int[] result = new int[list.size()];
        for(int i =0; i< list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
  }
  
	//2. TODO-- DFS
  
  private int frequentTreeSum(TreeNode node, Map<Integer,Integer> map){
        if(node != null){  
           if(node.left == null && node.right == null){
              map.put(node.val,map.getOrDefault(node.val,0) + 1);
              return node.val;
           }
           
           int lValue = frequentTreeSum(node.left,map);
           int rValue = frequentTreeSum(node.right,map);
           
           int sum = 0;
           if(node.left != null || node.right != null){
              sum = node.val + lValue + rValue;
              map.put(sum,map.getOrDefault(sum,0) + 1);
           }
           return sum; 
                
        }
      return 0;
  }
}
