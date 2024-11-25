import java.util.Scanner;

class Combination{

    static void combine(int[] nums, int count, int size, int start, String comb){
        if(count == size){
            System.out.println(comb);
        }
        else{
            for(int i = 0; i<nums.length; i++){
                combine(nums, count+1, size, i+1, comb+nums[i]+" ");
            }
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = input.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of array: ");
        for(int i = 0; i<n; i++){
            nums[i] = input.nextInt();
        }
        System.out.println("Enter r: ");
        int size = input.nextInt();
        combine(nums, 0, size, 0, "");
        input.close();
    }
}