class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int total = 0;

        if(nums.length == 1 && nums[0] == 0){
            return 2;
        }

        if(nums.length == 1 && nums[0]== Math.abs(target)){
            return 1;
        }
        
        if(nums.length == 1 && nums[0] != target){
            return 0;
        }

        for(int i = 0; i<n; i++){
            total += nums[i];
        }

        int k = 0;
        if (target > total || target < -total || (target + total) % 2 != 0) {
           return 0;
        }
        
        if((target+total)%2 == 0){
            k = (target+total)/2;
        }

        int[][] dp = new int[n][k+1];

        for(int i = 0; i<n; i++){
            dp[i][0] = 1;
        }

        if(nums[0] == 0){
            dp[0][0] = 2;
        }
        else{
            dp[0][0] = 1;
            if (nums[0] <= k) {
                dp[0][nums[0]] = 1;
            }
        }

        for(int i = 1; i<n; i++){
            for(int j = 0; j<k+1; j++){
                if(j>=nums[i]){
                    dp[i][j] = dp[i-1][j]+ dp[i-1][j-nums[i]];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n-1][k];
    }
}
