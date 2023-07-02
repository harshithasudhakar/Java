// Prime Number

import java.util.Scanner;

class PrimeNumber{
	void checkIfPrime(int n){
		int count=0;
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
		}
		else{
			System.out.println("The number is a composite number");
		}
	}
	
	public static void main(String[] args){
		Scanner input= new Scanner(System.in);
		int n= input.nextInt();
		PrimeNumber obj = new PrimeNumber();
		obj.checkIfPrime(n);
	}
}