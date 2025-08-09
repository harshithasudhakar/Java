class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] prefix = new int[n];
        prefix[0] = 1;
        prefix[1] = nums[0];
        
        for(int i = 2; i<n; i++){
            prefix[i] = prefix[i-1]*nums[i-1];
        }

        int[] suffix = new int[n];
        suffix[n-1] = 1;
        suffix[n-2] = nums[n-1];

        for(int i = n-3; i>=0; i--){
            suffix[i] = suffix[i+1]*nums[i+1];
        }

        for(int i = 0; i<n; i++){
            suffix[i] = prefix[i]*suffix[i];
        }

        return suffix;
    }
}
