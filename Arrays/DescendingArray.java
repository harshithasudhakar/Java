// Sorting Array in an Descending Order

import java.util.Scanner;
import java.util.Arrays;

class DescendingArray {
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
            int largest = i;
            for (int j = i + 1; j < l; j++) {
                if (arr[j] > arr[largest]) { // Change the comparison to >
                    largest = j;
                }
            }
            swap(i, largest); // Swap with the largest element
        }
        System.out.println("The greatest element in the array is: " + arr[0]); // The first element is the greatest in descending order
        System.out.println("The arranged array in descending order is: " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        DescendingArray obj = new DescendingArray();
        obj.inputArray(n);
        obj.arrange();
    }
}
