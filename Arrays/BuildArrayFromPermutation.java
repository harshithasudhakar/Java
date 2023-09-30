import java.util.Scanner;

class BuildArrayFromPermutation {
    public static int[] buildArray(int[] nums) {
        int[] ans  = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i<n; i++){
            nums[i] = input.nextInt();
        }
        buildArray(nums);
    }
}
