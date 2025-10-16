class SortArray {
    public int[] sortArray(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();

        for(int i = 0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        int pos = 0;
        for(int key : map.keySet()){
            int val = map.get(key);
            for(int i = 0; i<val; i++){
                nums[i+pos] = key;
            }
            pos = pos+val;
        }

        return nums;
    }
}
