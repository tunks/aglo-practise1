package algorithm12_20.ms;

/*
 * 
 * umber of Ways to Split a String
Medium

206

34

Add to List

Share
Given a binary string s (a string consisting only of '0's and '1's), we can split s into 3 non-empty strings s1, s2, s3 (s1+ s2+ s3 = s).

Return the number of ways s can be split such that the number of characters '1' is the same in s1, s2, and s3.

Since the answer may be too large, return it modulo 10^9 + 7.

 

Example 1:

Input: s = "10101"
Output: 4
Explanation: There are four ways to split s in 3 parts where each part contain the same number of letters '1'.
"1|010|1"
"1|01|01"
"10|10|1"
"10|1|01"
Example 2:

Input: s = "1001"
Output: 0
Example 3:

Input: s = "0000"
Output: 3
Explanation: There are three ways to split s in 3 parts.
"0|0|00"
"0|00|0"
"00|0|0"
Example 4:

Input: s = "100100010100110"
Output: 12
 

Constraints:

3 <= s.length <= 10^5
s[i] is '0' or '1'. 	
 * */
public class NumberofWaystoSplitString {
	private static int MOD_INTEGER;
    static{
       MOD_INTEGER = 1000000007;  
    }

    public int numWays(String s) 
    {
      int len = s.length();
        if (len < 3) {
            return 0;
        }
      //Count the number of 1
      int numOfOnes = 0;
      int result = 0;
      List<Integer> list = new ArrayList<Integer>();
      for(int i = 0; i <s.length(); i++){
          if(s.charAt(i) == '1'){
             numOfOnes++;
             //list.add(i);
          }
      }  
      //check if the number of ones is no divisble by 3
      if(numOfOnes%3 != 0)
      {
         return 0; 
      }  
    //if the number of ones is zero, then use the formular
      else if(numOfOnes == 0){
          result =  (int) ((len-1)*(len-2)/2 % MOD_INTEGER);      
      }
      else{
          long leftSplitCount =0;
          long rightSplitCount =0;
          int groupCount = numOfOnes/3;  
          int count = 0;
          for(int i =0 ; i<len; i++)
          {
              if(s.charAt(i) == '1')
              {
                  count++;
              } 
              
              if(count == groupCount )
              {
                 leftSplitCount++; 
              }
              else if(count == 2* groupCount)
              {
                  rightSplitCount++;
              }
          }
          
          /*
          leftSplitCount = list.get(groupCount) - list.get(groupCount-1); 
          rightSplitCount = list.get(2* groupCount) -list.get(2*groupCount-1);
          */
          result = (int)(leftSplitCount * rightSplitCount %MOD_INTEGER);
      }
      return result;
    }
}
