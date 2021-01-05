package algorithm12_20.ms;

/**
 * 
 * Generate Parentheses
Medium

6722

305

Add to List

Share
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 * */
public class GenerateParentheses {
	  public List<String> generateParenthesis(int n) {
	        /*List<String> res= new ArrayList<>();
	        helper(n, res, 0,0,"");
	       //O(n^4)
	        return res;
	        */
	       
	        return generateParenthesis2(n);
	    }
	    
	    public void helper(int n, List<String> res, int open, int close, String curr){
	        if(curr.length()==2*n) {
	            res.add(curr);
	        }
	        if(open<n) {
	            helper(n,res,open+1,close, curr+"(");
	        }
	        if(close<open){   
	         helper(n,res,open,close+1, curr+")");
	        }
	    }
	    
	    
	    
	    public List<String> generateParenthesis2(final int n) {
	        if (n == 0) {
	            return Collections.emptyList();
	        }
	        var result = new ArrayList<String>();
	        var queue = new ArrayDeque<Parenthesis>();
	        queue.offer(new Parenthesis(0, 0, ""));
	        while (!queue.isEmpty()) {
	            var current = queue.poll();
	            int opening = current.openingCount;
	            int closing = current.closingCount;
	            String bracket = current.bracket;
	            if (opening == n && closing == n) {
	                result.add(bracket);
	            }
	            else{
	                if (opening < n) {
	                    queue.offer(new Parenthesis(opening + 1, closing, bracket + "("));
	                }
	                if (opening > closing) {
	                    queue.offer(new Parenthesis(opening, closing + 1, bracket + ")"));
	                }
	            }
	        }
	        return result;
	    }

	    private static class Parenthesis {
	        int openingCount;
	        int closingCount;
	        String bracket;

	        Parenthesis(int openingCount, int closingCount, String bracket) {
	            this.openingCount = openingCount;
	            this.closingCount = closingCount;
	            this.bracket = bracket;
	        }
	    }
}
