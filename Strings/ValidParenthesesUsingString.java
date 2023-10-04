import java.util.Scanner;

class ValidParenthesesUsingString{
    public static boolean isValid(String s) {
        StringBuilder check = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                check.append(ch);
            } else {
                if (check.length() == 0) {
                    return false;
                }

                char lastOpenChar = check.charAt(check.length() - 1);
                if ((ch == ')' && lastOpenChar == '(') || (ch == ']' && lastOpenChar == '[') || (ch == '}' && lastOpenChar == '{')) {
                    check.deleteCharAt(check.length() - 1);
                } else {
                    return false;
                }
            }
        }

        return check.length() == 0;
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        System.out.println(isValid(s));
    }
}
