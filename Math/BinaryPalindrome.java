import java.util.*;

public class BinaryPalindrome{
    
    public static boolean isBinaryPalindrome(int num){
        
        int revBinary = 0;
        int copyNum = num;
        
        while(copyNum != 0){
            revBinary = (revBinary<<1) | (copyNum & 1);
            copyNum >>= 1;
        }
        
        return (revBinary == num);
    }
    
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number: ");
        int num = input.nextInt();
        System.out.println(isBinaryPalindrome(num));
    }
}
