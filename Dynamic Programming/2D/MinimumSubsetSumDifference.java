public class MinimumSubsetSumDifference {
    public static int minSubsetSumDifference(int []arr, int n) {
        int k = 0;
        for(int i = 0; i<n; i++){
            k += arr[i];
        }

        int bestSubsetSum = (int) k/2;

        boolean dp[][] = new boolean[n][bestSubsetSum+1];

        for(int i = 0; i<n; i++){
            dp[i][0] = true;
        }

        for(int j = 0; j<bestSubsetSum+1; j++){
            if(j == arr[0]){
                dp[0][j] = true;
            }
        }

        for(int i = 1; i<n; i++){
            for(int j = 1; j<bestSubsetSum+1; j++){
                if(arr[i] == j){
                    dp[i][j] = true;
                }
                if(j >= arr[i]){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i]];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int s1 = 0;
        int s2 = 0;
        for(int j = 0; j<bestSubsetSum+1; j++){
            if(dp[n-1][j] == true){
                s1 = j;
                s2 = k-s1;
            }
        }
        return Math.abs(s1-s2);
    }
}
