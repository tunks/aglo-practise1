package algorithm11_20.amazon.interviewbit;

public class Power {
	 public static int pow(int x, int n, int d) {
	        int p = 1;
	        for(int i =1; i <= n; i++){
	             p = p * x;
	        }
	        
	        return (p <0)? (p + d) %d :p % d;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int p= pow(-1,1,20);
        System.out.println("2).res: "+p);


	}

}
