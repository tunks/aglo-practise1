package algorithm11_20.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {

   public static void main( String args[] ) {
      // String to be scanned to find the pattern.
      String line = "[\"CHARGE: card_country=US&currency=USD&amount=150&ip_country=CA\",\"ALLOW:amount<100\",\"BLOCK:card_country != ip_country AND amount > 100\",]";
      String pattern = "([^\"]+\\w+[:|>|<|>=|<=|=|=|!=_|\\w+|=|&|!=|-]*)";//"[^\"]+\\w+[:|>|<|>=|<=|=|=|!=_|\\w+|=|&|!=|-]?";
      
      //Note:  ([^"]\w+[:|>|<|>=|<=|=|=|!=_|\w+|=|&|!=|-]?) ---will create multiple matches with ()

      // Create a Pattern object
      Pattern r = Pattern.compile(pattern);

      // Now create matcher object.
      Matcher m = r.matcher(line);
      if (m.find( )) {
         System.out.println("Found value: " + m.group(0) );
         System.out.println("Found value: " + m.group(1) );
         System.out.println("Found value: " + m.group(2) );
      }else {
         System.out.println("NO MATCH");
      }
   }
}