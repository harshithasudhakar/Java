// Prime Number

import java.util.Scanner;

class PrimeNumber{
	boolean checkIfPrime(int n){
		int count=0;
		if(n <= 1){
			throw new IllegalArgumentException("Invalid input.");
		}
		for(int i=1;i<=n;i++){
			if(n%i==0){
				count+=1;
			}
			else{
				continue;
			}
		}
		if(count<=2){
			System.out.println("The number is a prime number");
			return true;
		}
		else{
			System.out.println("The number is a composite number");
			return false;
		}
	}
	
	public static void main(String[] args){
		Scanner input= new Scanner(System.in);
		int n= input.nextInt();
		PrimeNumber obj = new PrimeNumber();
		obj.checkIfPrime(n);
	}
}
