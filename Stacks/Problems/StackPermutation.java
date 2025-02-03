import java.util.*;

class StackPermutation{

    static boolean isPermutation(int[] arr1, int[] arr2){
        Stack<Integer> stk = new Stack<>();
        int j = 0;

        for(int i = 0; i<arr1.length; i++){
            stk.push(arr1[i]);
            while(!stk.isEmpty() && stk.peek() == arr2[j]){
                stk.pop();
                j++;
            }
        }

        return stk.isEmpty();
    }


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr1 = new int[n];
        System.out.println("Enter elements for arr1: ");
        for(int i = 0; i<n; i++){
            arr1[i] = input.nextInt();
        }
        int[] arr2 = new int[n];
        System.out.println("Enter elements for arr2: ");
        for(int i = 0; i<n; i++){
            arr2[i] = input.nextInt();
        }

        System.out.println(isPermutation(arr1, arr2));
    }
}
