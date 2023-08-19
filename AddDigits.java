import java.util.Scanner;

class AddDigits {
    public static int addDigits(int num) {
        int digit,sum=0;
        while(num>=10){
            while(num>0){
                digit= num%10;
                sum+=digit;
                num=num/10;
            }
            num=sum;
            sum=0;
        }
        return num;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        addDigits(num);
    }
}