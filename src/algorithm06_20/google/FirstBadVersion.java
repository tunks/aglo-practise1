package algorithm06_20.google;

/**
 * 
 *  You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example:

Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version. 

https://leetcode.com/problems/first-bad-version/
 */
//public class FirstBadVersion  extends VersionControl {
//   public int firstBadVersion(int n) {
//    // 1,2,3,4,5
//    // g g g b b
//    // 5+1=(h+l)/2 -> mid=3
//   // if mid is good,  then (mid-1, high)
//    // if mid is bad and mid-1 is bad,  then(low,mid);
//       // if (mid is bad) || (mid-1 is good && mid>=1){
//   
//       
//     
//       
//    
//       //int version = binarySearch(1,n);
//       int version = binarySearch2(n);
//       return version;
//   }
//   
//   private int binarySearch(int low, int high)
//   {
//       if(low<high && low>=1){
//          int mid = low + (high-low)/2;
//          if(!isBadVersion(mid)){
//             return  binarySearch(mid+1,high);
//          }    
//          else if(isBadVersion(mid) && isBadVersion(mid-1)){
//             return binarySearch(low,mid-1);  
//           }
//           return mid;
//       }
//       return low;
//   }
//   
//   private int binarySearch2(int n){
//       int low = 1;
//       int high = n;
//       int mid = low;
//       while(low < high && low>=1){
//           mid = low + (high - low)/2;
//           if(!isBadVersion(mid)){
//               low = mid + 1;
//           }
//           else{
//               high = mid;
//           }
//       }
//       return low;
//   }
//}
