class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        if(nums.length == 1){
            return nums[0];
        }

        int max = 0;

        int count = 0;

        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 1){
                count += 1;
            }
            else{
                max = Math.max(max, count);
                count = 0;
            }
            max = Math.max(max, count);
        }

        return max;
    }
}
