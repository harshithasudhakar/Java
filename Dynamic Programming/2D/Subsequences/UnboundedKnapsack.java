public class UnboundedKnapsack {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        
        int[][] dp = new int[n][w+1];

        for(int i = 0; i<n; i++){ //base case
            dp[i][0] = 0;
        }

        for(int j = 0; j<w+1; j++){ //base case
            dp[0][j] = (j/weight[0])*profit[0]; //profit[i] to find value each item will contribute
        }

        for(int i = 1; i<n; i++){
            for(int j = 1; j<w+1; j++){
                if(j>=weight[i]){
                    int notPick = dp[i-1][j];
                    int pick = profit[i]+dp[i][j-weight[i]];
                    dp[i][j] = Math.max(notPick, pick);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n-1][w];
    }
}
