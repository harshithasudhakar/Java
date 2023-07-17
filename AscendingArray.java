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
        System.out.println(Arrays.toString(arr));
    }

    void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void arrange() {
        int l = arr.length;
        for (int i = 0; i < l; i++) {
            int greatest = i;
            for (int j = i + 1; j < l; j++) {
                if (arr[j] > arr[greatest]) {
                    greatest = j;
                }
            }
            swap(greatest, l - 1);
            l--;
        }
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


