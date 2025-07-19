class ShortestCommonSupersequence {
    public String scs(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        if(str1.equals(str2)){
            return str1;
        }

        int[][] dp = new int[n+1][m+1];

        StringBuilder lcs = new StringBuilder();

        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<m+1; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int i = n;
        int j = m;
        while(i>0 && j>0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                lcs.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else{
                if(dp[i-1][j] > dp[i][j-1]){
                    lcs.append(str1.charAt(i-1));
                    i--;
                }
                else{
                    lcs.append(str2.charAt(j-1));
                    j--;
                }
            }
        }

        // Adding the remaining left-out characters 
        while(i>0){
            lcs.append(str1.charAt(i-1));
            i--;
        }
        while(j>0){
            lcs.append(str2.charAt(j-1));
            j--;
        }

        return lcs.reverse().toString();
    }
}
