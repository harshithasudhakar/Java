//Area of  triangle
import java.util.Scanner;
class AOT{
	public static void main(String[] args){
		Scanner input= new Scanner(System.in);
		System.out.print("Enter the height: ");
		float h= input.nextFloat();
		System.out.print("Enter the base: ");
		float b= input.nextFloat();
		float area=0.5f*b*h;
		System.out.print("The area of the triangle is: "+area);
	}
}