import java.util.Scanner;

public class BubbleSort {

    int temp;
    void swap(int[] arr){
        if(arr.length == 0){
            return;
        }
        else{
            System.out.println("The sorted array is: ");
            for(int i = 0; i<arr.length; i++){
                for(int j = i; j<arr.length; j++){
                    if(arr[i]>arr[j]){
                        temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
                System.out.print(arr[i] + " ");
            }
        }
    }
    public static void main(String[] args){
        BubbleSort bubbleSort = new BubbleSort();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the length of array: ");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of array: ");
        for(int i = 0; i<n; i++){
            arr[i] = input.nextInt();
        }
        bubbleSort.swap(arr);
    }
}
