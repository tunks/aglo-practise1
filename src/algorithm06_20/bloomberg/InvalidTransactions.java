package algorithm06_20.bloomberg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InvalidTransactions {
	  public class Transaction{
	        int index;
	        String name;
	        String city;     
	        int time;
	        int amount;

	        public Transaction(int index, String[] items){
	         this(index,items[0],items[3],
	           Integer.parseInt(items[1]), 
	           Integer.parseInt(items[2]));
	        }
	        
	        public Transaction( int index, String name, String city,
	                                int time, int amount){
	            this.index = index;
	            this.city = city;
	            this.name = name;
	            this.time = time;
	            this.amount = amount;
	        }
	    }
	  
	    public List<String> invalidTransactions(String[] transactions) {
	        Set<String> invalidTransactions = new  HashSet<String>();
	        Arrays.sort(transactions,(a,b)->{
	            String[] itemsA = a.split(",");
	            String[] itemsB = b.split(",");
	            if (itemsA[0].equals(itemsB[0])){
	            	Integer timeA = Integer.parseInt(itemsA[1]);
	            	Integer timeB =  Integer.parseInt(itemsB[1]);
	                return timeA.compareTo(timeB);
	            }
	           return a.compareTo(b);
	        });
	        
	        int i = 0;
	        List<Transaction> mappedTransactions = new ArrayList<Transaction>();
	        Map<String,int[]> indexMap = new HashMap<String,int[]>();
	        for(String transaction: transactions){
	            String[] items = transaction.split(",");
	            Transaction curr = new Transaction(i,items);
	            if(!indexMap.containsKey(curr.name)) {
	            	indexMap.put(curr.name, new int[] {i,i});
	            }
	            else {
	            	indexMap.get(curr.name)[1] = i;
	            }
	            
	            mappedTransactions.add(curr);	            
	            i++;
	        }
	        
	        for(Transaction curr: mappedTransactions) {
	        	 int[] index =  indexMap.get(curr.name);
	        	 for(int j = index[0]; j <= index[1]; j++) {
	        		 Transaction trans = mappedTransactions.get(j);
	        		 if(!trans.city.equals(curr.city) && Math.abs((curr.time - trans.time)) <=60 ){
	    	              invalidTransactions.add(transactions[curr.index]);
	    	              invalidTransactions.add(transactions[trans.index]);
	        		 }
	        		 
	        		 if(curr.amount > 1000){
	    	              invalidTransactions.add(transactions[curr.index]);
	    	         }
	                    
	        	 }
	        }
	        
	        return new ArrayList<String>(invalidTransactions);   
	    }
	    
	public static void main(String[] args) {
		/*String[] transacions = {"alex,741,1507,barcelona",
				                "xnova,683,1149,amsterdam",
				                "bob,52,1152,beijing",
				                "bob,137,1261,beijing",
				                "bob,607,14,amsterdam",
				                "bob,307,645,barcelona",
				                "bob,220,105,beijing",
				                "xnova,914,715,beijing",
				                "alex,279,632,beijing"};
				                */
		String[] transactions = {"bob,649,842,prague","alex,175,1127,mexico","iris,164,119,paris",
				                 "lee,991,1570,mexico","lee,895,1876,taipei","iris,716,754,moscow",
				                 "chalicefy,19,592,singapore","chalicefy,820,71,newdelhi",
				                 "maybe,231,1790,paris","lee,158,987,mexico","chalicefy,415,22,montreal",
				                 "iris,803,691,milan","xnova,786,804,guangzhou",
				                 "lee,734,1915,prague","bob,836,1904,dubai","iris,666,231,chicago",
				                 "iris,677,1451,milan","maybe,860,517,toronto","iris,344,1452,bangkok","lee,664,463,frankfurt",
				                 "chalicefy,95,1222,montreal","lee,293,1102,istanbul","maybe,874,36,hongkong",
				                 "maybe,457,1802,montreal","xnova,535,270,munich","iris,39,264,istanbul",
				                 "chalicefy,548,363,barcelona","lee,373,184,munich","xnova,405,957,mexico",
				                 "chalicefy,517,266,luxembourg","iris,25,657,singapore","bob,688,451,beijing",
				                 "bob,263,1258,tokyo","maybe,140,222,amsterdam","xnova,852,330,barcelona","xnova,589,837,budapest",
				                 "lee,152,981,mexico","alex,893,1976,shenzhen","xnova,560,825,prague","chalicefy,283,399,zurich",
				                 "iris,967,1119,guangzhou","alex,924,223,milan","chalicefy,212,1865,chicago","alex,443,537,taipei",
				                 "maybe,390,5,shanghai","bob,510,1923,madrid","bob,798,343,hongkong","iris,643,1703,madrid",
				                 "bob,478,928,barcelona","maybe,75,1980,shanghai","xnova,293,24,newdelhi","iris,176,268,milan","alex,783,81,moscow","maybe,560,587,milan","alex,406,776,istanbul","lee,558,727,paris","maybe,481,1504,munich","maybe,685,602,madrid","iris,678,788,madrid","xnova,704,274,newdelhi","chalicefy,36,1984,paris","iris,749,200,amsterdam","lee,21,119,taipei","iris,406,433,bangkok","bob,777,542,taipei","maybe,230,1434,barcelona","iris,420,1818,zurich","lee,622,194,amsterdam","maybe,545,608,shanghai","xnova,201,1375,madrid","lee,432,520,dubai","bob,150,1634,singapore","maybe,467,1178,munich","iris,45,904,beijing","maybe,607,1953,tokyo","bob,901,815,tokyo","maybe,636,558,milan","bob,568,1674,toronto","iris,825,484,madrid","iris,951,930,dubai","bob,465,1080,taipei","bob,337,593,chicago","chalicefy,16,176,rome","chalicefy,671,583,singapore","iris,268,391,chicago","xnova,836,153,jakarta","bob,436,530,warsaw","alex,354,1328,luxembourg","iris,928,1565,paris","xnova,627,834,budapest","xnova,640,513,jakarta","alex,119,16,toronto","xnova,443,1687,taipei","chalicefy,867,1520,montreal","alex,456,889,newdelhi","lee,166,3,madrid","bob,65,1559,zurich","alex,628,861,moscow","maybe,668,572,mexico","bob,402,922,montreal"};
		InvalidTransactions invalid = new InvalidTransactions();
		invalid.invalidTransactions(transactions);
	}

}
