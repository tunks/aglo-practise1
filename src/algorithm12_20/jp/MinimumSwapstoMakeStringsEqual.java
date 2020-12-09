package algorithm12_20.jp;

public class MinimumSwapstoMakeStringsEqual {
    public int minimumSwap(String s1, String s2) {
        int missingCount = 0;
        int xCount = 0;
        for (int i=0; i<s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                // count mis-matches
                missingCount++;   
                // we need to count the mismatched x's (or the y's) in one of the strings
                if (s2.charAt(i) == 'x') {
                   xCount++;     
                }
            }
        }
         // no swap will fix this
        if (missingCount % 2 == 1) {
            return -1;           
        }
        // if we have an odd number of a particular letter 
        // it means we have one case of a 2-move swap.
        // for all other mismatches a single swap covers 2 mismatches.
        return  (missingCount / 2) + (xCount % 2);
   } 
}
