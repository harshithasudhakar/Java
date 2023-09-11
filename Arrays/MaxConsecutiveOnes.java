import java.util.Scanner;

class MaxConsecutiveOnes{
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 1;
        if(nums[0]==1 && nums.length==1){
            return 1;
        }
        for(int i = 0; i<nums.length-1; i++){
            if(nums[i]==nums[i+1]){
                count+=1;            
            }
            else{
                count = 1;
            }
            if(count>max){
                max = count;
            }
        }
        return max;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            int e = input.nextInt();
            if(e==1 || e==0){
                nums[i] = e;
            }
        }
        findMaxConsecutiveOnes(nums);
    }
}
