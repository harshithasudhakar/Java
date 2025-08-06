class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> sum = new ArrayList<List<Integer>>();

        for(int i = 0; i<nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int s = i+1;
            int e = nums.length-1;
            int comp = -nums[i];
            while(s<e){
                if(nums[s]+nums[e] == comp){
                    List<Integer> innerList = new ArrayList<Integer>();
                    innerList.add(nums[i]);
                    innerList.add(nums[s]);
                    innerList.add(nums[e]);
                    System.out.println(innerList);
                    sum.add(innerList);
                    while (s < e && nums[s] == nums[s + 1]) s++;
                    while (s < e && nums[e] == nums[e - 1]) e--;

                }
                if(nums[s] + nums[e] < comp){
                    s++;
                }
                else{
                    e--;
                }
            }
        }

        return sum;
    }
}
