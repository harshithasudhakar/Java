class TwoSum {
    public int[] twoSumBrute(int[] nums, int target) { // brute-force O(n^2) time
        int n = nums.length;
        int[] result = new int[2];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if((nums[i]+nums[j]) == target && (i!=j)){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
    }

  public int[] twoSumHash(int[] nums, int target) { // 1-Hash approach O(n) time
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for(int i = 0; i<nums.length; i++){
            int complement = target-nums[i];
            if(map.containsKey(complement) && map.get(complement)!= i){
                result[0] = i;
                result[1] = map.get(complement);
                return result;
            }
            map.put(nums[i], i);
        }
  }
  
  return result;
}
