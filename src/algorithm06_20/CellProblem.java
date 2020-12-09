package algorithm06_20;

public class CellProblem {
	
	  public static int[] cellCompete(int[] states, int days)
	  {
		int size = states.length;
	    int items[]= new int[size];
	    //copy the  original states in a temporal array
	    for (int i = 0; i < size ; i++ ){
	        items[i] = states[i];
	    }
	    for (int k = 0; k < days ; k++ ){
	        for (int j = 1; j < size - 1 ; j++ ){
	        	//check the adj states
	            if (((items[j-1] == 0 && items[j+1] == 0)) || (items[j-1] == 1 && items[j+1] == 1) ){
	                states[j] = 0;
	            } else{
	                states[j] = 1;
	            }
	        }
	        if (items[1] == 0){
	            states[0] = 0;
	        } else{
	            states[0] = 1;
	        }
	        if (items[6] == 0){
	            states[7] = 0;
	        } else{
	            states[7] = 1;
	        }
	        for (int i = 0; i < size ; i++ ){
	            items[i] = states[i];
	        }
	    } 
	    return states;
	  }
	  
	  public static void main(String [] args) {
		  int[] result = cellCompete(new int[]{1,0,0,0,0,1,0,0},1);
		  for(int i = 0; i< result.length; i++) {
			  System.out.print(result[i] +" ");
		  }
		  System.out.println("test2");

		  result = cellCompete(new int[]{1,1,1,0,1,1,1,1},2);
		  for(int i = 0; i< result.length; i++) {
			  System.out.print(result[i] +" ");
		  }
	  }
}
