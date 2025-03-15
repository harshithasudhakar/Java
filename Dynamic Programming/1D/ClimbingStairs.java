class ClimbingStairs {
    public int climbStairs(int n) { // Tabulation approach (Without recursion, 1D array)
        if(n < 2){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    // public int climbStairs(int n) { // Memoization Approach (Recursive)
    //     if(n == 0) return 1;
    //     if(n <= 2){
    //         return n;
    //     }
    //     return climbStairs(n-1) + climbStairs(n-2);
    // }
}
