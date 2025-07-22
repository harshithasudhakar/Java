class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n+1][m+1];

        for(int i = 0; i<n+1; i++){
            dp[i][0] = 1;
        }

        for(int j = 0; j<m+1; j++){
            dp[0][j] = 0;
        }

        dp[0][0] = 1;

        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<m+1; j++){
                int pick = dp[i-1][j-1];
                int notPick = dp[i-1][j];
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = pick+notPick;
                }
                else{
                    dp[i][j] = notPick;
                }
            }
        }

        return dp[n][m];
    }
}
