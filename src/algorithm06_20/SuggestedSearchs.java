package algorithm06_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings products and a string searchWord. 
 * We want to design a system that suggests at most three product names from products after each character of searchWord is typed. 
 * Suggested products should have common prefix with the searchWord. 
 * If there are more than three products with a common prefix return the three lexicographically minimums products.

Return list of lists of the suggested products after each character of searchWord is typed. 

 

Example 1:

Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
Output: [
["mobile","moneypot","monitor"],
["mobile","moneypot","monitor"],
["mouse","mousepad"],
["mouse","mousepad"],
["mouse","mousepad"]
]
Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
Example 2:

Input: products = ["havana"], searchWord = "havana"
Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
 * */
public class SuggestedSearchs {

	public List<List<String>> search(String[] products, String searchWord ){	
	     Arrays.sort(products);
	     List<List<String>> result = new ArrayList<List<String>>();
	     for(int i = 0; i < searchWord.length(); i++) {
	         ArrayList<String> subres = new ArrayList<String>(); 
	         int count = 0;
	    	 for(int j = 0; j < products.length && count < 3; j++) {
	    		if(products[j].startsWith(searchWord.substring(0,i+1))) {
	    			subres.add(products[j]);	
	    			count++;
	    		}
	    	 }
	    	 result.add(subres);
	     }
		return result;
//		  Arrays.sort(products);
//	        int index = 0;
//	        List<List<String>> res = new ArrayList<>(); 
//	          
//	        while(index <searchWord.length()){
//	          String substr = searchWord.substring(0,index+1); 
//	          //System.out.println("substring "+substr);
//	          ArrayList<String> subres = new ArrayList<String>(); 
//	          int count =0;
//	          for(int i=0;i<products.length && count<3;i++){
//	            if (products[i].startsWith(substr,0)){
//	             subres.add(products[i]);
//	             count++;   
//	            }
//	          }
//	          res.add(subres);  
//	          index ++;    
//	    }
//	    return res;  
	}



	public static void main(String args[]) {
		String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
		String searchWord = "mouse";
		SuggestedSearchs suggested = new SuggestedSearchs();
		List<List<String>> result = suggested.search(products, searchWord);
		for(List<String> res: result) {
			System.out.println(res);
		}
	}
	
}
