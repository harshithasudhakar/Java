import java.util.Scanner;

class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int count = nums.length;
        for(int i = 0; i<count; i++){
            if(nums[i]==0){
                count-=1;
                for(int j = i; j<count; j++){
                    nums[j]=nums[j+1];
                }
                nums[count]=0;
                i--;
            }
        }
        System.out.print(nums);
        }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = input.nextInt();
        }
        moveZeroes(nums);
    }
}