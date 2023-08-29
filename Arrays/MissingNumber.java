import java.util.Scanner;

class MissingNumber{
    public static int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[smallest]) {
                    smallest = j;
                }
            }
            swap(nums, i, smallest);
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=i){
                return i;
            }
        }
        return nums.length;
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++){
            nums[i] = input.nextInt();
        }
        missingNumber(nums);
    }
}
