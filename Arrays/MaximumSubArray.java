class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum = nums[0];
        int maxSum = nums[0];

        for(int i = 1; i<n; i++){
            sum = Math.max(sum+nums[i], nums[i]);
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }
}
