package algorithm12_20.ms;

/**
 * 
 * Find the Celebrity
Medium

1320

151

Add to List

Share
Suppose you are at a party with n people (labeled from 0 to n - 1), and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know him/her, but he/she does not know any of them.

Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information about whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).

You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n). There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.

 

Example 1:


Input: graph = [[1,1,0],[0,1,0],[1,1,1]]
Output: 1
Explanation: There are three persons labeled with 0, 1 and 2. graph[i][j] = 1 means person i knows person j, otherwise graph[i][j] = 0 means person i does not know person j. The celebrity is the person labeled as 1 because both 0 and 2 know him but 1 does not know anybody.
 * */
public class FindCelebrity {
	  public int findCelebrity(int n) {
	       //0 -> n-1
	       //n =3, 0,1,2 
	        /**
	        1. Check each number with all other numbers if the number is known
	         brute force
	        */
	        /*for(int i = 0; i< n; i++){
	            if(findCelebrity(i,n)){
	                return i;
	            }
	        }
	        
	        return -1;
	        */
		  //2. Candidate connection
	        int candidate = 0;
	        for(int i = 0; i< n; i++){
	              if(knows(candidate,i)){
	                 candidate = i; 
	              }
	        }
	        if(findCelebrity(candidate,n)){
	           return  candidate;
	        }
	        return -1;
	    }
	    
	    boolean findCelebrity(int i, int n){
	         for(int j = 0; j < n; j++){
	             if(j == i){
	                continue; 
	             }
	             if(knows(i,j) || !knows(j,i)){
	                return false; 
	             }
	         }
	        return true;
	    }
}
