package algorithm11_20.dailycodingproblem;

/**
 * 
 * This problem was asked by Facebook.
 *
 * Given a string and a set of delimiters, 
 * reverse the words in the string while maintaining the relative order of the delimiters. 
 * For example, given "hello/world:here", return "here/world:hello"
 * 
 * 1. Follow-up: Does your solution work for the following cases: "hello/world:here/"  "hello//world:here 
 */
public class WordReverseDelimiter {
  public String revereWordDelimiter(String text) {
	   StringBuilder leftStr = new StringBuilder();
	   StringBuilder rightStr = new StringBuilder();
      
	   int i = 0, left = 0;
	   int j = text.length() - 1, right= j;
	   
	   while(i < j) {
		   System.out.println("1). i Index: "+i + ", j Index: "+j);

		   while((text.charAt(i) !=  '/' && text.charAt(i) !=  ':') && (i <= j)) {
			   leftStr.insert(i,text.charAt(i));
			   i++;
		   }
		   System.out.println("2). i Index: "+i + ", j Index: "+j);
           while((text.charAt(j) !=  '/' && text.charAt(j) !=  ':') && (i<= j)) {
        	   rightStr.insert(0, text.charAt(j));
			   j--;
		   }
		   System.out.println("3). i Index: "+i + ", j Index: "+j);

           while((text.charAt(i) ==  '/' || text.charAt(i) ==  ':') && (i < j)) {
        	   rightStr.append(text.charAt(i));
			   i++;
		   }
		   
		   System.out.println("4). i Index: "+i + ", j Index: "+j);

           while((text.charAt(j) ==  '/' || text.charAt(j) ==  ':') && (i< j)) {
        	   leftStr.insert(0,text.charAt(j));
			   j--;
		   }
//           i++;
//           j--;
	   }
	   
	   System.out.println("LeftStr: "+leftStr.toString());
	   System.out.println("RightStr: "+rightStr.toString());

	  return null;
  }
  
  
  public static void main(String[] arg) {
	  WordReverseDelimiter wordReverse = new WordReverseDelimiter();
	  String text = "hello/world:here:test/today";
	  wordReverse.revereWordDelimiter(text);
	  
  }
}
