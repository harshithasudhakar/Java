// Finds a unique solution that satifies a set of congruences, given that the moduli of the congruences are co-prime

import java.util.*;

class ChineseRemainderTheorem{

    static int CRT(int[] a, int[] m, int M, int n){
        int x = 0;
        for(int i = 0; i< n; i++){
            int Mi = M/m[i];
            int y = 0;
            for(int j = 1; j < m[i]; j++){
                if((Mi*j)%m[i] == 1){
                    y = j;
                    break;
                }
            }
            x = x + (a[i]*Mi*y);
        }

        return x%M;

    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of congruences: ");
        int n = input.nextInt(); //No.of Congruences
        int[] a = new int[n]; //Remainders
        System.out.println("Enter the remainders: ");
        for(int i = 0; i < n; i++){
            a[i] = input.nextInt();
        }
        int[] m = new int[n]; //Moduli
        int M = 1;
        System.out.println("Enter the Moduli(s): ");
        for(int i = 0; i < n; i++){
            m[i] = input.nextInt();
            M = M*m[i];
        }
        
        System.out.println("x = " + CRT(a, m, M, n));
    }
}
