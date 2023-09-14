import java.util.Scanner;
class NumbersWithEvenNumOfDigits{
    public static int findNumbers(int[] nums) {
        int count = 0;
        for(int i = 0; i<nums.length; i++){
            if(noofdigits(nums[i])%2==0){
                count+=1;
            }
        }
        return count;
    }
    static int noofdigits(int n){
		int digit;
        int count = 0;
		while(n>0){
			digit= n%10;
            count+=1;
			n=n/10;
		}
        return count;
	}
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i<n; i++){
            nums[i] = input.nextInt();
        }
        findNumbers(nums);
    }
}
