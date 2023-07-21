//Pascal's Triangle

/*
        1
      1   1
    1   2   1
  1   3   3   1
1   4   6   4   1

*/

import java.util.Scanner;

class PascalsTriangle {

    void pTriangle(int n) {
        for (int row = 0; row < n; row++) {
            int num = 1;
            System.out.printf("%" + (n - row) * 2 + "s", ""); // Print leading spaces
            for (int i = 0; i <= row; i++) {
                System.out.printf("%4d", num);
                num = num * (row - i) / (i + 1);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows for Pascal's Triangle: ");
        int n = input.nextInt();
        PascalsTriangle obj = new PascalsTriangle();
        obj.pTriangle(n);
    }
}
