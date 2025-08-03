class MinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int s = 0;
        int e = nums.length-1;

        if(nums[s] <= nums[e]){
            return nums[s];
        }

        while(s < e){
            int mid = s + (e-s)/2;
            if(nums[mid] > nums[e]){ // min lies in the right side
                s = mid+1;
            }
            else{ // min lies in the left side
                e = mid;
            }
        }

        return nums[s];
    }
}
