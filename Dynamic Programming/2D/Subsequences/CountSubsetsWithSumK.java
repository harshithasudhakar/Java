import java.util.*;
import java.io.*;

public class CountSubsetsWithSumK { //Assuming the elements of the array are positive integers
    public static int findWays(int num[], int tar) {
        int n = num.length;
        int mod = 1000000007;

        int[][] dp = new int[n][tar+1];

        for(int i = 0; i<n; i++){
            dp[i][0] = 1;
        }

        if(num[0]<= tar){
            dp[0][num[0]] = 1;
        }

        if(num[0] == 0){
            dp[0][0] = 2;
        }

        for(int i = 1; i<n; i++){
            for(int j = 0; j<tar+1; j++){
                int notPick = dp[i-1][j];
                int pick = 0;
                if(j>=num[i]){
                    pick = dp[i-1][j-num[i]];
                }
                dp[i][j] = (pick + notPick) % mod;
            }
        }

        return dp[n-1][tar];
    }
}
