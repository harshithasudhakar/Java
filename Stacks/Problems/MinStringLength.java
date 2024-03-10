import java.util.Scanner;
import java.util.Stack;

class MinStringLength {
    public static int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for(int i = 1; i<s.length(); i++){
            if(!stack.isEmpty() && stack.peek() == 'A' && s.charAt(i) == 'B'){
                stack.pop();
                continue;
            }
            if(!stack.isEmpty() && stack.peek() == 'C' && s.charAt(i) == 'D'){
                stack.pop();
                continue;
            }
            else{
                stack.push(s.charAt(i));
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