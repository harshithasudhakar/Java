import java.util.*;

class PrimeNumberUsingIncrementalSieve{

    static void incrementalSieve(int n){
        List<Integer> primes = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        primes.add(2); //Only even prime
        
        for(int i = 3; i<=n; i+=2){ //Addding the odd numbers
            odd.add(i);
        }
        for(int i = 0; i < odd.size(); i++){
            int temp = odd.get(i);
            if(temp != -1){
                primes.add(temp);
                for(int j = i; j < odd.size(); j++){
                    if(odd.get(j) % temp == 0){
                        odd.set(j, -1);
                    }
                }
            }
        }

        printPrimes(primes);

    }

    static void printPrimes(List<Integer> primes){
        System.out.println("The primes are: ");
        for(int i = 0; i < primes.size(); i++){
            System.out.print(primes.get(i) + " ");
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number upto which primes are to be found: ");
        int n = input.nextInt();
        incrementalSieve(n);
    }
}
