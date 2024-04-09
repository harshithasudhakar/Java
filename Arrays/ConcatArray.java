class ConcatArray {
    public static int[] getConcatenation(int[] nums) {
        int[] ans = new int[2*nums.length];
        int j = 0;
        for(int i = 0; i<ans.length; i++){
            if(i<nums.length){
                ans[i] = nums[i];
            }
            if(i>=nums.length){
                ans[i] = nums[j];
                j++;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        getConcatenation(nums);
    }
}
