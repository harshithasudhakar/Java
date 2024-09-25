import java.util.Scanner;

class EuclidsExtendedAlgorithm{

    static class Result{
        int x, y;
        Result(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int gcdCalc(int a, int b, Result result){
        
        if(a == 0){
            result.x = 0;
            result.y = 1;
            return b;
        }
        Result tempResult = new Result(1,1);
        int gcd = gcdCalc(b%a, a, tempResult);
        result.x = tempResult.y - (b/a) *tempResult.x;
        result.y = tempResult.x;
        return gcd;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a: ");
        int a = input.nextInt();
        System.out.println("Enter b: ");
        int b = input.nextInt();
        Result result = new Result(1,1);
        int g = gcdCalc(a, b, result);
        System.out.println("The GCD is: " + g);
        System.out.println("The value of x: " + result.x);
        System.out.println("The value of y: " + result.y);

        input.close();
    }
    
}
