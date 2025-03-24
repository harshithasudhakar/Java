import java.util.Scanner;

class WinnerTree{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] leaves = new int[n];
        for(int i = 0; i<n; i++){
            leaves[i] = input.nextInt();
        }

        int[] tree = new int[2*n-1];
        for(int i = 0; i<n; i++){
            tree[n-1+i] = i;
        }
        for(int i = n-2; i>=0; i--){
            int left = tree[2*i+1];
            int right = tree[2*i+2];
            tree[i] = leaves[left]>leaves[right] ? left : right;
        }
        System.out.print("The winner is: " +tree[0]);
    }
}
