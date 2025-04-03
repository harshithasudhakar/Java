//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Solution obj = new Solution();
            long topDownans = obj.topDown(n);
            long bottomUpans = obj.bottomUp(n);
            if (topDownans != bottomUpans)
                System.out.println(-1);
            else
                System.out.println(topDownans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class FibonacciSeries { // memoization and tabulation approaches
    
    static final int MOD = 1000000007;
    
    static long topDown(int n) {
        long[] dp = new long[n+1];
        
        Arrays.fill(dp, -1);
        
        return memoization(dp, n);
    }
    
    static long memoization(long[] dp, int n){ // TC: O(N) ; SC: O(N)+O(N) = O(2N) = O(N)
        if(n<=1){
            return n;
        }
        
        if(dp[n] != -1){
            return dp[n];
        }
        
        return dp[n] = (memoization(dp, n-1) + memoization(dp, n-2)) % MOD;
    }

    static long bottomUp(int n) { 
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        long[] dp = new long[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % MOD;
        }
        return dp[n];
    }

    static int spaceOptimized(int n){
        int prev1 = 0, prev2 = 1;
        int result = 0;
        for(int i = 0; i<n; i++){
            result = prev1 + prev2;
            prev1 = prev2;
            prev2 = result;
        }

        return result;
    }
    
}
