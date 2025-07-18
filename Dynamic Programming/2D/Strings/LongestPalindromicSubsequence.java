class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();

        StringBuilder rev = new StringBuilder(s);
        rev.reverse().toString();

        int[][] dp = new int[n+1][n+1];

        for(int i = 0; i<n+1; i++){
            for(int j = 0; j<n+1; j++){
                if(i == 0){
                    dp[0][j] = 0;
                    continue;
                }
                if(j == 0){
                    dp[i][0] = 0;
                    continue;
                }

                if(s.charAt(i-1) == rev.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][n];
    }
}
