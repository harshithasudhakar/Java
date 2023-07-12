//No.of occurences of an element in an array

import java.util.Scanner;
import java.util.Arrays;

class OccurencesofElement{
	int[] arr;
	Scanner input = new Scanner(System.in);
	
	void inputArray(int n) {
        arr = new int[n];
		System.out.println("Enter the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        System.out.println(Arrays.toString(arr));
    }
	
	int count=0;
	void noofOccurences(){
		System.out.println("Enter the element: ");
		int element = input.nextInt();
		for(int i = 0; i < arr.length; i++){
			if(element==arr[i]){
				count+=1;
			}
		}
		System.out.println("The number of occurences of the element in the given array is: "+count);
	}
	
	public static void main(String[] args){
		Scanner input= new Scanner(System.in);
		System.out.println("Enter no.of elements in the array: ");
		int n=input.nextInt();
		int[] arr= new int[n];
		OccurencesofElement obj= new OccurencesofElement();
		obj.inputArray(n);
		obj.noofOccurences();
	}
}