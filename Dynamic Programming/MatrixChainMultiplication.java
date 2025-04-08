import java.util.*;

class MatrixChainMultiplication{

    static int[][] split;
    static int[][] dp;

    static int mcm(int n, int[] arr){
        dp = new int[n][n];
        split = new int[n][n];
        for(int i = 0; i<n; i++){
            dp[i][i] = 0;
        }

        for(int i = n-1; i>=1; i--){
            for(int j = i+1; j<n; j++){
                int min = Integer.MAX_VALUE;
                for(int k = i; k<j; k++){
                    int step = arr[i-1]*arr[k]*arr[j] + dp[i][k] + dp[k+1][j];
                    if(step < min){
                        min = step;
                        split[i][j] = k; //Storing the points of split
                    }
                }
                dp[i][j] = min;
            }
        }

        return dp[1][n-1];
    }

    static void printOrder(int i, int j, StringBuilder sb){
        if(i == j){
            sb.append("M").append(i);
            return;
        }
        sb.append("(");
        printOrder(i, split[i][j], sb);
        printOrder(split[i][j]+1, j, sb);
        sb.append(")");
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = input.nextInt();
        }
        System.out.println("Minimum number of multiplications: " + mcm(n, arr));

        StringBuilder sb = new StringBuilder();
        printOrder(1, n-1, sb);
        System.out.print("Optimal Order: " + sb);
    }
}