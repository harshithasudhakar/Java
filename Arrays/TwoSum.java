class TwoSum {
    /*
    public int[] twoSumBrute(int[] nums, int target) { // Brute-force
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];

        for(int i = 0; i<nums.length; i++){
            int complement = target-nums[i];
            if(map.containsKey(complement) && map.get(complement)!= i){
                res[0] = i;
                res[1] = map.get(complement);
                return res;
            }
            map.put(nums[i], i);
        }

        return res;
    }
    */

    public int[] twoSumHash(int[] nums, int target) { // 1-Hash approach
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];

        for(int i = 0; i<nums.length; i++){
            int complement = target-nums[i];
            if(map.containsKey(complement) && map.get(complement)!= i){
                res[0] = i;
                res[1] = map.get(complement);
                return res;
            }
            map.put(nums[i], i);
        }

        return res;
    }
}
