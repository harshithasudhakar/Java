class containsDuplicateHashSet {
    public boolean containsNearbyDuplicateHashSet(int[] nums, int k) { // Optimal Solution using HashSet

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i<nums.length; i++){
            if(i >= k+1){
                set.remove(nums[i-k-1]);
                if(!set.contains(nums[i])){
                    set.add(nums[i]);
                }
                else{
                    return true;
                }
            }
            else if(i<k+1){
                if(!set.contains(nums[i])){
                    set.add(nums[i]);
                }
                else{
                    return true;
                }
            }
        }

        return false;
    }
}
