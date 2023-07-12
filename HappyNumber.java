//Happy Number
import java.util.Scanner;

class HappyNumber{
	int x;
    int a,n = 0;
	public void splitDigits(int x){
        while(x>0){
            a = x%10;
            x = x/10;
            n += a*a;
		}
	}
	
	boolean isHappy(){
        int slow = n;
        int fast = n;

        do {
            splitDigits(slow);
            splitDigits(fast);
            splitDigits(fast);
        } while (slow != fast);

        return slow==1;
    }
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        HappyNumber obj = new HappyNumber();
		obj.splitDigits(x);
        System.out.println(obj.isHappy());
	}
}