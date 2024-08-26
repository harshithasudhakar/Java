import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SegmentedSieve {
    // Function to find all primes up to √n using Simple Sieve
    static ArrayList<Integer> simpleSieve(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        ArrayList<Integer> primes = new ArrayList<>();
        
        for (int p = 2; p * p <= limit; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= limit; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        for (int p = 2; p <= limit; p++) {
            if (isPrime[p]) {
                primes.add(p);
            }
        }
        
        return primes;
    }

    // Function to segment the range and mark non-primes
    static void segmentedSieve(int n) {
        int limit = (int) Math.sqrt(n);
        ArrayList<Integer> primes = simpleSieve(limit);
        
        // Print primes from the simple sieve
        for (int prime : primes) {
            System.out.print(prime + " ");
        }

        int low = limit + 1;
        int high = 2 * limit;

        while (low <= n) {
            if (high > n) {
                high = n;
            }
            
            boolean[] mark = new boolean[high - low + 1];
            Arrays.fill(mark, true);
            
            for (int prime : primes) {
                int lowLim = Math.max(prime * prime, low + (prime - low % prime) % prime);
                
                for (int j = lowLim; j <= high; j += prime) {
                    mark[j - low] = false;
                }
            }

            for (int i = low; i <= high; i++) {
                if (mark[i - low]) {
                    System.out.print(i + " ");
                }
            }

            low = low + limit;
            high = high + limit;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter num upti which primes are to be found: ");
        int n = input.nextInt();
        segmentedSieve(n);
    }
}
