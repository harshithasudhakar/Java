import java.util.Scanner;

class PerfectNumber {
    public static boolean checkPerfectNumber(int num) {
        int sum = 0;
        for(int i=1; i<num; i++){
            if(num%i==0){
                sum+=i;
            }
        }
        if(sum==num){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        checkPerfectNumber(num);
    }
}