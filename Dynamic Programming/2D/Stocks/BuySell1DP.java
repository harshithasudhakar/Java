import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class BuySell1DP{
    public static int maximumProfit(ArrayList<Integer> prices){
        int n = prices.size();

        int[] dp = new int[n];

        int min = prices.get(0);
        dp[0] = 0;

        for(int i = 1; i<n; i++){
            if(prices.get(i) > min){
                dp[i] = Math.max((prices.get(i)-min), dp[i-1]);
            }
            else{
                min = prices.get(i);
                dp[i] = dp[i-1];
            }
        }

        return dp[n-1];
    }
}
