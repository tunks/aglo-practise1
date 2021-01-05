package algorithm12_20.ms;

public class ShortestPalindrome {
	public String shortestPalindrome(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        for(int i = n - 1; i >= 0; i--) {
            if(isPalin(arr, i)) {
                sb.append(s);
                return sb.toString();
            } else {
                sb.append(arr[i]);
            }
        }
        
        return s;
    }
    
    public boolean isPalin(char[] s, int end) 
    {
        int i = 0;
        int j = end;
        while(i <= j) {
            if(s[i] == s[j]) {
                i++;
                j--;
            } else return false;
        }
        
        return true;
    }
}
