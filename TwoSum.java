import java.util.Scanner;

class TwoSum {
    
    public static int[] checkTwoSum(int[] nums, int target) {
        for(int i=0; i <nums.length; i++){
            for(int j= i+1; j<nums.length; j++){
                if(nums[i]+nums[j]==target){
                    int[] arr = {nums[i],nums[j]};
                    return arr;
                }
            }
        }
        throw new IllegalArgumentException("No two-sum solution");
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int target = input.nextInt();
        int n = input.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = input.nextInt();
        }
        checkTwoSum(nums, target);
    }
}