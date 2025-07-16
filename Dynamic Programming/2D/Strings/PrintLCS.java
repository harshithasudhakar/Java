public class PrintLCS {
    public static String findLCS(int n, int m, String s1, String s2){

        StringBuilder lcs = new StringBuilder();

        int[][] dp = new int[n+1][m+1];

        for(int i = 0; i<n+1; i++){
            dp[i][0] = 0;
        }

        for(int j = 0; j<m+1; j++){
            dp[0][j] = 0;
        }

        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<m+1; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
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
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                lcs.append(s1.charAt(i-1)); // or s2.charAt(j - 1), same thing
                i--;
                j--;
            }
            else{
                if(dp[i-1][j] > dp[i][j-1]){
                    i--;
                }
                else{
                    j--;
                }
            }
        }

        return lcs.reverse().toString();
    }
}
