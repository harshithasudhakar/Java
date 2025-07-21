class DeleteOperationsForTwoStrings {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n+1][m+1];

        if(word1.equals(word2)){
            return 0;
        }

        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<m+1; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int lcs = dp[n][m];
        return (n - lcs) + (m - lcs);
    }
}
