//Lowest Element Of an Array

import java.util.Scanner;
import java.util.Arrays;

class LowestofArray {
    int[] arr;

    void inputArray(int n) {
        Scanner input = new Scanner(System.in);
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        System.out.println(Arrays.toString(arr));
    }

    void lowestElement() {
        int lowest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < lowest) {
                lowest = arr[i];
            }
        }
        System.out.println("The lowest element in the array is: " + lowest);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        LowestofArray obj = new LowestofArray();
        obj.inputArray(n);
        obj.lowestElement();
    }
}
