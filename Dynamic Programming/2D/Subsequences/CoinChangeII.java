class CoinChangeII {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n][amount+1];

        for(int i = 0; i<n; i++){
            dp[i][0] = 1;
        }

        for(int j = 1; j<amount+1; j++){
            if(j != 0 && j%coins[0] == 0){
                dp[0][j] = 1;
            }
        }

        for(int i = 1; i<n; i++){
            for(int j = 1; j<amount+1; j++){
                if(j>=coins[i]){
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n-1][amount];
    }
}
