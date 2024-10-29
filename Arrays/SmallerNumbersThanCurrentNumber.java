import java.util.Scanner;

class SmallerNumbersThanCurrentNumber {
    public static int[] checksmallerNumbersThanCurrent(int[] nums) {
        int count = 0;
        int[] arr = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length; j++){
                if(nums[i]>nums[j]){
                    count+=1;
                }
            }
            arr[i] = count;
            count = 0;
        }
        return arr;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = input.nextInt();
        }
        checksmallerNumbersThanCurrent(nums);
    }
}
