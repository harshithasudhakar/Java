// Greatest Number of an Array

import java.util.Scanner;
import java.util.Arrays;

class GreatestofArray {
    int[] arr;

    void inputArray(int n) {
        Scanner input = new Scanner(System.in);
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        System.out.println(Arrays.toString(arr));
    }

    void greatestElement() {
        int greatest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > greatest) {
                greatest = arr[i];
            }
        }
        System.out.println("The greatest element in the array is: " + greatest);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        GreatestofArray obj = new GreatestofArray();
        obj.inputArray(n);
        obj.greatestElement();
    }
}
