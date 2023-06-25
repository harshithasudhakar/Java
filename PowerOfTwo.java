//Given an integer n, return true if it is a power of two. Otherwise, return false.

import java.util.Scanner;
import java.lang.Math;

class PowerOfTwo{
    public boolean isPowerOfTwo(int n) {
        boolean a = false;
        for(int i=0;i<n;i++){
            if(n==Math.pow(2,i)){
                a = true;
                break;
            }
            else{
                a = false;
            }
        }
        return a;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n= input.nextInt();
        PowerOfTwo obj = new PowerOfTwo();
        System.out.println(obj.isPowerOfTwo(n));
    }
}