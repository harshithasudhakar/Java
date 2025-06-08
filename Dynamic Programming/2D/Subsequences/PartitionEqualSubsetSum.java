class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {

        int n = nums.length;

        int k = 0; // total possible sum
    		for(int i = 0; i<n; i++){
    			k += nums[i];
    		}
    
    		if(k%2 != 0){
    			return false;
    		}
    
    		int subsetSum = k/2;
    
    		boolean dp[][] = new boolean[n][subsetSum+1];
    
    		for(int i = 0; i<n; i++){
    			dp[i][0] = true;
    		}
    
    		for(int j = 0; j<subsetSum; j++){
    			if(j == nums[0]){
    				dp[0][j] = true;
    			}
    		}
    
    		for(int i = 1; i<n; i++){
    			for(int j = 1; j<subsetSum+1; j++){
    				if(nums[i]<=subsetSum){
                        dp[i][nums[i]] = true;
                    }
    				if(j>=nums[i]){
    					dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
    				}
    				else{
    					dp[i][j] = dp[i-1][j];
    				}
    			}
    		}

		    return dp[n-1][subsetSum];
    }
}
