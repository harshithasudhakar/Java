import java.util.*;

class KaratsubaAlgorithm{

    static int karatsuba(int num1, int num2){
        
        if(num1 < 10 || num2 < 10){
            return num1*num2;
        }

        int m = Math.max(numLength(num1), numLength(num2));
        int halfM = (int) m/2;
        int powerOf10 = (int)Math.pow(10, halfM);
        int a = num1/powerOf10;
        int b = num1%powerOf10;
        int c = num2/powerOf10;
        int d = num2%powerOf10;
        int ac = karatsuba(a, c);
        int bd = karatsuba(b, d);
        int abcd = karatsuba(a+b, c+d);
        int product = (ac*(int)Math.pow(10,m)) + (abcd - ac - bd)*(int)Math.pow(10,halfM) + bd;
        return product;
    }

    static int numLength(int num){
        int count = 0;
        while(num > 0){
            num /= 10;
            count++;
        }
        return count;
    }
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number 1: ");
        int num1 = input.nextInt();
        System.out.println("Enter number 2: ");
        int num2 = input.nextInt();
        System.out.println("The product of the numbers is: " + karatsuba(num1, num2));
    }
}
