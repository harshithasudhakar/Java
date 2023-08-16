//Running Sum of 1d Array

import java.util.Scanner;

class RunningSum{
    public static int[] runningSum(int[] nums) {
        int[] arr = new int[nums.length];
        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            arr[i]=sum;
        }
        return arr;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i]=input.nextInt();
        }
        runningSum(nums);
    }
}