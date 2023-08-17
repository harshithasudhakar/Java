//Factorial of a number

import java.util.Scanner;

class Factorial{
	void factorialOfNum(int n){
		int fact = 1;
		while(n>0){
			fact=fact*n;
			n--;
		}
		System.out.println(fact);
	}
	
	public static void main(String[] args){
		Scanner input= new Scanner(System.in);
		int n= input.nextInt();
		Factorial obj = new Factorial();
		obj.factorialOfNum(n);
	}
}
