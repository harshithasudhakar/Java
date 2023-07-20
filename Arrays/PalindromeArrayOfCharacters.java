//Palindrome for an array of characters

import java.util.Scanner;
import java.util.Arrays;

class PalindromeArrayOfCharacters {
    char arr[];

    void inputArray(int n) {
        Scanner input = new Scanner(System.in);
        arr = new char[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.next().charAt(0);
        }
    }

    void isPalindrome() {
        int n = arr.length;
        char[] revArr = new char[n];
        for (int j = 0; j < n; j++) {
            revArr[j] = arr[n - j - 1];
        }
        if (Arrays.equals(arr, revArr)) {
            System.out.println(Arrays.toString(arr) + " is a palindrome");
        } else {
            System.out.println(Arrays.toString(arr) + " is not a palindrome");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        PalindromeArrayOfCharacters obj = new PalindromeArrayOfCharacters();
        obj.inputArray(n);
        obj.isPalindrome();
    }
}
