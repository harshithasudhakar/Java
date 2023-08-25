//Can be done using binary search

import java.util.Scanner;

class PerfectSquare {
    public static boolean isPerfectSquare(int num) {
        boolean check = false;
		int n = num/2;
        if(num==1){
            return true;
        }
        for(int i = 1; i<=n; i++){   
            if(i*i==num){
                return true;
            }
        }
        return check;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        isPerfectSquare(num);
    }
}