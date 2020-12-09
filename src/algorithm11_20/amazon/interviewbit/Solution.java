package algorithm11_20.amazon.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static int findMedian(List<List<Integer>> A) {
        int len1 = A.size();
        int len2 = A.get(0).size();
        int firstNum = A.get(0).get(0);
        int lastNum = A.get(len1-1).get(len2-1);
        int avgNum = (lastNum + firstNum)/2;
        System.out.println("avgNum: "+avgNum);
        int diff = Integer.MAX_VALUE;
        int medium = 0;
        for(int i = 0; i< len1; i++){
            List<Integer> list = A.get(i);
            for(int j = 0; j< len2; j++){
                int num = Math.abs(list.get(j) - avgNum);
                System.out.println("num("+i+")("+j+"),  avgNum "+avgNum);
                if(num  < diff){
                   medium = list.get(j);
                   diff = num;
                }
            }
        }
        return medium;
    }
    
    public static void main(String[] args) {
	    	/**
	    	 * [
	  [1, 3, 5]
	  [2, 6, 9]
	  [3, 6, 9]
	]
    	 * */
     Integer[][] numbers = {{1,3,5},{2,6,9},{3,6,9}};
     List<List<Integer>> list = new ArrayList<List<Integer>>();
     for(int i = 0;i < numbers.length; i++) {
    	 list.add(Arrays.asList(numbers[i]));
     }
     
     int mid = findMedian(list);
     System.out.println("findMedium() : "+mid);
     
    }
}