// Time Complexity: O(n log log n)
// Space Complexity: O(n)

// Algorithm:
/*  1. We take input of array of size n+1, set all elements to true.
    2. Start marking non-primes from 2, and mark the multiples of 2. [for prime p, start marking from p*p]
    3. Loop through the array for elements marked true and print them.
*/

import java.util.*;

class PrimeNumberUsingSimpleSieve{

    static void simpleSieve(boolean[] primes, int n){

        for(int p = 2; p*p <= n; p++){ //Start from p*p as the smaller multiples will be marked by the smaller primes
            if(primes[p]){
                for(int i = p*p; i<=n; i += p){ //Marking the multiples as false
                    primes[i] = false;
                }
            }
        }

        System.out.println("The primes are: ");
        for(int i = 2; i<= n; i++){
            if(primes[i]){
                System.out.print(i+ " ");
            }
        }

    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number upto which prime numbers have to be found: ");
        int n = input.nextInt();
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true); // Setting all values as true
        primes[0] = primes[1] = false; 

        simpleSieve(primes, n);

    }
}
