//Checks if the given input is a Palindrome
import java.util.Scanner;

class Palindrome{
    public boolean isPalindrome(int x) {
        int y = x;
        int a,n = 0;
        while(x>0){
            a = x%10;
            x = x/10;
            n = (n*10)+a;
        }
        if(n==y){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        int x= input.nextInt();
        Palindrome obj = new Palindrome();
        System.out.println(obj.isPalindrome(x));
    }
}

