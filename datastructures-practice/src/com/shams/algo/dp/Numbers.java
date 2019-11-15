package com.shams.algo.dp;

public class Numbers {

	public static void main(String[] args) {

		int n = 10;
		System.out.println(new Numbers().factorial(n));
		System.out.println(new Numbers().factorialMemo(n));
	}
	
	long factorial(int n) {
		long fact = 1;
		if (n == 0) return 1;
		fact *= n * factorial(n - 1);
		return fact;
	}
	
	long factorialMemo(int n) {
		long [] mem = new long[n+1];
		mem[0] = 1;
		if (n == 0 || n == 1) return mem[0];
		if (mem[n] != 0) return mem[n];
		else mem[n] = n * factorial(n - 1); 
		return mem[n];
	}

}
