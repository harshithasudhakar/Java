class AssignCookies { // 2D - DP Approach
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);
        
        int n = g.length;
        int m = s.length;

        int[][] dp = new int[n+1][m+1];

        // for(int i = 0; i<n; i++){  //Bases cases
        //     dp[i][0] = 0;
        // }

        // for(int j = 0; j<m; j++){
        //     dp[0][j] = 0;
        // }

        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<m+1; j++){
                if(s[j-1]>=g[i-1]){
                    dp[i][j] = Math.max(dp[i-1][j], 1+dp[i-1][j-1]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][m];
    }
}
