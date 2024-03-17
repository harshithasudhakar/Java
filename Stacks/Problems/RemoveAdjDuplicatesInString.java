import java.util.Scanner;

class RemoveAdjDuplicatesInString {
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for(int i = 1; i<s.length(); i++){
            if(!stack.empty() && (s.charAt(i) == stack.peek())){
                stack.pop();
                continue;
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        return finalString(stack);
    }

    public static String finalString(Stack<Character> stack){
        StringBuilder string = new StringBuilder();
        while(!stack.empty()){
            string.append(stack.pop());
        }
        return string.reverse().toString();
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        removeDuplicates(s);
    }
}
