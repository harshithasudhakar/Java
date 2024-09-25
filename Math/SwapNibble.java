import java.util.Scanner;

public class SwapNibble {
  
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number: ");
        int num = input.nextInt();
        int swapNum = ((num & 0x0F) << 4 | (num & 0xF0) >> 4);
        System.out.println("The number after swapping the nibble: " + swapNum);

        input.close();
    }    
}
