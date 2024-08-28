import java.util.*;

class EulerPhiAlgorithm {
    static int eulerPhi(int n){
        int result = n;
        for(int p = 2; p*p <= n; ++p){
            if(n%p ==0){
                while(n%p == 0){
                    n /= p;
                }
            }
            result -= result/p;
        }
        if(n>1){
            return result -= result/n;
        }
        return result;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 'n': ");
        int n = input.nextInt();
        System.out.println("Euler-phi value of n is: " + eulerPhi(n));
    }
}
