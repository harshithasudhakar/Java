class EditDistance {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i = 0; i<n+1; i++){
            for(int j = 0; j<m+1; j++){
                if(i == 0){
                    dp[0][j] = j;
                    continue;
                }
                if(j == 0){
                    dp[i][0] = i;
                    continue;
                }

                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.min(Math.min(1+dp[i-1][j-1], 1+dp[i-1][j]), 1+dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }
}
