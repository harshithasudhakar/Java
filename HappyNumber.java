//Happy Number
import java.util.Scanner;

class HappyNumber {
    int n = 0;

    public void splitDigits(int x) {
        n = 0; // Reset the value of n
        while (x > 0) {
            int a = x % 10;
            x = x / 10;
            n += a * a;
        }
    }

    boolean isHappy() {
        int slow = n;
        int fast = n;

        do {
            splitDigits(slow);
            splitDigits(fast);
            splitDigits(fast);
        } while (slow != fast);

        return slow == 1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        HappyNumber obj = new HappyNumber();
        obj.splitDigits(x);
        System.out.println(obj.isHappy());
    }
}
