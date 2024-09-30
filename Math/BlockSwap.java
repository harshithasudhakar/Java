import java.util.Scanner;

class BlockSwap{
    static void swap(int n, int k, int[] arr){
        if(n == 0){
            return;
        }
        k = k % n;
        if(k > n){
            return;
        }

        int[] temp = new int[k];
        for(int i = 0; i < k; i++){
            temp[i] = arr[i];
        }
        for(int i = 0; i < n-k; i++){
            arr[i] = arr[i+k];
        }
        for(int i = n-k; i < n; i++){
            arr[i] = temp[i-n+k];
        }
    }

    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of array: ");
        for(int i = 0; i<n; i++){
            arr[i] = input.nextInt();
        }
        
        System.out.println("Enter k: ");
        int k = input.nextInt();
        swap(n, k, arr);

        System.out.println("The final array is: ");
        for(int i = 0; i<n; i++){
            System.out.print(arr[i]);
        }

        input.close();
    }
}
