// Recursive Approach

import java.util.Scanner;

class JosephusTrap {
    public static int findTheWinner(int n, int k) {
        if(n == 1){
            return n;
        }
        return (findTheWinner(n-1,k) + k-1) % n+1;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        findTheWinner(n, k);
    }
}
