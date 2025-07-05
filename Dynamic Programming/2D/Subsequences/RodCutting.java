public class RodCutting {
	public static int cutRod(int price[], int n) {
		int[][] dp = new int[n][n+1];

		for(int i = 0; i<n; i++){
			dp[i][0] = 0;
		}

		for(int j = 0; j<n+1; j++){
			dp[0][j] = price[0]*j;
		}

		for(int i = 1; i<n; i++){
			for(int j = 1; j<n+1; j++){
				if((i+1)<=j){
					dp[i][j] = Math.max(dp[i-1][j], price[i]+dp[i][j-(i+1)]);
				}
				else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}

		return dp[n-1][n];
	}
}
