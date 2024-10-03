import java.util.Scanner;

class LargestNumTwiceOfOthers {
    public static int dominantIndex(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int count = 0;
            for(int j = 0; j < nums.length; j++){
                if(i != j && nums[i] >= (2*nums[j])){
                    count ++;
                }
            }
            if(count == nums.length - 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i<n; i++){
            nums[i] = input.nextInt();
        }
        dominantIndex(nums);
    }
}
