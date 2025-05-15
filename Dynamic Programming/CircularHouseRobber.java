class CircularHouseRobber {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];

        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }

        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        //dp[0] = nums[0];

        return Math.max(linearRob(nums, dp, 0, nums.length-2), linearRob(nums, dp, 1, nums.length-1));
        
    }

    static int linearRob(int[] nums, int[] dp, int start, int end){
        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start], nums[start+1]);
        for(int i = start+2; i<=end; i++){
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return dp[end];
    }
}
