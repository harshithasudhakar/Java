import java.util.*;

class MaxEquilibriumSum{
    
    static int findEquilibrium(int[] arr){
        int sum = 0;
        int restSum = 0;
        for(int i = 0; i<arr.length; i++){
            restSum += arr[i];
        }

        for(int i = 0; i<arr.length; i++){
            if(sum == restSum){
                System.out.println("The sum is: " + sum);
                return i;
            }
            sum += arr[i];
            restSum -= arr[i];
        }
        return -1;
    }
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n ;  i++){
            arr[i] = input.nextInt(); //3, 1, 2, 5, 6, 3, 2
        }
        
        System.out.println(findEquilibrium(arr));
    }
}