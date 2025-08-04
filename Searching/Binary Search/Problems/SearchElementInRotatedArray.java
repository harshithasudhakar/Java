class SearchElementInRotatedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int low = 0;
        int high = n-1;
        int mid = low + (high-low)/2;

        if(nums.length == 1 && target == nums[0]){
            return 0;
        }

        while(low<=high){
            mid = low + (high-low)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid]>nums[high]){
                if(nums[mid] > target && target>=nums[low]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else{
                if(nums[mid] < target && target <= nums[high]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
            
        }

        return -1;
    }
}
