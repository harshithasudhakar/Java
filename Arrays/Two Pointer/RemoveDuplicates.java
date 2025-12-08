class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;

        while(j <= nums.length-1){
            if(nums[i] != nums[j]){
                nums[i+1] = nums[j];
                i += 1;
            }
            j += 1;
        }

        return i+1;
    }
}
