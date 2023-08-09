//Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

import java.util.Scanner;
class ContainsDuplicate {
    public static boolean checkDuplicate(int[] nums) {
        int num, count=0;
        for(int i=0; i<nums.length; i++){
            num = nums[i];
            for(int j=i+1; j<nums.length; j++){
                if(num==nums[j]){
                    count+=1;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = input.nextInt();
        }
        System.out.println(checkDuplicate(nums));
    }
}
