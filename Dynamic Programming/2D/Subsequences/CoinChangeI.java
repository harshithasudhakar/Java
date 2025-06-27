class CoinChangeI { // Coin Change I 
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n][amount+1];

        // for(int i = 0; i<n; i++){
        //     dp[i][0] = 0;
        // }

        for(int j = 0; j<amount+1; j++){
            if(j % coins[0] == 0){
                dp[0][j] = j/coins[0];
            }
            else{
                dp[0][j] = (int)1e9;;
            }
        }

        for(int i = 1; i<n; i++){
            for(int j = 0; j<amount+1; j++){
                int notPick = dp[i-1][j];
                int pick = 0;
                if(coins[i]<=j){
                    pick = 1+dp[i][j-coins[i]];
                }
                else{
                    pick = (int)1e9;
                }
                dp[i][j] = Math.min(notPick, pick);
            }
        }

        return dp[n-1][amount] >= 1e9 ? -1 : dp[n-1][amount];
    }
}
