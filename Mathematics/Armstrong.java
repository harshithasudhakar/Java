import java.util.Scanner;
class Armstrong{
	static void isArmstrong(int num){
		int digit,sum=0;
		int n=num;
		while(n>0){
			digit= n%10;
			sum+=digit*digit*digit;
			n=n/10;
		}
		System.out.println("The product is: "+sum);
		if(sum==num){
			System.out.println("True");
		}
		else{
			System.out.println("False");
		}
		
	}
	
	public static void main(String[] args){
		Scanner input= new Scanner(System.in);
		int num= input.nextInt();
		isArmstrong(num);
	}
}
