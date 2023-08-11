import java.util.Scanner;

class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        return arr[arr.length - 1].length();
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        System.out.println(lengthOfLastWord(s));
    }
}