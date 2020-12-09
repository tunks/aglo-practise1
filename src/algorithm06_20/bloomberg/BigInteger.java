package algorithm06_20.bloomberg;

import java.io.*;

public class BigInteger {
	private final int INTSIZ = 25;
	private int intArray[] = new int[INTSIZ];

	public void printBigInteger() {
		for (int i = 0; i < INTSIZ; i++) {
			System.out.print(intArray[i]);
		}
		System.out.println();
	}

	public BigInteger add(BigInteger biref) {
		BigInteger bisum = new BigInteger();
		int tmp, carry = 0;
		for (int i = (INTSIZ - 1); i >= 0; i--) {
			tmp = intArray[i] + biref.intArray[i] + carry;
			carry = tmp / 10;
			bisum.intArray[i] = tmp % 10;
		}

		return bisum;
	}

	private BigInteger clone(BigInteger biref) {
		BigInteger biclone = new BigInteger();
		for (int i = 0; i < INTSIZ; i++) {
			biclone.intArray[i] = biref.intArray[i];
		}

		return biclone;
	}

	public BigInteger subtract(BigInteger biref) {
		BigInteger bidifference = new BigInteger();
		BigInteger biclone = clone(this);
		int borrow = 0;
		for (int i = (INTSIZ - 1); i >= 0; i--) {
			if (biclone.intArray[i] < biref.intArray[i]) {
				biclone.intArray[i] = intArray[i] + 10;
				biclone.intArray[i - 1] = intArray[i - 1] - 1;
			}
			int tmp = biclone.intArray[i] - biref.intArray[i] - borrow;
			borrow = tmp / 10;
			bidifference.intArray[i] = tmp % 10;

		}

		return bidifference;
	}

	private void shift(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < INTSIZ; j++) {
				intArray[j - 1] = intArray[j];
			}
			intArray[INTSIZ - 1] = 0;
		}
	}

	public BigInteger multiply(BigInteger biref)
    {
//        BigInteger bitmp = new BigInteger(this);
//        BigInteger product = new BigInteger(); //to store result
//        int carry = 0;
//        for(int i=INTSIZ-1; i>=0; i--)
//        {
//            for(int j=INTSIZ-1; i>=0; i--)
//            {
//
//            }
//
//            bitmp = bitmp.shift(INTSIZ-1-i); ?++
//
//            //two lines of code
//            //method called shift and then add
//
//            int tmp = (intArray[i]+carry)*biref.intArray[i];
//            carry = tmp/10;
//            product.intArray[i] = tmp%10;
//        }
//
//        return product;
		return null;
    }

	// don't worry about the implementation of this method. We haven't
	// covered some of the String methods below, but will ... very soon!
	public void inputBigInteger() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("enter the BigInteger: (do not pad with zeros): ");
		String str = input.readLine();

		if (str.length() > INTSIZ)
			throw new ArithmeticException("OVERFLOW!");

		for (int i = 0; i < str.length(); i++) {
			intArray[INTSIZ - str.length() + i] = Integer.parseInt(str.substring(i, i + 1));
		}
	}

	public static void main(String argv[]) throws IOException {
		BigInteger b1, b2, b3;

		b1 = new BigInteger();
		b2 = new BigInteger();

		System.out.println("input the first BigInteger:");
		b1.inputBigInteger();
		System.out.println("input the second BigInteger:");
		b2.inputBigInteger();

		System.out.print("BigInt #1: ");
		b1.printBigInteger();
		System.out.print("BigInt #2: ");
		b2.printBigInteger();
		System.out.println("            =========================");
		b3 = b1.add(b2);
		System.out.print("SUM:        ");
		b3.printBigInteger();
		System.out.println();

		System.out.print("BigInt #1: ");
		b1.printBigInteger();
		System.out.print("BigInt #2: ");
		b2.printBigInteger();
		System.out.println("            =========================");
		b3 = b1.subtract(b2);
		System.out.print("DIFFERENCE: ");
		b3.printBigInteger();
		System.out.println();

		System.out.print("BigInt #1: ");
		b1.printBigInteger();
		System.out.print("BigInt #2: ");
		b2.printBigInteger();
		System.out.println("            =========================");
		b3 = b1.multiply(b2);
		System.out.print("PRODUCT:    ");
		b3.printBigInteger();
		System.out.println();
	}
}