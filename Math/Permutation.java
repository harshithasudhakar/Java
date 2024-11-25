import java.util.*;

class Permutation{

    static TreeSet<String> set = new TreeSet<>();

    public static void permute(char[] arr, int start, int end){
        
        if(start == end){
            //System.out.println(String.valueOf(arr));
            set.add(String.valueOf(arr));
        }

        else{
            for(int i = start; i<=end; i++){
                swap(arr, start, i);
                permute(arr, start+1, end);
                swap(arr, start, i);
            }
        }
    }

    static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n = input.nextInt();
        System.out.println("Enter the elements: ");
        char[] arr = new char[n];
        for(int i = 0; i<n; i++){
            arr[i] = input.next().charAt(0);
        }
        
        permute(arr, 0, n-1);

        for(String ele: set){
            System.out.println(ele);
        }

        input.close();
    }
}