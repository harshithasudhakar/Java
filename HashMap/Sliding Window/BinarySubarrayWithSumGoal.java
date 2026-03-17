class BinarySubarrayWithSumGoal { //Hashmap approach
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int[] prefixSum = new int[n];

        prefixSum[0] = nums[0];
        for(int i = 1; i<n; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int i = 0; i<n; i++){
            int remaining = prefixSum[i] - goal;
            if(map.containsKey(remaining)){
                count += map.get(remaining);
            }
            map.put(prefixSum[i], map.getOrDefault(prefixSum[i], 0) + 1);
        }

        return count;
    }
}
