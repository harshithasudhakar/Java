//Pattern-1

/*

*
**
***
****
*****

*/

import java.util.Scanner;

class Pattern{
	void printpattern1(int n){
		String ch="*";
		for(int i=1;i<=n;i++){
			for(int j=1;j<=i;j++){
				System.out.print(ch);
			}
			System.out.println("");
		}
	}
	public static void main(String[] args){
		Scanner input= new Scanner(System.in);
		int n= input.nextInt();
		Pattern obj = new Pattern();
		obj.printpattern1(n);
	}
}

//Pattern-2
/*
1
2 3
4 5 6
7 8 9 10
11 12 13 14
*/

import java.util.Scanner;

class Pattern{
	void printpattern1(int n){
		int num=1;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=i;j++){
				System.out.print(num++ +" ");
			}
			System.out.println("");
		}
	}
	public static void main(String[] args){
		Scanner input= new Scanner(System.in);
		int n= input.nextInt();
		Pattern obj = new Pattern();
		obj.printpattern1(n);
	}
}

//Pattern-3
/*
     1
    2 3
   4 5 6
  7 8 9 10
 11 12 13 14 15
 
*/

import java.util.Scanner;

class Pattern{
	
	void printpattern1(int n){
		int num=1;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n-i;j++){
				System.out.print(" ");
			}
			for (int k=1; k<=i; k++) {
                System.out.print(num+ " ");
                num++;
            }
			System.out.println();
		}
	}
		
	public static void main(String[] args){
		Scanner input= new Scanner(System.in);
		int n= input.nextInt();
		Pattern obj = new Pattern();
		obj.printpattern1(n);
	}
}
