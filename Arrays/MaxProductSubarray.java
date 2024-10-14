import java.util.*;

// Time Complexity : O(n)
// Space Complexity : O(1)


class MaxProductSubarray{

    static int findMaxProd(int[] arr){
        int p = 1;
        int s = 1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++){
            if(p == 0){
                p = 1;
            }
            if(s == 0){
                s = 1;
            }

            p *= arr[i];
            s *= arr[arr.length - 1 - i];

            max = Math.max(max,Math.max(p,s));
        }

        return max;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of array: "); //4,1,0,9,8,-1,9,9
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }
        System.out.println("Max Product: " + findMaxProd(arr)); //81
    }
}