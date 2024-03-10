import java.util.Scanner;
import java.util.Stack;

class MinStringLength {
    public static int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            stack.push(s.charAt(i));
            if(s.charAt(i) == 'A' && s.charAt(i+1) == 'B'){
                stack.pop();
                i++; 
                continue;
            }
            if(s.charAt(i) == 'C' && s.charAt(i+1) == 'D'){
                stack.pop();
                i++; 
                continue;
            }
        }
        return lengthOfStack(stack);
    }

    public static int lengthOfStack(Stack<Character> stack){
        int min_length = 0;
        while(stack.empty() == false){
            stack.pop();
            min_length += 1;
        }
        return min_length;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        minLength(s);
    }
}
