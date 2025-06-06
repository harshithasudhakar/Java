import java.util.*;
import java.io.*; 
public class SubsetSumToK {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        boolean[][] dp = new boolean[n][k+1];

        for(int i = 0; i<n; i++){
            dp[i][0] = true; // can form sum 0 by not picking the 'i'th element
        }

        for(int j = 0; j<k+1; j++){
            if(j == arr[0]){
                dp[0][j] = true;
            }
        }

        for(int i = 1; i<n; i++){
            for(int j = 1; j<k+1; j++){
                if(arr[i]<=k){
                    dp[i][arr[i]] = true;
                }
                if(j>=arr[i]){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i]]; // not pick or pick. pick -> check remaining sum
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
                
            }
        }

        return dp[n-1][k];
    }
}
