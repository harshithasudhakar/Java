//Fibonacci Series of 'n' Numbers

import java.util.Scanner;

class FibonacciSeries{
	void fib(int n){
		int t1=0;
		int t2=1;
		int t3=1;
		System.out.println("The series is: 0, 1, 1...");
		for(int i=3;i<n;i++){
			t3=t2+t1;
			t1=t2;
			t2=t3;
			System.out.println(t3);
		}
	}
	
	public static void main(String[] args){
		Scanner input= new Scanner(System.in);
		int n = input.nextInt();
		FibonacciSeries obj = new FibonacciSeries();
		obj.fib(n);
	}
}
