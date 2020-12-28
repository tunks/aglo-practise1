package algorithm12_20.ms;

/**
 *
 * Implement strStr().

 strstr - locate a substring ( needle ) in a string ( haystack ). 
Try not to use standard library string functions for this question.

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

https://www.interviewbit.com/problems/implement-strstr/
 * 
 ***/
public class ImplementStrStr {
    public int strStr(final String A, final String B) {
        //abbabacis good
        //abc
        int i = 0;
        int j = 0;
        while(i< A.length() &&  j< B.length()){
            if(A.charAt(i) == B.charAt(j))
            {
               j++;    
            }
            else{
                if(j>0){
                   i = i-j;    
                   j = 0;  
                }
            }
             i++;
            if(j == B.length()){
               int index = i - j;
               return (index<0)? 0 : index;      
            }  
           
        }
   
        return -1;
    }
}
