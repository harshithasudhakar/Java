//Pascal's Triangle

/*
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1
1 5 10 10 5 1
 
*/

import java.util.Scanner;

class PascalsTriangle{
	
	void pTriangle(int n){
		int count=1;
		System.out.println("1");
		System.out.println("1"+" 1");
		for(int i=1;i<=n;i++){
			System.out.println("1");
			for(int j=1;j<=i;j++){
				System.out.print();
			}
			System.out.println("1");
			System.out.println("");
		}
	}
		
	public static void main(String[] args){
		Scanner input= new Scanner(System.in);
		int n= input.nextInt();
		PascalsTriangle obj = new PascalsTriangle();
		obj.pTriangle(n);
	}
}