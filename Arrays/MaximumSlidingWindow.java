import java.util.Scanner;
import java.util.ArrayList;

class MaximumSlidingWindow{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter n : ");
        int n = input.nextInt();
        System.out.print("Enter k : ");
        int k = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of array: ");
        for(int i = 0; i<n; i++){
            arr[i] = input.nextInt();
        }

        if(n<k || k == 0){
            System.out.println("Invalid");
            return;
        }

        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i = 0; i<n-k+1; i++){
            int max = Integer.MIN_VALUE;
            for(int j = i; j<i+k; j++){
                max = Math.max(max, arr[j]);
            }
            result.add(max);
        }

        System.out.println("Result is: ");
        for(int i = 0; i<result.size(); i++){
            System.out.print(result.get(i)+ " ");
        }
    }
}
