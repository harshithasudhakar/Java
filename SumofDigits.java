import java.util.Scanner;
class SumofDigits{
	static void calcsum(int n){
		int digit,sum=0;
		while(n>0){
			digit= n%10;
			sum+=digit;
			n=n/10;
		}
		System.out.println("The sum of the digits are: "+sum);
	}
	
	public static void main(String[] args){
		Scanner input= new Scanner(System.in);
		int n= input.nextInt();
		calcsum(n);
	}
}