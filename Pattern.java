//Pattern-1

/*

*
**
***
****
*****

*/

class Pattern{
	void printPattern1(int n){
		String ch="*";
		for(int i=1;i<=n;i++){
			for(int j=1;j<=i;j++){
				System.out.print(ch);
			}
			System.out.println("");
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
	void printPattern2(int n){
		int num=1;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=i;j++){
				System.out.print(num++ +" ");
			}
			System.out.println("");
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

	void printPattern3(int n){
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
	public static void main(String[] args){
		Scanner input= new Scanner(System.in);
		int n= input.nextInt();
		Pattern obj = new Pattern();
		obj.printPattern1(n);
		obj.printPattern2(n);
		obj.printPattern3(n);
	}
}
