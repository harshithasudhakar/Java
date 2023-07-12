//Happy Number
import java.util.Scanner;

class HappyNumber {
    int n = 0;

    public int splitDigits(int x) {
        n = 0; // Resetting n to 0 before splitting the digits
        while (x > 0) {
            int a = x % 10;
            x = x / 10;
            n += a * a;
        }
        return n;
    }

    public boolean isHappy() {
        int slow = n;
        int fast = n;

        do {
            slow = splitDigits(slow);
            fast = splitDigits(splitDigits(fast));
        } while (slow != fast);

        return slow == 1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        HappyNumber obj = new HappyNumber();
        obj.splitDigits(x);
        boolean isHappy = obj.isHappy();

        if (isHappy) {
            System.out.println(x + " is a happy number");
        } else {
            System.out.println(x + " is not a happy number");
        }
    }
}
