import java.util.* ;
import java.io.*; 
public class PartitionsWithGivenDifference {
	public static int countPartitions(int n, int d, int[] arr) {
		int mod = 1000000007;

		int totalSum = 0;

		for(int i = 0; i<n; i++){
			totalSum += arr[i];
		}

		if((totalSum+d) % 2 != 0){
			return 0;
		}

		int s1 = (totalSum+d)/2;

		int[][] dp = new int[n][s1+1];

		for(int i = 0; i<n; i++){
			dp[i][0] = 1;
		}

		if(arr[0] == 0){
			dp[0][0] = 2;
		}
		
		if (arr[0] != 0 && arr[0] <= s1) {
			dp[0][arr[0]] = 1;
		}
		
		for(int i = 1; i<n; i++){
			for(int j = 0; j<s1+1; j++){
				int notPick = dp[i-1][j];
				int pick = 0;
				if(j>=arr[i]){
					pick = dp[i-1][j-arr[i]];
				}

				dp[i][j] = (pick + notPick)%mod;
			}
		}
		return dp[n-1][s1];
	}
}
