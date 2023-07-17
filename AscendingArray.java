// Sorting Array in an Ascending Order

import java.util.Scanner;
import java.util.Arrays;

class AscendingArray {
    int[] arr;

    void inputArray(int n) {
        Scanner input = new Scanner(System.in);
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        System.out.println("Input array: " + Arrays.toString(arr));
    }

    void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void arrange() {
        int l = arr.length;
        for (int i = 0; i < l - 1; i++) {
            int smallest = i; // Change variable name to "smallest"
            for (int j = i + 1; j < l; j++) {
                if (arr[j] < arr[smallest]) { // Change the comparison to <
                    smallest = j; // Change the assignment to "smallest"
                }
            }
            swap(i, smallest); // Swap with the smallest element
        }
        System.out.println("The greatest element in the array is: " + arr[arr.length - 1]); // The last element is the greatest
        System.out.println("The arranged array in ascending order is: " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        AscendingArray obj = new AscendingArray();
        obj.inputArray(n);
        obj.arrange();
    }
}


