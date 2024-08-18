import java.util.Scanner;

public class UpperBoundOfElement {
    public static int upperBound(int []arr, int x, int n){
        int low = 0;
        int high = n-1;
        int result = n;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]>x){
                result = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return result;        
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int x = input.nextInt();
        int[] arr = new int[n];
        for(int i =0; i<n; i++){
            arr[i] = input.nextInt();
        }
        upperBound(arr, x, n);
    }
}
